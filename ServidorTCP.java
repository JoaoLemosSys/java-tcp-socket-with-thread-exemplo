import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {
    public static void main(String[] args) throws Exception {

        ServerSocket socketServidor = new ServerSocket(9090);

        while (true) {
            Socket socket = socketServidor.accept();            
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {

                        BufferedReader bufferEntrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter saida = new PrintWriter(socket.getOutputStream(), true);

                        String entradaRow;

                        while ((entradaRow = bufferEntrada.readLine()) != null) {
                            saida.println("Servidor: " + entradaRow);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }                        
    }
}