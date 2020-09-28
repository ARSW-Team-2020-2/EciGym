package edu.eci.arsw.saleit.persistence.impl;

import edu.eci.arsw.saleit.model.*;
import edu.eci.arsw.saleit.persistence.SaleItPersistence;
import edu.eci.arsw.saleit.persistence.SaleItPersistenceException;
import edu.eci.arsw.saleit.repo.ArticuloRepo;
import edu.eci.arsw.saleit.repo.CategoriaRepo;
import edu.eci.arsw.saleit.repo.SubastaRepo;
import edu.eci.arsw.saleit.repo.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
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
        if(userRepo.existsById(user.getEmail())){
            throw new SaleItPersistenceException("Este correo ya existe, ingrese otro.");
        }
        CountNumberGenerate.increment();
        user.setNumeroDeCuenta(CountNumberGenerate.getId());
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

    @Override
    public List<Articulo> getAllArticles() throws SaleItPersistenceException {
        if(articleRepo.count() == 0){
            throw new SaleItPersistenceException("No existen articulos.");
        }
        return articleRepo.findAll();
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
