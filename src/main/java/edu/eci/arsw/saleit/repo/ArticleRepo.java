package edu.eci.arsw.saleit.repo;

import edu.eci.arsw.saleit.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepo extends JpaRepository<Article, String> {

}