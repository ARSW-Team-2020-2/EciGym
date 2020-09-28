package edu.eci.arsw.saleit.services;

import edu.eci.arsw.saleit.model.Articulo;
import edu.eci.arsw.saleit.model.Categoria;
import edu.eci.arsw.saleit.model.Subasta;
import edu.eci.arsw.saleit.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SaleItServices {

    void addUser(Usuario user) throws SaleItServicesException;

    List<Usuario> getAllUsers() throws SaleItServicesException;

    void addAuction(Subasta auction) throws SaleItServicesException;

    List<Subasta> getAllAuctions() throws SaleItServicesException;

    List<Articulo> getAllArticles() throws SaleItServicesException;

    void addArticle(Articulo article) throws SaleItServicesException;

    List<Categoria> getAllCategories() throws SaleItServicesException;

    void addCategory(Categoria category) throws SaleItServicesException;
}
