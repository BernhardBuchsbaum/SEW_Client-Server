package server;

import java.io.*;
import java.net.Socket;

public class ClientHandler {

    private Socket clientSocket = null;
    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void communicate() {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream())));
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            System.out.println("Server: Empfange Daten.");
            System.out.println("Sever: Clientnachricht: " + in.readLine());

            System.out.println("Server: Sende Daten an Client.");
            out.println("Liebe Grüße vom Server!");
            out.flush();
        }
        catch (IOException e){
            System.out.println("Server: Lesen/Schreiben hat nicht funktioniert");
            e.printStackTrace();
        }
    }
}
