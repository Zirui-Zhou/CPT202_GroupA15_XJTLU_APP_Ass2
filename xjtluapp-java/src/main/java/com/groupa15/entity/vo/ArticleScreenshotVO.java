package com.groupa15.entity.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Zirui Zhou
 * @date 2022/4/8
 */

@Data
public class ArticleScreenshotVO implements Serializable {

    private Long id;

    private String title;

    private String image;

    private LocalDateTime createTime;

    private LocalDateTime editTime;

    private Long editorId;

    private String editorName;

    private String avatar;

    private Boolean isFavourite;

    private int typeId;

}
