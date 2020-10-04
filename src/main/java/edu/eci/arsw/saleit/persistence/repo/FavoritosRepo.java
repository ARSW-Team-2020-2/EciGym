package edu.eci.arsw.saleit.persistence.repo;

import edu.eci.arsw.saleit.model.Favoritos;
import edu.eci.arsw.saleit.model.FavoritosPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoritosRepo extends JpaRepository<Favoritos, FavoritosPK> {
}
