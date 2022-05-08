package com.groupa15.entity.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Zirui Zhou
 * @date 2022/5/8
 */

@Data
public class EditArticleDto implements Serializable {

    private Long id;

    private String title;

    private String image;

    private String content;

    private int typeId;

}
