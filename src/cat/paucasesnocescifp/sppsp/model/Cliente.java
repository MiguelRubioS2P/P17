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
        try {
            // Inicializamos socket cliente con un puerto y una ip predeterminada

            Socket socket = new Socket("127.0.0.1", 5555);
            socket.setKeepAlive(true);

            System.out.println("Connexió iniciada");

            /*// Se inicializa la entrada de informacion del cliente - el msg del servidor al cliente
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            // se inicializa la salida de informacion del cliente - el msg del cliente al servidor
            DataOutputStream sortida = new DataOutputStream(socket.getOutputStream());

            System.out.println("Introdueixi el missatge que voleu enviar:");
            // Escaner el cual permite personalizar el texto enviado al servidor
            Scanner sc = new Scanner(System.in);

            // se envia lo que se escribe al servidor
            sortida.writeUTF(sc.nextLine());
            System.out.println("El servidor dice: " +entrada.readUTF());

            // Cierre de objetos socket, InputStream y OutputStream.
            entrada.close();
            sortida.close();
            socket.close();*/

            while (abierto) {



                // Se inicializa la entrada de informacion del cliente - el msg del servidor al cliente
                DataInputStream entrada = new DataInputStream(socket.getInputStream());
                // se inicializa la salida de informacion del cliente - el msg del cliente al servidor
                DataOutputStream sortida = new DataOutputStream(socket.getOutputStream());

                System.out.println("Introdueixi el missatge que voleu enviar:");
                // Escaner el cual permite personalizar el texto enviado al servidor
                Scanner sc = new Scanner(System.in);

                String dato = sc.nextLine();
                if("Tengo que programar".equals(dato)){
                    System.out.println("Cerrando la conexión con el servidor");
                    abierto = false;
                    sortida.writeUTF(dato);
                }else{
                    sortida.writeUTF(dato);
                    System.out.println("El servidor dice: " + entrada.readUTF());
                }
                // se envia lo que se escribe al servidor


                // Cierre de objetos socket, InputStream y OutputStream.


            }
            socket.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
