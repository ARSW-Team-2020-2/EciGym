package edu.eci.arsw.saleit.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.eci.arsw.saleit.model.Articulo;
import edu.eci.arsw.saleit.model.Categoria;
import edu.eci.arsw.saleit.model.Subasta;
import edu.eci.arsw.saleit.model.Usuario;
import edu.eci.arsw.saleit.services.SaleItServicesException;
import edu.eci.arsw.saleit.services.SaleItServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/home")
public class SaleItController {

    @Autowired
    private SaleItServices saleItServices;

    //USUARIOS

    //Funciona
    @GetMapping("/users")
    public ResponseEntity<?> getUsers() {
        try {
            return new ResponseEntity<>(saleItServices.getAllUsers(), HttpStatus.ACCEPTED);
        } catch (SaleItServicesException e) {
            Logger.getLogger(SaleItController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    //Funciona
    @PostMapping("/users")
    public ResponseEntity<?> addUser(@RequestBody Usuario user) {
        try {
            saleItServices.addUser(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (SaleItServicesException e) {
            Logger.getLogger(SaleItController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
    
    //Funciona
    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        try {
            return new ResponseEntity<>(saleItServices.getUserById(id), HttpStatus.ACCEPTED);
        } catch (SaleItServicesException e) {
            Logger.getLogger(SaleItController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
    //Funciona
    @GetMapping("/users/{id}/fav")
    public ResponseEntity<?> getFavoriteArticlesByUser(@PathVariable int id) {
        try {
            return new ResponseEntity<>(saleItServices.getFavoriteArticlesByUser(id), HttpStatus.ACCEPTED);
        } catch (SaleItServicesException e) {
            Logger.getLogger(SaleItController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    //ARTICULOS

    //Funciona
    @GetMapping("/articles")
    public ResponseEntity<?> getArticles() {
        try {
            return new ResponseEntity<>(saleItServices.getAllArticles(), HttpStatus.ACCEPTED);
        } catch (SaleItServicesException e) {
            Logger.getLogger(SaleItController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    //Funciona
    @PostMapping("/articles")
    public ResponseEntity<?> addArticle(@RequestBody Articulo article) {
        try {
            saleItServices.addArticle(article);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (SaleItServicesException e) {
            Logger.getLogger(SaleItController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
    
    //Funciona
    @GetMapping("/articles/{id}")
    public ResponseEntity<?> getArticleById(@PathVariable int id) {
        try {
            return new ResponseEntity<>(saleItServices.getArticleById(id), HttpStatus.ACCEPTED);
        } catch (SaleItServicesException e) {
            Logger.getLogger(SaleItController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }   

    //CATEGORIAS

    //Funciona
    @GetMapping("/categories")
    @JsonIgnore
    public ResponseEntity<?> getCategories() {
        try {
            return new ResponseEntity<>(saleItServices.getAllCategories(), HttpStatus.ACCEPTED);
        } catch (SaleItServicesException e) {
            Logger.getLogger(SaleItController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    //Funciona
    @PostMapping("/categories")
    public ResponseEntity<?> addCategory(@RequestBody Categoria category) {
        try {
            saleItServices.addCategory(category);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (SaleItServicesException e) {
            Logger.getLogger(SaleItController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
    
    //Funciona
    @GetMapping("/categories/{id}")
    @JsonIgnore
    public ResponseEntity<?> getCategorieById(@PathVariable int id) {
        try {
            return new ResponseEntity<>(saleItServices.getCategoryById(id), HttpStatus.ACCEPTED);
        } catch (SaleItServicesException e) {
            Logger.getLogger(SaleItController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }  
    

    //SUBASTAS

    //Funciona
    @GetMapping("/auctions")
    public ResponseEntity<?> getAuctions() {
        try {
            return new ResponseEntity<>(saleItServices.getAllAuctions(), HttpStatus.ACCEPTED);
        } catch (SaleItServicesException e) {
            Logger.getLogger(SaleItController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    //Funciona
    @PostMapping("/auctions")
    public ResponseEntity<?> createAuction(@RequestBody Subasta auction) {
        try {
            saleItServices.addAuction(auction);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (SaleItServicesException e) {
            Logger.getLogger(SaleItController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
    
    //Funciona
    @GetMapping("/auctions/{user}")
    public ResponseEntity<?> getOwnAuctionsByUser(@PathVariable int user) {
        try {
            return new ResponseEntity<>(saleItServices.getOwnAuctionsByUser(user), HttpStatus.ACCEPTED);
        } catch (SaleItServicesException e) {
            Logger.getLogger(SaleItController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
    
    //PUJAS
    


}
