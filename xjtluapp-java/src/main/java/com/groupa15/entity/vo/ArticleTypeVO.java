package com.groupa15.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Zirui Zhou
 * @date 2022/4/15
 */

@Data
public class ArticleTypeVO implements Serializable {

    private Integer typeId;

    private String typeName;

    private String typeIcon;

}
