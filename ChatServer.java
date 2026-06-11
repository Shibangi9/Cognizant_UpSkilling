import java.io.*;
import java.net.*;

public class ChatServer {

    public static void main(String[] args)
            throws Exception {

        ServerSocket serverSocket =
                new ServerSocket(5000);

        System.out.println("Server Started...");

        Socket socket =
                serverSocket.accept();

        System.out.println("Client Connected");

        BufferedReader in =
                new BufferedReader(
                        new InputStreamReader(
                                socket.getInputStream()));

        PrintWriter out =
                new PrintWriter(
                        socket.getOutputStream(),
                        true);

        out.println("Hello Client!");

        String message = in.readLine();

        System.out.println("Client: " + message);

        socket.close();
        serverSocket.close();
    }
}