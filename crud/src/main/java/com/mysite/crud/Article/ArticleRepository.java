package com.mysite.crud.Article;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mysite.crud.Article.Article;
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
