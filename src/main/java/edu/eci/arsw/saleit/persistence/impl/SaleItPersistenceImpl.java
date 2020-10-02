package edu.eci.arsw.saleit.persistence.impl;

import edu.eci.arsw.saleit.model.*;
import edu.eci.arsw.saleit.persistence.SaleItPersistence;
import edu.eci.arsw.saleit.persistence.SaleItPersistenceException;
import edu.eci.arsw.saleit.persistence.repo.ArticuloRepo;
import edu.eci.arsw.saleit.persistence.repo.CategoriaRepo;
import edu.eci.arsw.saleit.persistence.repo.SubastaRepo;
import edu.eci.arsw.saleit.persistence.repo.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleItPersistenceImpl implements SaleItPersistence {

    @Autowired
    private UsuarioRepo userRepo;

    @Autowired
    private SubastaRepo auctionRepo;

    @Autowired
    private ArticuloRepo articleRepo;

    @Autowired
    private CategoriaRepo categoryRepo;

    @Override
    public void addUser(Usuario user) throws SaleItPersistenceException {
        userRepo.save(user);
    }

    @Override
    public List<Usuario> getAllUsers() throws SaleItPersistenceException {
        if(userRepo.count() == 0){
            throw new SaleItPersistenceException("No existen usuarios.");
        }
        return userRepo.findAll();
    }

    @Override
    public void addAuction(Subasta auction) throws SaleItPersistenceException {
        auctionRepo.save(auction);
    }

    @Override
    public List<Subasta> getAllAuctions() throws SaleItPersistenceException {
        if(auctionRepo.count() == 0){
            throw new SaleItPersistenceException("No existen subastas.");
        }
        return auctionRepo.findAll();
    }

//    public static final String VAR = "select id,nombre from articulo;";
//    @Query(value = VAR, nativeQuery = true)


    @Override
    public List<Articulo> getAllArticles() throws SaleItPersistenceException {
        if(articleRepo.count() == 0){
            throw new SaleItPersistenceException("No existen articulos.");
        }
        System.out.println("HOla");
        List<Articulo> requests = articleRepo.findAll();
        System.out.println(requests);
        return requests;
    }

    @Override
    public void addArticle(Articulo article) throws SaleItPersistenceException {
        articleRepo.save(article);
    }

    @Override
    public List<Categoria> getAllCategories() throws SaleItPersistenceException {
        if(categoryRepo.count() == 0){
            throw new SaleItPersistenceException("No existen categorias.");
        }
        return categoryRepo.findAll();
    }

    @Override
    public void addCategory(Categoria category) throws SaleItPersistenceException {
        categoryRepo.save(category);
    }
    
    @Override
    public Optional<Articulo> getArticleById (int id) throws SaleItPersistenceException {
        return articleRepo.findById(id);
    }
    
    @Override
    public Optional<Usuario> getUserById (int id) throws SaleItPersistenceException {
        return userRepo.findById(id);
    }
    
    @Override
    public void createAuction(Subasta auction) throws SaleItPersistenceException {
        auctionRepo.save(auction);                
    }
    
    @Override
    public Optional<Categoria> getCategoryById(int id) throws SaleItPersistenceException{
        return categoryRepo.findById(id);
    }
    
    @Override
    public List<Subasta> getOwnAuctionsByUser(int id) throws SaleItPersistenceException {
        Usuario user = (getUserById(id)).get();
        List<Subasta> myAuctions = user.getSubastasCreadas();
        if(myAuctions.isEmpty()){
            throw new SaleItPersistenceException("No existen subastas creadas por este usuario.");
        }
        return myAuctions;                 
    }
    
    @Override
    public void addArticleAsFavorite(int userId, int articleId) throws SaleItPersistenceException {
        Usuario user = (getUserById(userId)).get();
        Articulo article = (getArticleById(articleId)).get();
        user.addArticuloFavorito(article);                
    }
    
    @Override
    public List<Articulo> getFavoriteArticlesByUser(int userId) throws SaleItPersistenceException {
        Usuario user = (getUserById(userId)).get();
        List<Articulo> myFavoriteArticles = user.getArticulosFavoritos();
        if(myFavoriteArticles.isEmpty()){
            throw new SaleItPersistenceException("No hay artículos favoritos para este usuario.");
        }
        return myFavoriteArticles;
    }
}
