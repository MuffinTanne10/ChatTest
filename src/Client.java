import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {


        Scanner scanner = new Scanner(System.in);

        Socket client = new Socket("localhost", 1238);
        System.out.println("client.Client gestartet!");
        OutputStream out = client.getOutputStream();
        PrintWriter writer = new PrintWriter(out);

        InputStream in = client.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        System.out.print("Eingabe: ");
        String toServer = scanner.nextLine();

        writer.write(toServer + "\n");
        writer.flush();

        String s = null;
        while ((s = reader.readLine()) != null) {
            System.out.println("Empfangen vom server.Server:  " + s);
        }

        reader.close();
        writer.close();

    }
}

