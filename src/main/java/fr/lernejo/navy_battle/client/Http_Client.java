package fr.lernejo.navy_battle.client;


import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class Http_Client {

    private HttpClient client;
    private URL adversaryUrl;
    protected final int port;

    public Http_Client ( int port, String targetURL )throws IOException{
        this.port = port;

    }
    public HttpResponse<String> sendGETRequest(String path){
        HttpResponse<String> response = null;
        try{ HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(adversaryUrl + "/api/game/start"))
            .timeout( Duration.ofSeconds( 5 ) )
            .GET(/*a remplir*/)
            .build();
            response = client.send( request, HttpResponse.BodyHandlers.ofString() );

        }catch ( IOException | InterruptedException e) {
            System.err.println("Error when sending GET request to: " + "http://"+this.adversaryUrl.getHost()+":"+this.adversaryUrl.getPort()+path);
            e.printStackTrace();
        }
        return response;
    }
    public HttpResponse<String> sendPOSTRequest(String path, String toPost){
        HttpResponse<String> response = null;
        try{HttpRequest request = HttpRequest.newBuilder()
            .uri( URI.create(this.adversaryUrl + "/api/game/start"))
            .setHeader("Accept", "application/json")
            .setHeader("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString( "{\"id\":\"1\", \"url\":\"http://localhost:" + port + "\", \"message\":\"hello\"}"))
            .build();
            response = client.send( request, HttpResponse.BodyHandlers.ofString() );

        }catch ( IOException | InterruptedException e) {
            System.err.println("Error when sending POST request to: " + "http://"+this.adversaryUrl.getHost()+":"+this.adversaryUrl.getPort()+path);
            e.printStackTrace();
        }
        return response;
    }
    public HttpResponse<String> ping() {
        return this.sendGETRequest( "/ping");
    }
}
