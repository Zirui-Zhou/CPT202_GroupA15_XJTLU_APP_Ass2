package com.groupa15.controller;

import com.groupa15.common.Response;
import com.groupa15.entity.User;
import com.groupa15.entity.UserInfo;
import com.groupa15.service.UserInfoService;
import com.groupa15.service.UserService;
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
    UserService userService;

    @Autowired
    UserInfoService userInfoService;

    @PostMapping("/upload")
    public Response upload(@RequestHeader(name="Authorization") String token, @RequestParam(name = "file", required = false) MultipartFile file) {
        if (file == null) {
            return Response.fail(HttpStatus.BAD_REQUEST, "Please select a image to upload.");
        }
        if (file.getSize() > 1024 * 1024 * 10) {
            return Response.fail(HttpStatus.BAD_REQUEST, "The size of the image cannot exceed 10Mb.");
        }
        //获取文件后缀
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
        if (!"jpg,jpeg,gif,png".toUpperCase().contains(suffix.toUpperCase())) {
            return Response.fail(HttpStatus.BAD_REQUEST, "请选择jpg,jpeg,gif,png格式的图片");
        }

        Path path = Paths.get(System.getProperties().getProperty("user.dir")).getParent();
        String subPath = "/image/avatar";
        String resourcePath = Paths.get(path.toString(), "/resource").toString();
        String avatarPath = Paths.get(resourcePath.toString(), subPath).toString();

        File avatarPathFile = new File(avatarPath);
        if (!avatarPathFile.exists()) {
            //若不存在该目录，则创建目录
            System.out.println(avatarPathFile.mkdirs());
            System.out.println("In");
        }
        //通过UUID生成唯一文件名
        String filename = UUID.randomUUID().toString().replaceAll("-","") + "." + suffix;
        try {
            //将文件保存指定目录
            file.transferTo(new File(avatarPath + "/" + filename));
        } catch (Exception e) {
            e.printStackTrace();
            return Response.fail(HttpStatus.FORBIDDEN, "保存文件异常");
        }
        //返回文件名称
        // TODO(Zirui): Convert the constant into a configuration variable.
        Long userId = jwtUtils.getUserIdByToken(token);

        String oldFilename = userService.getUserInfoByUserId(userId).getAvatar();
        if(StringUtils.hasLength(oldFilename)){
            new File(resourcePath + oldFilename).delete();
        }

        UserInfo userInfo = new UserInfo()
                .setUserId(userId)
                .setAvatar(subPath + "/" + filename);
        userInfoService.updateUserInfo(userInfo);

        return Response.success(HttpStatus.OK, subPath + "/" + filename);
    }
}
