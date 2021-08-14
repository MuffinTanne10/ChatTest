import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket;

        serverSocket = new ServerSocket(1238);
        System.out.println("Server gestartet!");

        while (true) {

            Socket socket = serverSocket.accept();

            OutputStream out = socket.getOutputStream();

            PrintWriter writer = new PrintWriter(out);

            InputStream in = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String s = null;

            while ((s = reader.readLine()) != null) {
                writer.write(s + "\n");
                System.out.println("Empfangen vom Client: " + s);
            }

            writer.flush();

            writer.close();
            reader.close();

            socket.close();
        }
    }
}