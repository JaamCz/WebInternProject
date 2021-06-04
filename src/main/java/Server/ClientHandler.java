package Server;


import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.PrintStream;


public class ClientHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
    Headers headers = exchange.getResponseHeaders();
    headers.set("Content-type", "application/json");
    PrintStream resp = new PrintStream(exchange.getResponseBody());
    exchange.sendResponseHeaders(200,0);
    resp.close();

    }
}
