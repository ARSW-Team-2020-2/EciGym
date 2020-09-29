package edu.eci.arsw.saleit.persistence.repo;

import edu.eci.arsw.saleit.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepo extends JpaRepository<Categoria, Integer> {
}
