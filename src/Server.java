import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("[Server]: Start");
        int port = 8090;

        while (true) {
            // порт можете выбрать любой в доступном диапазоне 0-65536. Но чтобы не нарваться на уже занятый - рекомендуем использовать около 8080
            ServerSocket serverSocket = new ServerSocket(port);

            // ждем подключения
            Socket clientSocket = serverSocket.accept();

            // Отправляем информацию
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Получаем информацию
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            System.out.println("[Server]: New connection accepted. port: " + clientSocket.getPort());

            String income = in.readLine();
            System.out.println("[Server]: " + income);
            out.println(income + " - my Version 1.0");

            income = in.readLine();
            System.out.println("[Server]: " + income);
            out.println(income + " - my license for education only");

            income = in.readLine();
            System.out.println("[Server]: " + income);
            out.println(income + " - closing connection.");

            serverSocket.close();
        }
    }

}
