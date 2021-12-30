package fr.lernejo.navy_battle.client;

import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class Http_Client {
    private final HttpClient client;
    private final URL adversaryUrl;
    protected final int port;
    private final URL targetURL;

    public Http_Client(int port, URL targetURL, HttpClient client, URL adversaryUrl) throws IOException {
        this.port = port;
        this.client = client;
        this.adversaryUrl = adversaryUrl;
        this.targetURL = targetURL;
        // exemple String mess = "{\"id\":\"1\", \"url\":\"http://localhost:" + port + "\", \"message\":\"hello\"}";
    }

    public HttpResponse<String> sendGETRequest(String path) {
        HttpResponse<String> response = null;
        try {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.targetURL + path))
                .timeout(Duration.ofSeconds(5))
                .GET()
                .build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (IOException | InterruptedException e) {
            System.err.println("Error when sending GET request to: " + "http://" + this.adversaryUrl.getHost() + ":" + this.adversaryUrl.getPort() + path);
            e.printStackTrace();
        }
        return response;
    }

    public HttpResponse<String> sendPOSTRequest(String path, String mess) {
        HttpResponse<String> response = null;
        try {
            HttpRequest request = (HttpRequest) HttpRequest.newBuilder()
                .uri(URI.create(this.adversaryUrl + "/api/game/start"))
                .setHeader("Accept", "application/json")
                .setHeader("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(mess))
                .build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (IOException | InterruptedException e) {
            System.err.println("Error when sending POST request to: " + "http://" + this.adversaryUrl.getHost() + ":" + this.adversaryUrl.getPort() + path);
            e.printStackTrace();
        }
        return response;
    }

    public HttpResponse<String> ping() {
        return this.sendGETRequest( "/ping" );
    }
}
