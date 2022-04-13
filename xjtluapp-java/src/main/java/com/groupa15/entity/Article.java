package com.groupa15.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author Qi Xu
 * @date 2022/4/5
 */

@Data
@Accessors(chain = true)
public class Article {
        @TableId
        private Long id;

        private String title;

        private String image;

        private String content;

        private LocalDateTime createTime;

        private LocalDateTime editTime;

        private Long editorId;
}
