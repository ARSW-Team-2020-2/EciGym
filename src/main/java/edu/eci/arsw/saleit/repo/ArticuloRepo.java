package edu.eci.arsw.saleit.repo;

import edu.eci.arsw.saleit.model.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticuloRepo extends JpaRepository<Articulo, Long> {

}