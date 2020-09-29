package edu.eci.arsw.saleit.persistence.repo;

import edu.eci.arsw.saleit.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepo extends JpaRepository<Usuario, Integer>{


}
