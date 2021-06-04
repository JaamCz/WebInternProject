package Services;

import Entities.CardsNumber;
import Server.Server;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assumptions.*;

import static DAO.DBConnection.DBInit;

class CardsNumbersServiceTest {
    /*static Server serv = new Server();*/

    @BeforeEach
    void startServer() {
        DBInit();
        /*serv.startServer();*/
    }

   /* @AfterEach
    void closeServer(){
        serv.closeServer();
    }*/


    @Test
    void getAllCards() {
        List<CardsNumber> cards = new CardsNumbersService().getAllCards(2L);
        assertEquals(cards.size(),1);
        assertNotEquals(cards.size(), 0);
        assertEquals(cards.get(0).getCardId(), 2);
        assertEquals(cards.get(0).getCardNumber(), "4278 1242 2341 0976");
    }

    @Test
    void createCardForAccount() {
        List<CardsNumber> cards = new CardsNumbersService().getAllCards(1L);
        assertEquals(cards.size(),1);

        new CardsNumbersService().createCardForAccount(1l);
        List<CardsNumber> exp = new CardsNumbersService().getAllCards(1L);
        assertEquals(exp.size(),2);
    }
}