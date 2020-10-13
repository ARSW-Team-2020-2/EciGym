package edu.eci.arsw.saleit;

import edu.eci.arsw.saleit.model.Articulo;
import edu.eci.arsw.saleit.model.Categoria;
import edu.eci.arsw.saleit.model.Puja;
import edu.eci.arsw.saleit.model.Subasta;
import edu.eci.arsw.saleit.model.TipoDeDocumento;
import edu.eci.arsw.saleit.model.Usuario;
import edu.eci.arsw.saleit.services.SaleItServices;
import edu.eci.arsw.saleit.services.SaleItServicesException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:db-test.properties")
@Sql("/data.sql")
@Rollback
public class SaleItServicesTest {

    @Autowired
    private SaleItServices saleItServices;

    @Transactional
    @Test
    public void shouldAddAnUser() throws SaleItServicesException {
        Usuario usuario = new Usuario("test@mail.com", "123", "Diego", "1002681478", TipoDeDocumento.CC, "3158759414");
        saleItServices.addUser(usuario);
        Usuario usuario1 = saleItServices.getUserById(usuario.getId());
        assertEquals(usuario, usuario1);
    }

    @Transactional
    @Test
    public void shouldCreateAnAuction() throws SaleItServicesException {
        Categoria categoria = new Categoria("Test");
        saleItServices.addCategory(categoria);
        Articulo articulo = new Articulo("Tenis Adidas", "Nuevo", "Zapatos", 2500000, "15*60", "Cali", categoria.getId());
        saleItServices.addArticle(articulo);
        Usuario usuario = new Usuario("test@mail.com", "123", "Diego", "1002681478", TipoDeDocumento.CC, "3158759414");
        saleItServices.addUser(usuario);
        Timestamp fechaInicio = Timestamp.valueOf("2022-10-13 10:30:30.0");
        Timestamp fechaFin = Timestamp.valueOf("2022-10-14 10:30:30.0");
        Subasta subasta = new Subasta(fechaInicio, fechaFin, articulo);
        saleItServices.addAuction(subasta, usuario.getId());
        assertEquals(subasta, saleItServices.getAuctionById(subasta.getId()));
    }

    @Transactional
    @Test
    public void shouldCreateACategory() throws SaleItServicesException {
        Categoria categoria = new Categoria("Prueba");
        saleItServices.addCategory(categoria);
        Categoria categoria1 = saleItServices.getCategoryById(categoria.getId());
        assertEquals(categoria, categoria1);
    }

    @Transactional
    @Test
    public void shouldCreateAnArticle() throws SaleItServicesException {
        Categoria categoria = new Categoria("CatPrueba");
        saleItServices.addCategory(categoria);
        Articulo articulo = new Articulo("Tenis Nike", "Nuevo", "Zapatos", 2500000, "15*60", "Cali", categoria.getId());
        saleItServices.addArticle(articulo);
        Articulo articulo1 = saleItServices.getArticleById(articulo.getId());
        assertEquals(articulo, articulo1);
    }

    @Transactional
    @Test
    public void shouldAddArticleAsFavorite() throws SaleItServicesException {
        Categoria categoria = new Categoria("CatPruebaFav");
        saleItServices.addCategory(categoria);
        Articulo articulo = new Articulo("Tenis Random", "Nuevo", "Zapatos", 2500000, "15*60", "Cali", categoria.getId());
        saleItServices.addArticle(articulo);
        Usuario usuario = new Usuario("test2@mail.com", "123", "John", "1222681478", TipoDeDocumento.CC, "3148758419");
        saleItServices.addUser(usuario);
        saleItServices.addArticleAsFavorite(usuario.getId(), articulo);
        List<Articulo> fav = saleItServices.getFavoriteArticlesOfAnUser(usuario.getId());
        assertEquals(fav, usuario.getArticulosFavoritos());
    }

    @Transactional
    @Test
    public void shouldAddOwnAuction() throws SaleItServicesException {
        Categoria categoria = new Categoria("CatPruebaAuc");
        saleItServices.addCategory(categoria);
        Articulo articulo = new Articulo("Tenis Random2", "Nuevo", "Zapatos", 2500000, "15*60", "Cali", categoria.getId());
        saleItServices.addArticle(articulo);
        Usuario usuario = new Usuario("test3@mail.com", "123", "Johnny", "8222981478", TipoDeDocumento.CC, "2148753419");
        saleItServices.addUser(usuario);
        Timestamp fechaInicio = Timestamp.valueOf("2022-10-13 10:30:30.0");
        Timestamp fechaFin = Timestamp.valueOf("2022-10-14 10:30:30.0");
        Subasta subasta = new Subasta(fechaInicio, fechaFin, articulo);
        saleItServices.addAuction(subasta, usuario.getId());
        List<Subasta> subs = usuario.getSubastasCreadas();
        assertEquals(subs, saleItServices.getOwnAuctionsOfAnUser(usuario.getId()));
    }

