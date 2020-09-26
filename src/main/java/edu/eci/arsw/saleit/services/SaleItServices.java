package edu.eci.arsw.saleit.services;

import edu.eci.arsw.saleit.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public interface SaleItServices {

    void addUser(Usuario user) throws SaleItServicesException;
}
