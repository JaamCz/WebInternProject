package Server;

import Entities.CardsNumber;
import Services.CardsNumbersService;
import Services.ConvertFromJSON;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class CardHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        if ("GET".equals(exchange.getRequestMethod())){
            String[] s = exchange.getRequestURI().getPath().split("/");
            Headers headers = exchange.getResponseHeaders();
            PrintStream resp = new PrintStream(exchange.getResponseBody());
            headers.set("Content-type", "application/json");
            List<CardsNumber> cards = new CardsNumbersService().getAllCards(Long.parseLong(s[2]));

            exchange.sendResponseHeaders(200, 0);
            resp.println(cards);
            resp.close();

        } else {
            String json = new BufferedReader(
                    new InputStreamReader(exchange.getRequestBody(),
                    StandardCharsets.UTF_8)).
                    lines().collect(Collectors.joining("\n"));
            long accId = ConvertFromJSON.convertJsonToLong(json);
            new CardsNumbersService().createCardForAccount(accId);
            exchange.sendResponseHeaders(200, 0);
            exchange.close();

        }

    }
}
