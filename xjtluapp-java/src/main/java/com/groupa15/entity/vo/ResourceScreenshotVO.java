package com.groupa15.entity.vo;

import lombok.Data;

import java.util.List;

/**
 * @author Zirui Zhou
 * @date 2022/4/16
 */

@Data
public class ResourceScreenshotVO {

    private Long resourceId;

    private String resourceName;

    private String resourceImage;

    private String resourcePath;

    private List<Integer> resourceTagList;

}
