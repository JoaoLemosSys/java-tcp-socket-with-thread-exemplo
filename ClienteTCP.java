import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteTCP {
    public static void main(String[] args) throws Exception {

        Socket socketCliente = new Socket("localhost", 9090);

        BufferedReader in = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
        
        PrintWriter out = new PrintWriter(socketCliente.getOutputStream(), true);
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        
        String userInput;
        while ((userInput = stdIn.readLine()) != null) {
            out.println(userInput);
            System.out.println(in.readLine());
        }
    }
}