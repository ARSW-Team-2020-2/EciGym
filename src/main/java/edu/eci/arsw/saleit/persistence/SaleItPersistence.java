package edu.eci.arsw.saleit.persistence;

import edu.eci.arsw.saleit.model.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SaleItPersistence {

    void addUser(Usuario user) throws SaleItPersistenceException;

    List<Usuario> getAllUsers() throws SaleItPersistenceException;

    void addAuction(Subasta auction, int id) throws SaleItPersistenceException;

    List<Subasta> getAllAuctions() throws SaleItPersistenceException;

    List<Articulo> getAllArticles() throws SaleItPersistenceException;

    void addArticle(Articulo article) throws SaleItPersistenceException;

    List<Categoria> getAllCategories() throws SaleItPersistenceException;

    void addCategory(Categoria category) throws SaleItPersistenceException;

    Articulo getArticleById(int id) throws SaleItPersistenceException;

    Usuario getUserById(int id) throws SaleItPersistenceException;

    Categoria getCategoryById(int id) throws SaleItPersistenceException;

    List<Subasta> getOwnAuctionsOfAnUser(int id) throws SaleItPersistenceException;

    void addArticleAsFavorite(int user, Articulo article) throws SaleItPersistenceException;

    List<Articulo> getFavoriteArticlesOfAnUser(int user) throws SaleItPersistenceException;

    void makeABid(Puja puja, int usuario, int subasta) throws SaleItPersistenceException;

    Subasta getAuctionByID(int id) throws SaleItPersistenceException;

    List<Puja> getBidsByAuction(int subasta) throws SaleItPersistenceException;

    List<Subasta> getAuctionsOfAnUser(int user) throws SaleItPersistenceException;

    List<Puja> getBidsOfAnUser(int user) throws SaleItPersistenceException;

    Articulo getArticleOfAnAuction(int auction) throws SaleItPersistenceException;

    List<Articulo> getArticlesByCategory(int category) throws SaleItPersistenceException;

    void modifyAuction(Subasta auction, int id) throws SaleItPersistenceException;
}
