package fr.lernejo.navy_battle;

import fr.lernejo.navy_battle.server.Http_Server;

public class Launcher {

    public static void main(String[] args) throws Exception {
        if (args.length == 1) {
            int port = Integer.parseInt(args[0]);
            new Http_Server(port);
        } else if ( args.length == 2) {
            int port = Integer.parseInt(args[0]);
            String targetURL = args[1];
            /*
            NavyClient myNavyClient = new NavyClient(port, targetURL);
            myNavyClient.play();
            */
        } else {
            System.out.println("Argument manquant.");
        }
    }
}

