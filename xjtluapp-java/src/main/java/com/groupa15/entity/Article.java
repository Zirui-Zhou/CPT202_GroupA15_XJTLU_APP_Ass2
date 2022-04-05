package com.groupa15.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

/**
 * @author Zirui Zhou
 * @date 2022/4/5
 */

@Setter
@Getter
@ToString
@Accessors(chain = true)
@RequiredArgsConstructor
@Entity
@Proxy(lazy = false)
public class Article {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer articleId;

        private String articleTitle;

        private String articleImage;

        private String articleContent;

        private String userName;

        private String userAvatar;
}
