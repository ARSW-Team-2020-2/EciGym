package edu.eci.arsw.saleit.services;

import edu.eci.arsw.saleit.model.User;
import org.springframework.stereotype.Service;

@Service
public interface SaleItServices {

    public void addUser(User user) throws SaleItException;
}
