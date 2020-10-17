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
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SaleItController {

    @Autowired
    private SaleItServices saleItServices;


    //USUARIOS

    @GetMapping("/users")
    public ResponseEntity<?> getUsers() {
        try {
            return new ResponseEntity<>(saleItServices.getAllUsers(), HttpStatus.ACCEPTED);
        } catch (SaleItServicesException e) {
            Logger.getLogger(SaleItController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


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


    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        try {
            return new ResponseEntity<>(saleItServices.getUserById(id), HttpStatus.ACCEPTED);
        } catch (SaleItServicesException e) {
            Logger.getLogger(SaleItController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/users/email/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable String email) {
        try {
            return new ResponseEntity<>(saleItServices.getUserByEmail(email), HttpStatus.ACCEPTED);
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
    public ResponseEntity<?> getAllAuctions() {
        try {
            return new ResponseEntity<>(saleItServices.getAllAuctions(), HttpStatus.ACCEPTED);
        } catch (SaleItServicesException e) {
            Logger.getLogger(SaleItController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
    //Funciona
    @GetMapping("/auctions/{id}")
    public ResponseEntity<?> getAuctionById(@PathVariable int id) {
        try {
            return new ResponseEntity<>(saleItServices.getAuctionById(id), HttpStatus.ACCEPTED);
        } catch (SaleItServicesException e) {
            Logger.getLogger(SaleItController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    

    //Funciona x2
    @PostMapping("/users/{id}/auctions")
    public ResponseEntity<?> createAuction(@RequestBody Subasta auction, @PathVariable int id) {
        try {
            saleItServices.addAuction(auction, id);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (SaleItServicesException e) {
            Logger.getLogger(SaleItController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/users/{id}/auctions")
    public ResponseEntity<?> modifyAuction(@RequestBody Subasta auction, @PathVariable int id) {
        try {
            saleItServices.modifyAuction(auction, id);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (SaleItServicesException ex) {
            Logger.getLogger(SaleItController.class.getName()).log(Level.SEVERE, null, ex);
            if (ex.getMessage().equals("La subasta con ese ID no existe")) {
                return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
            }
        }
    }

    @DeleteMapping("/users/{id}/auctions/{auction}")
    public ResponseEntity<?> deleteAuction(@PathVariable int auction, @PathVariable int id) {
        try {
            saleItServices.deleteAuction(auction, id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (SaleItServicesException ex) {
            Logger.getLogger(SaleItController.class.getName()).log(Level.SEVERE, null, ex);
            if (ex.getMessage().equals("Solo el vendedor de la subasta puede eliminarla")) {
                return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
            } else {
                return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
            }

        }
    }


    //Funciona x2
    @GetMapping("/users/{user}/auctions")
    public ResponseEntity<?> getOwnAuctionsOfAnUser(@PathVariable int user) {
        try {
            return new ResponseEntity<>(saleItServices.getOwnAuctionsOfAnUser(user), HttpStatus.ACCEPTED);
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
    public ResponseEntity<?> makeABid(@RequestBody Puja puja, @PathVariable int usuario, @PathVariable int subasta) {
        try {
            saleItServices.makeABid(puja, usuario, subasta);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (SaleItServicesException e) {
            Logger.getLogger(SaleItController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/auctions/{auction}/bids")
    public ResponseEntity<?> getBidsOfAnAuction(@PathVariable int auction) {
        try {
            return new ResponseEntity<>(saleItServices.getBidsOfAnAuction(auction), HttpStatus.ACCEPTED);
        } catch (SaleItServicesException e) {
            Logger.getLogger(SaleItController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/auctions/users/{user}") //En las que estoy participando
    public ResponseEntity<?> getAuctionsOfAUser(@PathVariable int user) {
        try {
            return new ResponseEntity<>(saleItServices.getAuctionsOfAnUser(user), HttpStatus.ACCEPTED);
        } catch (SaleItServicesException e) {
            Logger.getLogger(SaleItController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/users/{user}/bids")
    public ResponseEntity<?> getBidsOfAnUser(@PathVariable int user) {
        try {
            return new ResponseEntity<>(saleItServices.getBidsOfAnUser(user), HttpStatus.ACCEPTED);
        } catch (SaleItServicesException e) {
            Logger.getLogger(SaleItController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/auctions/{auction}/articles")
    public ResponseEntity<?> getArticleOfAnAuction(@PathVariable int auction) {
        try {
            return new ResponseEntity<>(saleItServices.getArticleOfAnAuction(auction), HttpStatus.ACCEPTED);
        } catch (SaleItServicesException e) {
            Logger.getLogger(SaleItController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/categories/{category}/articles")
    public ResponseEntity<?> getArticlesByCategory(@PathVariable int category) {
        try {
            return new ResponseEntity<>(saleItServices.getArticlesByCategory(category), HttpStatus.ACCEPTED);
        } catch (SaleItServicesException e) {
            Logger.getLogger(SaleItController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


}
