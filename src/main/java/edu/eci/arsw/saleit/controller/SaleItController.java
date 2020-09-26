package edu.eci.arsw.saleit.controller;

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
@RequestMapping("/users")
public class SaleItController {

    @Autowired
    private SaleItServices saleItServices;

    @GetMapping
    public ResponseEntity<?> getPrimes() {
        return new ResponseEntity<>("Listo", HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody Usuario user) {
        try {
            System.out.println(user);
            saleItServices.addUser(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (SaleItServicesException e) {
            Logger.getLogger(SaleItController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }


}
