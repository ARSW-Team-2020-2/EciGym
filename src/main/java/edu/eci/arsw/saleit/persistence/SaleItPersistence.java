package edu.eci.arsw.saleit.persistence;

import edu.eci.arsw.saleit.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public interface SaleItPersistence {

    public void addUser(Usuario user) throws SaleItPersistenceException;
}
