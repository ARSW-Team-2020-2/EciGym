package edu.eci.arsw.saleit.services.impl;


import edu.eci.arsw.saleit.model.Articulo;
import edu.eci.arsw.saleit.model.Categoria;
import edu.eci.arsw.saleit.model.Subasta;
import edu.eci.arsw.saleit.model.Usuario;
import edu.eci.arsw.saleit.persistence.SaleItPersistence;
import edu.eci.arsw.saleit.persistence.SaleItPersistenceException;
import edu.eci.arsw.saleit.services.SaleItServicesException;
import edu.eci.arsw.saleit.services.SaleItServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleItServicesImpl implements SaleItServices {

    @Autowired
    private SaleItPersistence saleItPersistence;

    @Override
    public void addUser(Usuario user) throws SaleItServicesException {
        try {
            saleItPersistence.addUser(user);
        } catch (SaleItPersistenceException e) {
            throw new SaleItServicesException(e.getMessage(), e);
        }
    }

    @Override
    public List<Usuario> getAllUsers() throws SaleItServicesException {
        try {
            return saleItPersistence.getAllUsers();
        } catch (SaleItPersistenceException e) {
            throw new SaleItServicesException(e.getMessage(), e);
        }
    }

    @Override
    public void addAuction(Subasta auction) throws SaleItServicesException {
        try {
            saleItPersistence.addAuction(auction);
        } catch (SaleItPersistenceException e) {
            throw new SaleItServicesException(e.getMessage(), e);
        }
    }

    @Override
    public List<Subasta> getAllAuctions() throws SaleItServicesException {
        try {
            return saleItPersistence.getAllAuctions();
        } catch (SaleItPersistenceException e) {
            throw new SaleItServicesException(e.getMessage(), e);
        }
    }

    @Override
    public List<Articulo> getAllArticles() throws SaleItServicesException {
        try {
            return saleItPersistence.getAllArticles();
        } catch (SaleItPersistenceException e) {
            throw new SaleItServicesException(e.getMessage(), e);
        }
    }

    @Override
    public void addArticle(Articulo article) throws SaleItServicesException {
        try {
            saleItPersistence.addArticle(article);
        } catch (SaleItPersistenceException e) {
            throw new SaleItServicesException(e.getMessage(), e);
        }
    }

    @Override
    public List<Categoria> getAllCategories() throws SaleItServicesException {
        try {
            return saleItPersistence.getAllCategories();
        } catch (SaleItPersistenceException e) {
            throw new SaleItServicesException(e.getMessage(), e);
        }
    }

    @Override
    public void addCategory(Categoria category) throws SaleItServicesException {
        try {
            saleItPersistence.addCategory(category);
        } catch (SaleItPersistenceException e) {
            throw new SaleItServicesException(e.getMessage(), e);
        }
    }


}
