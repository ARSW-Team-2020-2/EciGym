package edu.eci.arsw.saleit.repo;

import edu.eci.arsw.saleit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticlesRepo extends JpaRepository<User, String> {

}