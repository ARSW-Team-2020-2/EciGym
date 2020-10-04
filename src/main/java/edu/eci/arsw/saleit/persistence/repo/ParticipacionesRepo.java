package edu.eci.arsw.saleit.persistence.repo;

import edu.eci.arsw.saleit.model.Participaciones;
import edu.eci.arsw.saleit.model.ParticipacionesPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipacionesRepo extends JpaRepository<Participaciones, ParticipacionesPK> {
}
