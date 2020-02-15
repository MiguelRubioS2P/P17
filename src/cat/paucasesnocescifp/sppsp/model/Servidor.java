package cat.paucasesnocescifp.sppsp.model;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) {

        Boolean abierto = true;
        ServerSocket serverSocket = null;
        Socket socketCliente = null;
        DataInputStream entrada = null;
        DataOutputStream salida = null;
        //Iniciamos el socket del servidor con un puerto por defecto
        try {
            serverSocket = new ServerSocket(5555);

            System.out.println("Servidor iniciado");

            //iniciamos un socket que seran los clientes que se conecten a nuestro servidor
            socketCliente = serverSocket.accept();

            //Inicializamos la entrada de la información que el cliente manda al servidor
            entrada = new DataInputStream(socketCliente.getInputStream());

            //Inicializamos la respuesta del servidor mandara al cliente
            salida = new DataOutputStream(socketCliente.getOutputStream());

            while(abierto){

                switch (entrada.readUTF()){
                    case "Com et dius?":
                        salida.writeUTF("Em dic Toni Ballador");
                        break;
                    case "Quantes línies de codi tens?":
                        salida.writeUTF("Tengo 1 linea porque soy buenisimo");
                        break;
                    case "Tengo que programar":
                        salida.writeUTF("Okey,bye");
                        System.out.println("Servidor apagado");
                        abierto = false;
                        //serverSocket.close();
                        break;
                    default:
                        salida.writeUTF("No he entès la pregunta");
                        break;
                }

            }
            entrada.close();
            salida.close();
            socketCliente.close();
            serverSocket.close();


        } catch (IOException e) {
            System.out.println("Error Servidor: " + e.getMessage());
        }


    }

}
