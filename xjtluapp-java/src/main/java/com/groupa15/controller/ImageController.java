package com.groupa15.controller;

import com.groupa15.common.Response;
import com.groupa15.entity.UserInfo;
import com.groupa15.service.UserInfoService;
import com.groupa15.service.UserService;
import com.groupa15.utils.ImageUtils;
import com.groupa15.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * @author Zirui Zhou
 * @date 2022/4/6
 */

@RestController
public class ImageController {

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    ImageUtils imageUtils;

    @Autowired
    UserService userService;

    @Autowired
    UserInfoService userInfoService;

    @PostMapping("/user/avatar/upload")
    public Response upload(@RequestHeader(name="Authorization") String token, @RequestParam(name = "file", required = false) MultipartFile file) {
        String resourcePath = "/image/avatar";
        String avatarPath = "";

        Response preHandleResult = preHandleImage(file);
        if(preHandleResult != null)
            return preHandleResult;

        try{
            avatarPath = imageUtils.saveFile(file, resourcePath);
        }catch (Exception e) {
            return Response.fail(HttpStatus.FORBIDDEN, "保存文件异常");
        }

        Long userId = jwtUtils.getUserIdByToken(token);

        String oldFilename = userService.getUserInfoByUserId(userId).getAvatar();
        imageUtils.deleteFile(oldFilename, resourcePath);

        UserInfo userInfo = new UserInfo()
                .setUserId(userId)
                .setAvatar(avatarPath);
        userInfoService.updateUserInfo(userInfo);

        return Response.success(HttpStatus.OK, avatarPath);
    }

    @PostMapping("/article/image/upload")
    public Response uploadArticleImage(@RequestParam(name = "file", required = false) MultipartFile file) {
        String targetPath = "/image/article/screenshot";
        String imagePath = "";

        Response preHandleResult = preHandleImage(file);
        if(preHandleResult != null)
            return preHandleResult;

        try{
            imagePath = imageUtils.saveFile(file, targetPath);
        }catch (Exception e) {
            return Response.fail(HttpStatus.FORBIDDEN, "保存文件异常");
        }

        return Response.success(HttpStatus.OK, imagePath);
    }

    private Response preHandleImage(MultipartFile file) {
        if (file == null) {
            return Response.fail(HttpStatus.BAD_REQUEST, "Please select a image to upload.");
        }
        if (file.getSize() > 1024 * 1024 * 5) {
            return Response.fail(HttpStatus.BAD_REQUEST, "The size of the image cannot exceed 10Mb.");
        }
        if (!"jpg,jpeg,gif,png".toUpperCase().contains(imageUtils.getFileSuffix(file.getOriginalFilename()).toUpperCase())) {
            return Response.fail(HttpStatus.BAD_REQUEST, "请选择jpg,jpeg,gif,png格式的图片");
        }
        return null;
    }

}
