import DAO.DBConnection;
import Server.Server;
import Services.CardsNumbersService;
import Services.ClientsAccountService;

import java.net.Socket;

import static DAO.DBConnection.*;


public class Application {
    public static void main(String[] args) {
        DBInit();
        Server serv = new Server();
        serv.startServer();
       // new CardsNumbersService().getAllCards().forEach(System.out::println);
    }
}
