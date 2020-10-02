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
import java.util.Optional;

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

    @Override
    public Optional<Articulo> getArticleById(int id) throws SaleItServicesException {
        try {
            return saleItPersistence.getArticleById(id);
        } catch (SaleItPersistenceException e) {
            throw new SaleItServicesException(e.getMessage(), e);
        }
    }

    @Override
    public Optional<Usuario> getUserById(int id) throws SaleItServicesException {
        try {
            return saleItPersistence.getUserById(id);
        } catch (SaleItPersistenceException e) {
            throw new SaleItServicesException(e.getMessage(), e);
        }
    }

    @Override
    public void createAuction(Subasta auction) throws SaleItServicesException {
        try {
            saleItPersistence.createAuction(auction);
        } catch (SaleItPersistenceException e) {
            throw new SaleItServicesException(e.getMessage(), e);
        }
    }

    @Override
    public Optional<Categoria> getCategoryById(int id) throws SaleItServicesException {
        try {
            return saleItPersistence.getCategoryById(id);
        } catch (SaleItPersistenceException e) {
            throw new SaleItServicesException(e.getMessage(), e);
        }
    }

    @Override
    public List<Subasta> getOwnAuctionsByUser(int id) throws SaleItServicesException {
        try {
            return saleItPersistence.getOwnAuctionsByUser(id);
        } catch (SaleItPersistenceException e) {
            throw new SaleItServicesException(e.getMessage(), e);
        }
    }

    @Override
    public void addArticleAsFavorite(int user, int article) throws SaleItServicesException {
        try {
            saleItPersistence.addArticleAsFavorite(user, article);
        } catch (SaleItPersistenceException e) {
            throw new SaleItServicesException(e.getMessage(), e);
        }
    }

    @Override
    public List<Articulo> getFavoriteArticlesByUser(int user) throws SaleItServicesException {
        try {
            return saleItPersistence.getFavoriteArticlesByUser(user);
        } catch (SaleItPersistenceException e) {
            throw new SaleItServicesException(e.getMessage(), e);
        }
    }
}
