package cat.paucasesnocescifp.sppsp.model;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) {

        //Iniciamos el socket del servidor con un puerto por defecto
        try {
            ServerSocket serverSocket = new ServerSocket(5555);

            //iniciamos un socket que seran los clientes que se conecten a nuestro servidor
            Socket socketCliente = serverSocket.accept();

            //Inicializamos la entrada de la información que el cliente manda al servidor
            DataInputStream entrada = new DataInputStream(socketCliente.getInputStream());

            //Inicializamos la respuesta del servidor mandara al cliente
            DataOutputStream salida = new DataOutputStream(socketCliente.getOutputStream());


        } catch (IOException e) {
            System.out.println("Error Servidor: " + e.getMessage());
        }


    }

}