    @Transactional
    @Test
    public void shouldGetArticleOfAnAuction() throws SaleItServicesException {
        Categoria categoria = new Categoria("CatPruebaArt");
        saleItServices.addCategory(categoria);
        Articulo articulo = new Articulo("Tenis Random3", "Nuevo", "Zapatos", 2500000, "15*60", "Cali", categoria.getId());
        saleItServices.addArticle(articulo);
        Usuario usuario = new Usuario("test4@mail.com", "123", "Johnnier", "8222981478", TipoDeDocumento.CC, "2148753419");
        saleItServices.addUser(usuario);
        Timestamp fechaInicio = Timestamp.valueOf("2022-10-13 10:30:30.0");
        Timestamp fechaFin = Timestamp.valueOf("2022-10-14 10:30:30.0");
        Subasta subasta = new Subasta(fechaInicio, fechaFin, articulo);
        saleItServices.addAuction(subasta, usuario.getId());
        assertEquals(articulo, saleItServices.getArticleOfAnAuction(subasta.getId()));
    }

    @Transactional
    @Test
    public void shouldMakeABidAndGetBidsOfUser() throws SaleItServicesException {
        Categoria categoria = new Categoria("CatPruebaBid");
        saleItServices.addCategory(categoria);
        Articulo articulo = new Articulo("Tenis Random4", "Nuevo", "Zapatos", 2500000, "15*60", "Cali", categoria.getId());
        saleItServices.addArticle(articulo);
        Usuario usuario = new Usuario("test5@mail.com", "123", "Jose", "8222981478", TipoDeDocumento.CC, "2148753419");
        saleItServices.addUser(usuario);
        Timestamp fechaInicio = Timestamp.valueOf("2022-10-13 10:30:30.0");
        Timestamp fechaFin = Timestamp.valueOf("2022-10-14 10:30:30.0");
        Subasta subasta = new Subasta(fechaInicio, fechaFin, articulo);
        saleItServices.addAuction(subasta, usuario.getId());
        Puja puja = new Puja(3500000);
        saleItServices.makeABid(puja, usuario.getId(), subasta.getId());
        List<Puja> pujasUsr = saleItServices.getBidsOfAnUser(usuario.getId());
        assertEquals(pujasUsr, usuario.getListaDePujas());
    }

    @Transactional
    @Test
    public void shouldGetBidsOfAnAuction() throws SaleItServicesException {
        Categoria categoria = new Categoria("CatPruebaBidAuc");
        saleItServices.addCategory(categoria);
        Articulo articulo = new Articulo("Tenis Random5", "Nuevo", "Zapatos", 2500000, "15*60", "Cali", categoria.getId());
        saleItServices.addArticle(articulo);
        Usuario usuario = new Usuario("test6@mail.com", "123", "Pepe", "8222981478", TipoDeDocumento.CC, "2148753419");
        saleItServices.addUser(usuario);
        Timestamp fechaInicio = Timestamp.valueOf("2022-10-13 10:30:30.0");
        Timestamp fechaFin = Timestamp.valueOf("2022-10-14 10:30:30.0");
        Subasta subasta = new Subasta(fechaInicio, fechaFin, articulo);
        saleItServices.addAuction(subasta, usuario.getId());
        Puja puja = new Puja(3500000);
        saleItServices.makeABid(puja, usuario.getId(), subasta.getId());
        List<Puja> pujasSub = saleItServices.getBidsOfAnAuction(subasta.getId());
        assertEquals(pujasSub, subasta.getPujas());
    }
    
    @Transactional
    @Test
    public void shouldNotGetNonExistentCategory() {
        try {
            saleItServices.getCategoryById(666);
            fail("Debio fallar por buscar una categoría que no existe");
        } catch (SaleItServicesException e) {
            assertEquals("La categoría con ese ID no existe", e.getMessage());
        }
    }
    
    @Transactional
    @Test
    public void shouldNotGetNonExistentAuction() {
        try {
            saleItServices.getAuctionById(666);
            fail("Debio fallar por buscar una subasta que no existe");
        } catch (SaleItServicesException e) {
            assertEquals("La subasta con ese ID no existe", e.getMessage());
        }
    }
    
    @Transactional
    @Test
    public void shouldNotGetNonExistentArticle() {
        try {
            saleItServices.getArticleById(666);
            fail("Debio fallar por buscar un artículo que no existe");
        } catch (SaleItServicesException e) {
            assertEquals("El articulo con ese ID no existe", e.getMessage());
        }
    }

}
