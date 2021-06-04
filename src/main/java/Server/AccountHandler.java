package Server;

import Entities.ClientAccount;
import Services.ClientsAccountService;
import Services.ConvertFromJSON;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class AccountHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if ("GET".equals(exchange.getRequestMethod())){
            String[] s = exchange.getRequestURI().getPath().split("/");
            Headers headers = exchange.getResponseHeaders();
            PrintStream resp = new PrintStream(exchange.getResponseBody());
            headers.set("Content-type", "application/json");
            List<ClientAccount> clientAcc = new ClientsAccountService().getAccountBalance(s[2]);

            exchange.sendResponseHeaders(200, 0);
            resp.println(clientAcc);
            resp.close();

        } else {
            String json = new BufferedReader(
                    new InputStreamReader(exchange.getRequestBody(),
                            StandardCharsets.UTF_8)).
                    lines().collect(Collectors.joining("\n"));

            new ClientsAccountService().accountBalanceReplenishment(
                    ConvertFromJSON.convertJsonForReplenishment(json));

            exchange.sendResponseHeaders(200, 0);
            exchange.close();

        }
    }
}
