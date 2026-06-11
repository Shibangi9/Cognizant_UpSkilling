import java.io.*;
import java.net.*;

public class ChatClient {

    public static void main(String[] args)
            throws Exception {

        Socket socket =
                new Socket("localhost", 5000);

        BufferedReader in =
                new BufferedReader(
                        new InputStreamReader(
                                socket.getInputStream()));

        PrintWriter out =
                new PrintWriter(
                        socket.getOutputStream(),
                        true);

        System.out.println("Server: "
                + in.readLine());

        out.println("Hello Server!");

        socket.close();
    }
}