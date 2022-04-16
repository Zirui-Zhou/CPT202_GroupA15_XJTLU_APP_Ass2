package com.groupa15.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Zirui Zhou
 * @date 2022/4/16
 */

@Data
public class ResourceTagListVO implements Serializable {

    private String typeName;

    private List<ResourceTagVO> tagList;

}
