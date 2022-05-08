package com.groupa15.utils;

import com.groupa15.common.Response;
import com.groupa15.entity.UserInfo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * @author Zirui Zhou
 * @date 2022/5/8
 */

@Component
public class ImageUtils {

    public String getResourcePath() {
        Path path = Paths.get(System.getProperties().getProperty("user.dir"));
        return Paths.get(path.toString(),  "/resource").toString();
    }

    public String getFileSuffix(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    public String saveFile(MultipartFile file, String targetPath) throws Exception{
        String imagePath = this.getResourcePath() + targetPath;

        File avatarPathFile = new File(imagePath);
        if (!avatarPathFile.exists()) {
            avatarPathFile.mkdirs();
        }

        String filename = UUID.randomUUID() + "." + getFileSuffix(file.getOriginalFilename());
        file.transferTo(new File(imagePath + "/" + filename));

        return targetPath + "/" + filename;
    }

    public void deleteFile(String fileName, String targetPath){
        if(StringUtils.hasLength(fileName)){
            new File(this.getResourcePath() + targetPath + fileName).delete();
        }
    }

}
