package com.groupa15.controller;

import com.groupa15.common.Response;
import com.groupa15.entity.vo.GuideTypeVO;
import com.groupa15.entity.vo.GuideVO;
import com.groupa15.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Zirui Zhou
 * @date 2022/4/17
 */

@RestController
public class GuideController {

    @Autowired
    GuideService guideService;

    @GetMapping(value = "/guide", params = "type")
    public Response getGuideListOfType(@RequestParam(name = "type") Long type) {
        List<GuideVO> guideList = guideService.getGuideOfType(type);
        return Response.success(HttpStatus.OK, "Get the guide list", guideList);
    }

    @GetMapping("/guide/types")
    public Response getGuideTypeList(@RequestHeader(value = "Accept-Language", defaultValue = "en") String lang) {
        List<GuideTypeVO> guideTypeList = guideService.getGuideType(lang);
        return Response.success(HttpStatus.OK, "Get the guide list", guideTypeList);
    }

    @GetMapping(value = "/guide/type", params = "id")
    public Response getGuideType(@RequestHeader(value = "Accept-Language", defaultValue = "en") String lang, @RequestParam(name = "id") Long typeId) {
        GuideTypeVO guideType = guideService.getGuideTypeById(typeId, lang);
        return Response.success(HttpStatus.OK, "Get the guide type Info", guideType);
    }
}
