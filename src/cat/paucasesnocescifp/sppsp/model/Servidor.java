package cat.paucasesnocescifp.sppsp.model;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//El contingut del missatge dependrà de la frase rebuda:
//
//Si la frase és "Com et dius?", respondrà amb la cadena "Em dic Toni Ballador".
//
//Si la frase és "Quantes línies de codi tens?", respondrà amb el nombre de línies del teu codi de servidor.
//
//Si la frase es qualsevol altra cosa, respondrà "No he entès la pregunta".
//
//Aquests missatges s'han de mostrar pel client!

public class Servidor {

    public static void main(String[] args) {

        Boolean abierto = true;
        //Iniciamos el socket del servidor con un puerto por defecto
        try {
            ServerSocket serverSocket = new ServerSocket(5555);

            System.out.println("Servidor iniciado");

            while(abierto){
                //iniciamos un socket que seran los clientes que se conecten a nuestro servidor
                Socket socketCliente = serverSocket.accept();

                //Inicializamos la entrada de la información que el cliente manda al servidor
                DataInputStream entrada = new DataInputStream(socketCliente.getInputStream());

                //Inicializamos la respuesta del servidor mandara al cliente
                DataOutputStream salida = new DataOutputStream(socketCliente.getOutputStream());

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

                entrada.close();
                salida.close();
                socketCliente.close();

            }

            serverSocket.close();


            //System.out.println("Servidor apagado");
            //serverSocket.close();

        } catch (IOException e) {
            System.out.println("Error Servidor: " + e.getMessage());
        }


    }

}
