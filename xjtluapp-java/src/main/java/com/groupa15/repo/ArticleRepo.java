package com.groupa15.repo;


import com.groupa15.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Zirui Zhou
 * @date 2022/4/5
 */

@Repository
public interface ArticleRepo extends JpaRepository<Article, Integer> {
    List<Article> findByArticleIdBetween(Integer from, Integer to);
}
