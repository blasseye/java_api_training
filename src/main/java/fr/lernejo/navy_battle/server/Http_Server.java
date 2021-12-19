package fr.lernejo.navy_battle.Http_Server;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

import com.sun.net.httpserver.HttpServer;

public class Http_Server{
    protected final int port;
    private final HttpServer server;
    private final List<CallHandler> contexts = new ArrayList<>();

    public Http_Server(int port) throws Exception {
        this.port = port;
        this.server = HttpServer.create(new InetSocketAddress(8000), 0);
        this.server.createContext("/ping", new CallHandler());
        this.server.setExecutor(null); // creates a default executor
        this.server.start();
    }
    public void createContext(String path, CallHandler handler) {
        this.server.createContext(path, handler);
    }

    public void setupContexts() {
        contexts.forEach(
            context -> this.createContext(context.path(), context) // assigner le path
        );
    }
    public void stop() {
        this.server.stop(0);
    }
}

