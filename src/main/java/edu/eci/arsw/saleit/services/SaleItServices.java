package edu.eci.arsw.saleit.services;

import edu.eci.arsw.saleit.model.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface SaleItServices {

    void addUser(Usuario user) throws SaleItServicesException;

    List<Usuario> getAllUsers() throws SaleItServicesException;

    void addAuction(Subasta auction, Integer id) throws SaleItServicesException;

    List<Subasta> getAllAuctions() throws SaleItServicesException;

    List<Articulo> getAllArticles() throws SaleItServicesException;

    void addArticle(Articulo article) throws SaleItServicesException;

    List<Categoria> getAllCategories() throws SaleItServicesException;

    void addCategory(Categoria category) throws SaleItServicesException;

    Optional<Articulo> getArticleById(int id) throws SaleItServicesException;

    Usuario getUserById(int id) throws SaleItServicesException;

    Optional<Categoria> getCategoryById(int id) throws SaleItServicesException;

    List<Subasta> getOwnAuctionsByUser(int id) throws SaleItServicesException;

    void addArticleAsFavorite(int user, Articulo article) throws SaleItServicesException;

    List<Articulo> getFavoriteArticlesOfAnUser(int userId) throws SaleItServicesException;

    void makeABid(Puja puja, Integer usuario, Integer subasta) throws SaleItServicesException;

    List<Puja> getBidsByAuction(Integer subasta) throws SaleItServicesException;

    List<Subasta> getAuctionsOfAnUser(int user) throws SaleItServicesException;
}
