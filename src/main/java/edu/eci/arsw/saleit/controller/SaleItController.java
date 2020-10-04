package edu.eci.arsw.saleit.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.eci.arsw.saleit.model.*;
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

    //Funciona x2
    @GetMapping("/users")
    public ResponseEntity<?> getUsers() {
        try {
            return new ResponseEntity<>(saleItServices.getAllUsers(), HttpStatus.ACCEPTED);
        } catch (SaleItServicesException e) {
            Logger.getLogger(SaleItController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    //Funciona x2
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

    //Funciona x2
    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        try {
            return new ResponseEntity<>(saleItServices.getUserById(id), HttpStatus.ACCEPTED);
        } catch (SaleItServicesException e) {
            Logger.getLogger(SaleItController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    //ARTICULOS

    //Funciona* x2
    @GetMapping("/articles")
    public ResponseEntity<?> getArticles() {
        try {
            return new ResponseEntity<>(saleItServices.getAllArticles(), HttpStatus.ACCEPTED);
        } catch (SaleItServicesException e) {
            Logger.getLogger(SaleItController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

//    //Funciona
//    @PostMapping("/articles")
//    public ResponseEntity<?> addArticle(@RequestBody Articulo article) {
//        try {
//            saleItServices.addArticle(article);
//            return new ResponseEntity<>(HttpStatus.CREATED);
//        } catch (SaleItServicesException e) {
//            Logger.getLogger(SaleItController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
//        }
//    } NO TIENE SENTIDO DEJAR ESTO PORQUE AL CREAR UNA SUBASTA SE CREA UN ARTICULO

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

    //Funciona x2*
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

    //Funciona x2
    @GetMapping("/categories/{id}")
    @JsonIgnore
    public ResponseEntity<?> getCategoryById(@PathVariable int id) {
        try {
            return new ResponseEntity<>(saleItServices.getCategoryById(id), HttpStatus.ACCEPTED);
        } catch (SaleItServicesException e) {
            Logger.getLogger(SaleItController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    //SUBASTAS

    //Funciona x2
    @GetMapping("/auctions")
    public ResponseEntity<?> getAuctions() {
        try {
            return new ResponseEntity<>(saleItServices.getAllAuctions(), HttpStatus.ACCEPTED);
        } catch (SaleItServicesException e) {
            Logger.getLogger(SaleItController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    //Funciona x2
    @PostMapping("/users/{id}/auctions")
    public ResponseEntity<?> createAuction(@RequestBody Subasta auction, @PathVariable Integer id) {
        try {
            saleItServices.addAuction(auction, id);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (SaleItServicesException e) {
            Logger.getLogger(SaleItController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }


    //Funciona x2
    @GetMapping("/users/{user}/auctions")
    public ResponseEntity<?> getOwnAuctionsByUser(@PathVariable int user) {
        try {
            return new ResponseEntity<>(saleItServices.getOwnAuctionsByUser(user), HttpStatus.ACCEPTED);
        } catch (SaleItServicesException e) {
            Logger.getLogger(SaleItController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    //Funciona x2
    @PostMapping("/users/{usuario}/fav")
    public ResponseEntity<?> addArticleAsFavorite(@RequestBody Articulo articulo, @PathVariable int usuario) {
        try {
            saleItServices.addArticleAsFavorite(usuario, articulo);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (SaleItServicesException e) {
            Logger.getLogger(SaleItController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }


    //Funciona x2
    @GetMapping("/users/{id}/fav")
    public ResponseEntity<?> getFavoriteArticlesOfAnUser(@PathVariable int id) {
        try {
            return new ResponseEntity<>(saleItServices.getFavoriteArticlesOfAnUser(id), HttpStatus.ACCEPTED);
        } catch (SaleItServicesException e) {
            Logger.getLogger(SaleItController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    //PUJAS
    @PostMapping("/users/{usuario}/{subasta}")
    public ResponseEntity<?> makeABid(@RequestBody Puja puja, @PathVariable Integer usuario, @PathVariable Integer subasta) {
        try {
            saleItServices.makeABid(puja, usuario, subasta);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (SaleItServicesException e) {
            Logger.getLogger(SaleItController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

}
