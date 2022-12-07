package client;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        System.out.println("Client: Client gestartet!");
        try (Socket serverSocket = new Socket("localhost", 2000);
             PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(serverSocket.getOutputStream())));
             BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream())))
        /*
        Binär -> DataInput-/OutputStream
        DataInputStream in = new DataInputStream(new BufferedInputStream(serverSocket.getInputStream()));
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(serverSocket.getOutputStream()));

        Objekte -> ObjectInput-/ObjectOutputStream
        ObjectInputStream in = new ObjectInputStream(serverSocket.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(serverSocket.getOutputStream());
        */
        {


            System.out.println("Client: Verbindung zum Server wurde hergestellt!");
            //Nachricht an den Server schicken
            System.out.println("Client: ich schicke eine Nachricht an den Server.");
            out.println("Hallo Server! Ich bin's dein Client!");
            out.flush();

            //Empfange Nachricht von Server -> blockierend
            System.out.println("Client: Servernachricht: " + in.readLine());

        } catch (IOException e) {
            System.out.println("Client: Netzwerkverbindung passt nicht!");
            e.printStackTrace();
        }
        System.out.println("Client: Verbindung beednet!");
    }
}
