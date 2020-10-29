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
    public void shouldGetAllUsers() throws SaleItServicesException {
        Usuario usuario = new Usuario("test@mail.com", "111", "Diego", "1112681478", TipoDeDocumento.CC, "3338759414");
        saleItServices.addUser(usuario);
        Usuario usuario1 = new Usuario("test1@mail.com", "222", "John", "1222681478", TipoDeDocumento.CC, "3228759414");
        saleItServices.addUser(usuario1);
        Usuario usuario2 = new Usuario("test2@mail.com", "333", "Laura", "1332681478", TipoDeDocumento.CC, "3118759414");
        saleItServices.addUser(usuario2);
        List<Usuario> users = saleItServices.getAllUsers();
        if (users.isEmpty()) {
            fail("Falló, no obtuvo los usuarios");
        }
    }

    @Transactional
    @Test
    public void shouldGetAllAuctions() throws SaleItServicesException {
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
        Articulo articulo1 = new Articulo("Tenis Nike", "Nuevo", "Zapatos", 2500000, "15*60", "Cali", categoria.getId());
        saleItServices.addArticle(articulo1);
        Subasta subasta1 = new Subasta(fechaInicio, fechaFin, articulo1);
        saleItServices.addAuction(subasta1, usuario.getId());
        List<Subasta> auctions = saleItServices.getAllAuctions();
        if (auctions.isEmpty()) {
            fail("Falló, no obtuvo las subastas");
        }

    }

    @Transactional
    @Test
    public void shouldGetAllCategories() throws SaleItServicesException {
        Categoria categoria = new Categoria("CatPrueba");
        saleItServices.addCategory(categoria);
        Categoria categoria1 = new Categoria("CatPrueba1");
        saleItServices.addCategory(categoria1);
        Categoria categoria2 = new Categoria("CatPrueba2");
        saleItServices.addCategory(categoria2);
        List<Categoria> categories = saleItServices.getAllCategories();
        if (categories.isEmpty()) {
            fail("Falló, no obtuvo las categorías");
        }
    }

    @Transactional
    @Test
    public void shouldGetAllArticles() throws SaleItServicesException {
        Categoria categoria = new Categoria("CatPrueba");
        saleItServices.addCategory(categoria);
        Articulo articulo = new Articulo("Tenis Nike", "Nuevo", "Zapatos", 2500000, "15*60", "Cali", categoria.getId());
        saleItServices.addArticle(articulo);
        Articulo articulo1 = new Articulo("Tenis Adidas", "Nuevo", "Zapatos", 2500000, "15*60", "Bogota", categoria.getId());
        saleItServices.addArticle(articulo1);
        Articulo articulo2 = new Articulo("Tenis Rebook", "Nuevo", "Zapatos", 2500000, "15*60", "Medellin", categoria.getId());
        saleItServices.addArticle(articulo2);
        List<Articulo> articles = saleItServices.getAllArticles();
        if (articles.isEmpty()) {
            fail("Falló, no obtuvo los artículos");
        }
    }

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
    public void shouldDeleteAnAuction() throws SaleItServicesException {
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
        saleItServices.deleteAuction(subasta.getId(), usuario.getId());
    }

    @Transactional
    @Test
    public void shouldModifyAnAuction() throws SaleItServicesException {
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
        Timestamp nuevafechaFin = Timestamp.valueOf("2022-10-14 10:30:30.0");
        subasta.setFechaFin(nuevafechaFin);
        saleItServices.modifyAuction(subasta, usuario.getId());
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
    public void shouldGetArticlesByCategory() throws SaleItServicesException {
        Categoria categoria = new Categoria("CatPruebaBidAuc");
        saleItServices.addCategory(categoria);
        Articulo articulo = new Articulo("Tenis Random5", "Nuevo", "Zapatos", 2500000, "15*60", "Cali", categoria.getId());
        saleItServices.addArticle(articulo);
        List<Articulo> articulosCat = saleItServices.getArticlesByCategory(categoria.getId());
        assertEquals(articulosCat, categoria.getArticulos());
    }

    @Transactional
    @Test
    public void shouldGetUserByEmail() throws SaleItServicesException {
        Usuario usuario = new Usuario("test@mail.com", "123", "Diego", "1002681478", TipoDeDocumento.CC, "3158759414");
        saleItServices.addUser(usuario);
        Usuario usuario1 = saleItServices.getUserByEmail("test@mail.com");
        assertEquals(usuario, usuario1);
    }
    
    @Transactional
    @Test
    public void shouldGetAuctionByArticleId() throws SaleItServicesException {
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
        Subasta sub = saleItServices.getAuctionByArticleId(articulo.getId());
        assertEquals(sub, subasta);
    }

    @Transactional
    @Test
    public void shouldNotGetNonExistentUser() {
        try {
            saleItServices.getUserById(666);
            fail("Debio fallar por buscar un usuario que no existe");
        } catch (SaleItServicesException e) {
            assertEquals("El usuario con ese ID no existe", e.getMessage());
        }
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

    @Transactional
    @Test
    public void shouldNotGetEmptyUsers() {
        try {
            saleItServices.getAllUsers();
            fail("Debio fallar por que no hay usuarios");
        } catch (SaleItServicesException e) {
            assertEquals("No existen usuarios.", e.getMessage());
        }
    }

    @Transactional
    @Test
    public void shouldNotGetEmptyAuctions() {
        try {
            saleItServices.getAllAuctions();
            fail("Debio fallar por que no hay subastas");
        } catch (SaleItServicesException e) {
            assertEquals("No existen subastas.", e.getMessage());
        }
    }

    @Transactional
    @Test
    public void shouldNotGetEmptyArticles() {
        try {
            saleItServices.getAllArticles();
            fail("Debio fallar por que no hay articulos");
        } catch (SaleItServicesException e) {
            assertEquals("No existen articulos.", e.getMessage());
        }
    }

    @Transactional
    @Test
    public void shouldNotGetEmptyCategories() {
        try {
            saleItServices.getAllCategories();
            fail("Debio fallar por que no hay articulos");
        } catch (SaleItServicesException e) {
            assertEquals("No existen categorias.", e.getMessage());
        }
    }

    @Transactional
    @Test
    public void shouldNotAddNullUser() {
        Usuario user = null;
        try {
            saleItServices.addUser(user);
            fail("Debio fallar por que el usuario es null");
        } catch (SaleItServicesException e) {
            assertEquals("El usuario no puede ser nulo.", e.getMessage());
        }
    }

    @Transactional
    @Test
    public void shouldNotAddNullAuction() {
        Subasta auction = null;
        Usuario usuario = new Usuario("test@mail.com", "123", "Diego", "1002681478", TipoDeDocumento.CC, "3158759414");
        try {
            saleItServices.addAuction(auction, usuario.getId());
            fail("Debio fallar por que la subasta es null");
        } catch (SaleItServicesException e) {
            assertEquals("La subasta no puede ser nula", e.getMessage());
        }
    }

    @Transactional
    @Test
    public void shouldNotAddAuctionWithNullArticle() {
        Categoria categoria = new Categoria("CatPruebaAuc");
        Usuario usuario = new Usuario("test3@mail.com", "123", "Johnny", "8222981478", TipoDeDocumento.CC, "2148753419");
        Timestamp fechaInicio = Timestamp.valueOf("2022-10-13 10:30:30.0");
        Timestamp fechaFin = Timestamp.valueOf("2022-10-14 10:30:30.0");
        Subasta subasta = new Subasta(fechaInicio, fechaFin, null);
        try {
            saleItServices.addCategory(categoria);
            saleItServices.addUser(usuario);
            saleItServices.addAuction(subasta, usuario.getId());
            fail("Debio fallar por que el artículo es null");
        } catch (SaleItServicesException e) {
            assertEquals("El artículo de la subasta no puede ser nulo", e.getMessage());
        }
    }

    @Transactional
    @Test
    public void shouldNotAddAuctionWithWrongFinalDate() {
        try {
            Categoria categoria = new Categoria("CatPruebaAuc");
            Usuario usuario = new Usuario("test3@mail.com", "123", "Johnny", "8222981478", TipoDeDocumento.CC, "2148753419");
            saleItServices.addCategory(categoria);
            Timestamp fechaInicio = Timestamp.valueOf("2022-10-13 10:30:30.0");
            Timestamp fechaFin = Timestamp.valueOf("2020-10-14 10:30:30.0");
            Articulo articulo = new Articulo("Tenis Random2", "Nuevo", "Zapatos", 2500000, "15*60", "Cali", categoria.getId());
            Subasta subasta = new Subasta(fechaInicio, fechaFin, articulo);
            saleItServices.addUser(usuario);
            saleItServices.addArticle(articulo);
            saleItServices.addAuction(subasta, usuario.getId());
            fail("Debio fallar por que la fecha final es antes de la inicial");
        } catch (SaleItServicesException e) {
            assertEquals("Una subasta no puede iniciar después de su fecha de finalización", e.getMessage());
        }
    }

    @Transactional
    @Test
    public void shouldNotGetEmptyAuctionsOfAnUser() {
        Usuario usuario = new Usuario("test3@mail.com", "123", "Johnny", "8222981478", TipoDeDocumento.CC, "2148753419");
        try {
            saleItServices.addUser(usuario);
            saleItServices.getOwnAuctionsOfAnUser(usuario.getId());
            fail("Debio fallar por que el usuario no tiene subastas");
        } catch (SaleItServicesException e) {
            assertEquals("No existen subastas creadas por este usuario.", e.getMessage());
        }
    }

    @Transactional
    @Test
    public void shouldNotGetEmptyFavoriteArticlesOfAnUser() {
        Usuario usuario = new Usuario("test3@mail.com", "123", "Johnny", "8222981478", TipoDeDocumento.CC, "2148753419");
        try {
            saleItServices.addUser(usuario);
            saleItServices.getFavoriteArticlesOfAnUser(usuario.getId());
            fail("Debio fallar por que el usuario no tiene artículos favoritos");
        } catch (SaleItServicesException e) {
            assertEquals("No hay artículos favoritos para este usuario.", e.getMessage());
        }
    }

    @Transactional
    @Test
    public void shouldNotMakeEmptyBid() {
        try {
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
            Puja puja = null;
            saleItServices.makeABid(puja, usuario.getId(), subasta.getId());
            fail("Debió fallar por que la puja es nula");
        } catch (SaleItServicesException e) {
            assertEquals("Debe ingresar un monto", e.getMessage());
        }
    }

    @Transactional
    @Test
    public void shouldNotMakeWrongBid() {
        try {
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
            Puja puja = new Puja(1500000);
            saleItServices.makeABid(puja, usuario.getId(), subasta.getId());
            fail("Debió fallar por que el valor de la puja es menor al minimo");
        } catch (SaleItServicesException e) {
            assertEquals("El monto mínimo a ofertar es de " + 2500000.0, e.getMessage());
        }
    }

    @Transactional
    @Test
    public void shouldNotGetEmptyBidsOfAnAuction() {
        try {
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
            saleItServices.getBidsOfAnAuction(subasta.getId());
            fail("Debió fallar por que la subasta no tiene pujas");
        } catch (SaleItServicesException e) {
            assertEquals("No hay pujas para esta subasta", e.getMessage());
        }
    }

    @Transactional
    @Test
    public void shouldNotGetEmptyParticipatingAuctionsOfAnUser() {
        Usuario usuario = new Usuario("test3@mail.com", "123", "Johnny", "8222981478", TipoDeDocumento.CC, "2148753419");
        try {
            saleItServices.addUser(usuario);
            saleItServices.getAuctionsOfAnUser(usuario.getId());
            fail("Debio fallar por que el usuario no tiene subastas");
        } catch (SaleItServicesException e) {
            assertEquals("Este usuario no ha participado en ninguna subasta", e.getMessage());
        }
    }

    @Transactional
    @Test
    public void shouldNotGetEmptyBidsOfAnUser() {
        try {
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
            saleItServices.getBidsOfAnUser(usuario.getId());
            fail("Debió fallar por que el usuario no ha hecho pujas");
        } catch (SaleItServicesException e) {
            assertEquals("Este usuario no hay realizado ninguna puja", e.getMessage());
        }
    }

    @Transactional
    @Test
    public void shouldNotGetNonExistentUserById() {
        try {
            saleItServices.getUserByEmail("null@correo.com");
            fail("Debio fallar por buscar un usuario que no existe");
        } catch (SaleItServicesException e) {
            assertEquals("El usuario con ese email no existe", e.getMessage());
        }
    }

    @Transactional
    @Test
    public void shouldNotDeleteAuctionOfOtherUser() {
        try {
            Categoria categoria = new Categoria("CatPruebaBid");
            saleItServices.addCategory(categoria);
            Articulo articulo = new Articulo("Tenis Random4", "Nuevo", "Zapatos", 2500000, "15*60", "Cali", categoria.getId());
            saleItServices.addArticle(articulo);
            Usuario usuario = new Usuario("test5@mail.com", "123", "Jose", "8222981478", TipoDeDocumento.CC, "2148753419");
            saleItServices.addUser(usuario);
            Usuario usuario1 = new Usuario("test8@mail.com", "123", "Josefin", "8222981258", TipoDeDocumento.CC, "2148789419");
            saleItServices.addUser(usuario1);
            Timestamp fechaInicio = Timestamp.valueOf("2022-10-13 10:30:30.0");
            Timestamp fechaFin = Timestamp.valueOf("2022-10-14 10:30:30.0");
            Subasta subasta = new Subasta(fechaInicio, fechaFin, articulo);
            saleItServices.addAuction(subasta, usuario.getId());
            saleItServices.deleteAuction(subasta.getId(), usuario1.getId());
        } catch (SaleItServicesException e) {
            assertEquals("Solo el vendedor de la subasta puede eliminarla", e.getMessage());
        }
    }

    @Transactional
    @Test
    public void shouldNotModifyNullAuction() throws SaleItServicesException {
        try {
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
            Timestamp nuevafechaFin = Timestamp.valueOf("2022-10-14 10:30:30.0");
            subasta.setFechaFin(nuevafechaFin);
            saleItServices.modifyAuction(null, usuario.getId());
            fail("Debió fallar al intentar modificar una subasta nula");            
        } catch (SaleItServicesException e) {
            assertEquals("La subasta no puede ser nula", e.getMessage());
        }
    }
    
    @Transactional
    @Test
    public void shouldNotModifyAuctionWithNullArticle() throws SaleItServicesException {
        try {
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
            Timestamp nuevafechaFin = Timestamp.valueOf("2022-10-14 10:30:30.0");
            subasta.setFechaFin(nuevafechaFin);
            subasta.setArticulo(null);
            saleItServices.modifyAuction(subasta, usuario.getId());
            fail("Debió fallar al intentar modificar una subasta con artículo nulo");            
        } catch (SaleItServicesException e) {
            assertEquals("El artículo de la subasta no puede ser nulo", e.getMessage());
        }
    }
    
    @Transactional
    @Test
    public void shouldNotModifyAuctionOfOtherUser() throws SaleItServicesException {
        try {
            Categoria categoria = new Categoria("Test");
            saleItServices.addCategory(categoria);
            Articulo articulo = new Articulo("Tenis Adidas", "Nuevo", "Zapatos", 2500000, "15*60", "Cali", categoria.getId());
            saleItServices.addArticle(articulo);
            Usuario usuario = new Usuario("test@mail.com", "123", "Diego", "1002681478", TipoDeDocumento.CC, "3158759414");
            saleItServices.addUser(usuario);
            Usuario usuario2 = new Usuario("test5@mail.com", "123", "Dieguetto", "1078681478", TipoDeDocumento.CC, "3328759414");
            saleItServices.addUser(usuario2);
            Timestamp fechaInicio = Timestamp.valueOf("2022-10-13 10:30:30.0");
            Timestamp fechaFin = Timestamp.valueOf("2022-10-14 10:30:30.0");
            Subasta subasta = new Subasta(fechaInicio, fechaFin, articulo);
            saleItServices.addAuction(subasta, usuario.getId());
            Timestamp nuevafechaFin = Timestamp.valueOf("2022-10-14 10:30:30.0");
            subasta.setFechaFin(nuevafechaFin);            
            saleItServices.modifyAuction(subasta, usuario2.getId());
            fail("Debió fallar al intentar modificar una subasta de otro usuario");            
        } catch (SaleItServicesException e) {
            assertEquals("Solo el vendedor de la subasta puede modificarla", e.getMessage());
        }
    }
}
