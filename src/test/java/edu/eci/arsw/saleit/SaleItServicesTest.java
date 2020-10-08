package edu.eci.arsw.saleit;


import edu.eci.arsw.saleit.model.Articulo;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:db-test.properties")
@Sql("/data.sql")
public class SaleItServicesTest {

    @Autowired
    private SaleItServices saleItServices;

    @Test
    public void shouldAddAnUser() throws SaleItServicesException {
        Usuario usuario = new Usuario("test@mail.com", "123", "Diego", "1002681478", TipoDeDocumento.CC, "3158759414");
        saleItServices.addUser(usuario);
        Usuario usuario1 = saleItServices.getUserById(usuario.getId());
        assertEquals(usuario, usuario1);
    }

    @Test
    public void shouldCreateAnAuction() throws SaleItServicesException {
        Articulo articulo = new Articulo("Tenis Adidas", "Nuevo", "Zapatos", 2500000, "15*60", "Cali", "url", 10);
        Usuario usuario = addUser("ilovearsw@mail.com");
        long actualTime = System.currentTimeMillis();
        Timestamp fechaInicio = new Timestamp(actualTime + 100000);
        Timestamp fechaFin = new Timestamp(actualTime + 2000000);
        Subasta subasta = new Subasta(fechaInicio, fechaFin, articulo);
        //saleItServices.addAuction(subasta, usuario.getId());

    }

    private Usuario addUser(String email) {
        Usuario usuario = new Usuario(email, "123", "Diego", "1002681478", TipoDeDocumento.CC, "3158759414");
        try {
            saleItServices.addUser(usuario);
        } catch (SaleItServicesException e) {
            fail("No debio fallar al agregar el usuario");
        }
        return usuario;
    }

    private Subasta addAuction(int userID) {
        Articulo articulo = new Articulo("Tenis Adidas", "Nuevo", "Zapatos", 2500000, "15*60", "Cali", "url", 10);
        long actualTime = System.currentTimeMillis();
        Timestamp fechaInicio = new Timestamp(actualTime + 100000);
        Timestamp fechaFin = new Timestamp(actualTime + 2000000);
        Subasta subasta = new Subasta(fechaInicio, fechaFin, articulo);
        try {
            saleItServices.addAuction(subasta, userID);
        } catch (SaleItServicesException e) {
            fail("No debio fallar al crear la subasta");
        }
        return subasta;
    }


}