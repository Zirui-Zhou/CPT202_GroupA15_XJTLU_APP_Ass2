package com.groupa15.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Zirui Zhou
 * @date 2022/4/8
 */

@Data
public class TagTypeVO implements Serializable {

    private String typeName;

    private List<String> tagName;

}
