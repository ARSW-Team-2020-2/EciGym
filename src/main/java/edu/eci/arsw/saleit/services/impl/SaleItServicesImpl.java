package edu.eci.arsw.saleit.services.impl;

import edu.eci.arsw.saleit.model.*;
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
    public void addAuction(Subasta auction, Integer id) throws SaleItServicesException {
        try {
            saleItPersistence.addAuction(auction, id);
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
    public Articulo getArticleById(int id) throws SaleItServicesException {
        try {
            return saleItPersistence.getArticleById(id);
        } catch (SaleItPersistenceException e) {
            throw new SaleItServicesException(e.getMessage(), e);
        }
    }

    @Override
    public Usuario getUserById(int id) throws SaleItServicesException {
        try {
            return saleItPersistence.getUserById(id);
        } catch (SaleItPersistenceException e) {
            throw new SaleItServicesException(e.getMessage(), e);
        }
    }


    @Override
    public Categoria getCategoryById(int id) throws SaleItServicesException {
        try {
            return saleItPersistence.getCategoryById(id);
        } catch (SaleItPersistenceException e) {
            throw new SaleItServicesException(e.getMessage(), e);
        }
    }

    @Override
    public List<Subasta> getOwnAuctionsOfAnUser(int id) throws SaleItServicesException {
        try {
            return saleItPersistence.getOwnAuctionsOfAnUser(id);
        } catch (SaleItPersistenceException e) {
            throw new SaleItServicesException(e.getMessage(), e);
        }
    }

    @Override
    public void addArticleAsFavorite(int user, Articulo article) throws SaleItServicesException {
        try {
            saleItPersistence.addArticleAsFavorite(user, article);
        } catch (SaleItPersistenceException e) {
            throw new SaleItServicesException(e.getMessage(), e);
        }
    }

    @Override
    public List<Articulo> getFavoriteArticlesOfAnUser(int user) throws SaleItServicesException {
        try {
            return saleItPersistence.getFavoriteArticlesOfAnUser(user);
        } catch (SaleItPersistenceException e) {
            throw new SaleItServicesException(e.getMessage(), e);
        }
    }

    @Override
    public void makeABid(Puja puja, int usuario, int subasta) throws SaleItServicesException {
        try {
            saleItPersistence.makeABid(puja, usuario, subasta);
        } catch (SaleItPersistenceException e) {
            throw new SaleItServicesException(e.getMessage(), e);
        }
    }

    @Override
    public List<Puja> getBidsOfAnAuction(int subasta) throws SaleItServicesException {
        try {
            return saleItPersistence.getBidsByAuction(subasta);
        } catch (SaleItPersistenceException e) {
            throw new SaleItServicesException(e.getMessage(), e);
        }
    }

    @Override
    public List<Subasta> getAuctionsOfAnUser(int user) throws SaleItServicesException {
        try {
            return saleItPersistence.getAuctionsOfAnUser(user);
        } catch (SaleItPersistenceException e) {
            throw new SaleItServicesException(e.getMessage(), e);
        }
    }

    @Override
    public List<Puja> getBidsOfAnUser(int user) throws SaleItServicesException {
        try {
            return saleItPersistence.getBidsOfAnUser(user);
        } catch (SaleItPersistenceException e) {
            throw new SaleItServicesException(e.getMessage(), e);
        }
    }

    @Override
    public Articulo getArticleOfAnAuction(int auction) throws SaleItServicesException {
        try {
            return saleItPersistence.getArticleOfAnAuction(auction);
        } catch (SaleItPersistenceException e) {
            throw new SaleItServicesException(e.getMessage(), e);
        }
    }

    @Override
    public List<Articulo> getArticlesByCategory(int category) throws SaleItServicesException {
        try {
            return saleItPersistence.getArticlesByCategory(category);
        } catch (SaleItPersistenceException e) {
            throw new SaleItServicesException(e.getMessage(), e);
        }
    }
}
