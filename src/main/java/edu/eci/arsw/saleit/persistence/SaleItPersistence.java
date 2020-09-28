package edu.eci.arsw.saleit.persistence;

import edu.eci.arsw.saleit.model.Articulo;
import edu.eci.arsw.saleit.model.Categoria;
import edu.eci.arsw.saleit.model.Subasta;
import edu.eci.arsw.saleit.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SaleItPersistence {

    void addUser(Usuario user) throws SaleItPersistenceException;

    List<Usuario> getAllUsers() throws SaleItPersistenceException;

    void addAuction(Subasta auction) throws SaleItPersistenceException;

    List<Subasta> getAllAuctions() throws SaleItPersistenceException;

    List<Articulo> getAllArticles() throws SaleItPersistenceException;

    void addArticle(Articulo article) throws SaleItPersistenceException;

    List<Categoria> getAllCategories() throws SaleItPersistenceException;

    void addCategory (Categoria category) throws SaleItPersistenceException;
}
