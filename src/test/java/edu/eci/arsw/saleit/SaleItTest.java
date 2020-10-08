package edu.eci.arsw.saleit;

import edu.eci.arsw.saleit.model.*;
import edu.eci.arsw.saleit.services.SaleItServices;
import edu.eci.arsw.saleit.services.SaleItServicesException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SaleItTest {

    @Autowired
    private SaleItServices saleItServices;



    @Test
    public void shouldNotGetNonExistentCategory() {
        try {
            saleItServices.getCategoryById(666);
            fail("Debio fallar por buscar una categoría que no existe");
        } catch (SaleItServicesException e) {
            assertEquals("La categoría con ese ID no existe", e.getMessage());
        }
    }

    @Test
    public void shouldGetAuctionById() throws SaleItServicesException {
        Subasta s = saleItServices.getAuctionByID(38);
        Timestamp timestamp = s.getFechaFin();
        assertEquals(timestamp.toString(), "2020-10-13 10:30:30.0");
    }

    @Test
    public void shouldGetCategoryId() throws SaleItServicesException {
        Categoria c = saleItServices.getCategoryById(1);
        String nombre = c.getNombre();
        assertEquals(nombre, "Hogar y Cocina");
    }

    @Test
    public void shouldGetArticleId() throws SaleItServicesException {
        Articulo a = saleItServices.getArticleById(35);
        String nombre = a.getNombre();
        assertEquals(nombre, "Reloj");
    }

    @Test
    public void shouldGetArticleOfAnAuction() throws SaleItServicesException {
        Subasta s = saleItServices.getAuctionByID(38);
        Articulo a = s.getArticulo();
        String nombre = a.getNombre();
        assertEquals(nombre, "Moto AKT");
    }



    @Test
    public void shouldNotGetNonExistentAuction() {
        try {
            saleItServices.getAuctionByID(666);
        } catch (SaleItServicesException e) {
            assertTrue(true);
        }
    }

    @Test
    public void shouldNotGetNonExistentArticle() {
        try {
            saleItServices.getArticleById(666);
        } catch (SaleItServicesException e) {
            assertTrue(true);
        }
    }
}