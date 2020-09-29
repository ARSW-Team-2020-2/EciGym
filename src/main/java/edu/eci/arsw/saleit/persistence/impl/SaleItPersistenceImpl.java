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


}
