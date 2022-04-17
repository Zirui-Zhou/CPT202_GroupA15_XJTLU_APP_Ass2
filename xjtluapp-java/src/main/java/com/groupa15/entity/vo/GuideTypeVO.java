package com.groupa15.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Zirui Zhou
 * @date 2022/4/17
 */

@Data
public class GuideTypeVO implements Serializable {

    private Long typeId;

    private String typeName;

    private String typeImage;

}
