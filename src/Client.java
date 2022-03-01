import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) throws UnknownHostException {
        int port = 8090;

        String host = "netology.homework";
        InetAddress inetAddress = InetAddress.getByName(host);
        System.out.println(host + ", ip address: " + inetAddress.getHostAddress());

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            out.println("Version?");
            System.out.println("[Client]: " + in.readLine());

            out.println("License?");
            System.out.println("[Client]: " + in.readLine());

            out.println("Close");
            System.out.println("[Client]: " + in.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
