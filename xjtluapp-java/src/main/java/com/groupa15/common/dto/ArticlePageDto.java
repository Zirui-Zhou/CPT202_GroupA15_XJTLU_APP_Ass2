package com.groupa15.common.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Zirui Zhou
 * @date 2022/4/5
 */

@Data
public class ArticlePageDto implements Serializable {
    private int current;

    private int size;
}
