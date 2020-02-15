package cat.paucasesnocescifp.sppsp.model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {

        //Okey,bye
        boolean abierto = true;
        Socket socket = null;
        DataInputStream entrada = null;
        DataOutputStream sortida = null;
        Scanner sc = new Scanner(System.in);
        String dato = "";

        try {
            // Inicializamos socket cliente con un puerto y una ip predeterminada

            socket = new Socket("127.0.0.1", 5555);
            //socket.setKeepAlive(true);

            System.out.println("Connexió iniciada");

            while (abierto) {

                // Se inicializa la entrada de informacion del cliente - el msg del servidor al cliente
                entrada = new DataInputStream(socket.getInputStream());
                // se inicializa la salida de informacion del cliente - el msg del cliente al servidor
                sortida = new DataOutputStream(socket.getOutputStream());

                System.out.println("Introdueixi el missatge que voleu enviar:");
                // Escaner el cual permite personalizar el texto enviado al servidor
                dato = sc.nextLine();
                if("Tengo que programar".equals(dato)){
                    System.out.println("Cerrando la conexión con el servidor");
                    abierto = false;
                    sortida.writeUTF(dato);
                }else{
                    sortida.writeUTF(dato);
                    System.out.println("El servidor dice: " + entrada.readUTF());
                }

            }

            entrada.close();
            sortida.close();
            socket.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
