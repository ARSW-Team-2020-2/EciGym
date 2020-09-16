package edu.eci.arsw.saleit.persistence;

import edu.eci.arsw.saleit.model.User;
import org.springframework.stereotype.Service;

@Service
public interface SaleItPersistence {

    public void addUser(User user) throws SaleItPersistenceException;
}
