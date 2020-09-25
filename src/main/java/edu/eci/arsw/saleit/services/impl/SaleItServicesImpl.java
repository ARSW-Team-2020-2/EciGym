package edu.eci.arsw.saleit.services.impl;


import edu.eci.arsw.saleit.model.User;
import edu.eci.arsw.saleit.persistence.SaleItPersistence;
import edu.eci.arsw.saleit.persistence.SaleItPersistenceException;
import edu.eci.arsw.saleit.services.SaleItException;
import edu.eci.arsw.saleit.services.SaleItServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleItServicesImpl implements SaleItServices {

    @Autowired
    private SaleItPersistence saleItPersistence;

    @Override
    public void addUser(User user) throws SaleItException {
        try {
            saleItPersistence.addUser(user);
        } catch (SaleItPersistenceException e) {
            e.printStackTrace();
        }

    }

}
