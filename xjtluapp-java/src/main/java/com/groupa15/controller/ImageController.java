package com.groupa15.controller;

import com.groupa15.common.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * @author Zirui Zhou
 * @date 2022/4/6
 */

@RestController
public class ImageController {
    @PostMapping("/upload")
    public Response upload(@RequestParam(name = "file", required = false) MultipartFile file) {
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
        String savePath = "D:/image/";
        File savePathFile = new File(savePath);
        if (!savePathFile.exists()) {
            //若不存在该目录，则创建目录
            savePathFile.mkdir();
        }
        //通过UUID生成唯一文件名
        String filename = UUID.randomUUID().toString().replaceAll("-","") + "." + suffix;
        try {
            //将文件保存指定目录
            file.transferTo(new File(savePath + filename));
        } catch (Exception e) {
            e.printStackTrace();
            return Response.fail(HttpStatus.FORBIDDEN, "保存文件异常");
        }
        //返回文件名称
        // TODO(Zirui): Convert the constant into a configuration variable.
        return Response.success(HttpStatus.OK, "http://localhost:8081/static/" + filename);
    }
}
