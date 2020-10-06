package edu.eci.arsw.saleit;

import edu.eci.arsw.saleit.model.Subasta;
import edu.eci.arsw.saleit.services.SaleItServices;
import edu.eci.arsw.saleit.services.SaleItServicesException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SaleItTest {

    @Autowired
    private SaleItServices saleItServices;


    @Test
    public void shouldGetAuctionById() throws SaleItServicesException {
        Subasta s = saleItServices.getAuctionByID(38);
        Timestamp timestamp = s.getFechaFin();
        assertEquals(timestamp.toString(), "2020-10-13 10:30:30.0");
    }
}