package edu.eci.arsw.saleit;

import edu.eci.arsw.saleit.model.TipoDeDocumento;
import edu.eci.arsw.saleit.model.Usuario;
import edu.eci.arsw.saleit.services.SaleItServices;
import edu.eci.arsw.saleit.services.SaleItServicesException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

//@RunWith(SpringRunner.class)
//@SpringBootTest
//@TestPropertySource(locations = "classpath:db-test.properties")
//@Sql("/tablas.sql")
//@AutoConfigureTestDatabase
public class SaleItServicesTest {


    @Autowired
    private SaleItServices saleItServices;


//    @Test
//    public void addUser() throws SaleItServicesException {
//        Usuario usuario = new Usuario("correo@hotmail.com", "123", "Juan Frasica", "35425999", TipoDeDocumento.CC, "3158746985");
//        saleItServices.addUser(usuario);
//        System.out.println(saleItServices.getAllUsers());
//    }
}
