package edu.eci.arsw.saleit.services;

import edu.eci.arsw.saleit.model.*;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface SaleItServices {

    /**
     * Registra un usuario en la DB
     *
     * @param user Usuario que se ingresa
     * @throws SaleItServicesException
     */
    void addUser(Usuario user) throws SaleItServicesException;


    /**
     * Trae todos los usuarios registrados
     *
     * @return
     * @throws SaleItServicesException
     */
    List<Usuario> getAllUsers() throws SaleItServicesException;


    /**
     * El usuario crea una subasta
     *
     * @param auction
     * @param id
     * @throws SaleItServicesException
     */
    void addAuction(Subasta auction, int id) throws SaleItServicesException;

    List<Subasta> getAllAuctions() throws SaleItServicesException;

    List<Articulo> getAllArticles() throws SaleItServicesException;

    void addArticle(Articulo article) throws SaleItServicesException;

    List<Categoria> getAllCategories() throws SaleItServicesException;

    void addCategory(Categoria category) throws SaleItServicesException;

    Articulo getArticleById(int id) throws SaleItServicesException;

    Usuario getUserById(int id) throws SaleItServicesException;

    Categoria getCategoryById(int id) throws SaleItServicesException;

    List<Subasta> getOwnAuctionsOfAnUser(int id) throws SaleItServicesException;

    void addArticleAsFavorite(int user, Articulo article) throws SaleItServicesException;

    List<Articulo> getFavoriteArticlesOfAnUser(int userId) throws SaleItServicesException;

    void makeABid(Puja puja, int usuario, int subasta) throws SaleItServicesException;

    List<Puja> getBidsOfAnAuction(int subasta) throws SaleItServicesException;

    List<Subasta> getAuctionsOfAnUser(int user) throws SaleItServicesException;

    List<Puja> getBidsOfAnUser(int user) throws SaleItServicesException;

    Subasta getAuctionByID(int id) throws SaleItServicesException;

    Articulo getArticleOfAnAuction(int auction) throws SaleItServicesException;

    List<Articulo> getArticlesByCategory(int category) throws SaleItServicesException;

    void modifyAuction(Subasta auction, int id) throws SaleItServicesException;
}
