package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        System.out.println("Server: Server gestartet!");
        try(ServerSocket listenSocket = new ServerSocket(2000)) {
            Socket clientSocket;
            clientSocket = listenSocket.accept();
            ClientHandler ch = new ClientHandler(clientSocket);
            ch.communicate();
        }
        catch (IOException e){
            System.out.println("Server: Serversocket kaputt!");
            e.printStackTrace();
        }
    }
}
