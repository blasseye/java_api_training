package fr.lernejo.navy_battle.Http_Server;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class CallHandler implements HttpHandler {
    public void handle(HttpExchange exchange) throws IOException {
        String response = "OK";
        try {
            exchange.sendResponseHeaders(200, response.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (OutputStream os = exchange.getResponseBody()) { // (1)
            os.write(response.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
