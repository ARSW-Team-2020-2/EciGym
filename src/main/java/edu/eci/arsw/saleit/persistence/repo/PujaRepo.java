package edu.eci.arsw.saleit.persistence.repo;

import edu.eci.arsw.saleit.model.Puja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PujaRepo extends JpaRepository<Puja, Integer> {

    @Query(value = "select * from puja where usuario = :usuarioID", nativeQuery = true)
    List<Puja> getBidsOfAnAuction(@Param("usuarioID") int usuarioID);
}
