package com.groupa15.controller;

import com.groupa15.common.Response;
import com.groupa15.common.dto.ArticlePageDto;
import com.groupa15.common.dto.ResourcePageDto;
import com.groupa15.entity.vo.ArticleScreenshotVO;
import com.groupa15.entity.vo.ResourceScreenshotVO;
import com.groupa15.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Zirui Zhou
 * @date 2022/4/16
 */

@RestController
public class ResourceController {

    @Autowired
    ResourceService resourceService;

    @PostMapping("/resource/list")
    public Response getArticleList(@RequestBody ResourcePageDto resourcePageDto) {
        List<ResourceScreenshotVO> resourceList = resourceService.getResourcePage(resourcePageDto);
        return Response.success(HttpStatus.OK, "Get the resource list", resourceList);
    }

}
