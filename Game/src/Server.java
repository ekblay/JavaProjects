import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Server
{
        static QuestionService service;
    public static void main(String[] args) throws IOException
    {
        service = new QuestionService();
        ArrayList<Client> cl = new ArrayList<>();
        final int PORT = 8888;
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Waiting for clients to connect...");

        while (true)
        {
            System.out.print("\nIf you want to start the game enter any key and hit enter: ");
            Scanner in = new Scanner(System.in);
            if(in.hasNext())
            {
                in.next();
                Client c = new Client();
                c.setVisible(true);

            }
            System.out.println("Client connected.");
            Socket s = server.accept();

        }
    }
}
