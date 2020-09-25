package edu.eci.arsw.saleit.repo;

import edu.eci.arsw.saleit.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, String> {
}
