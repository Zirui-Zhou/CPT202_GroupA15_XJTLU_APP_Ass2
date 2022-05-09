package com.groupa15.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Zirui Zhou
 * @date 2022/5/9
 */

@Data
public class ArticleVO implements Serializable {

    private Long id;

    private String title;

    private String image;

    private String content;

    private LocalDateTime createTime;

    private LocalDateTime editTime;

    private Long editorId;

    private Integer typeId;

}
