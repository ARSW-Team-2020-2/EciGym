package edu.eci.arsw.saleit.persistence;

import edu.eci.arsw.saleit.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public interface SaleItPersistence {

    void addUser(Usuario user) throws SaleItPersistenceException;
}
