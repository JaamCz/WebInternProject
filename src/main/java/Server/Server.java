

package Server;


import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Server{
    HttpServer server;
    public void startServer()
    {
        try {
            server = HttpServer.create(new InetSocketAddress(8080),0);
            server.createContext("/client", new ClientHandler());
            server.createContext("/account", new AccountHandler());
            server.createContext("/card", new CardHandler());
            server.setExecutor(null);
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void closeServer(){
        server.stop(0);
    }
}

