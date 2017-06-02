package launcher.serverLauncher;

import socket.socketClient.SocketReceiver_Client;
import socket.socketClient.SocketSender_Client;
import socket.socketServer.Accepter_connexion;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;

/**
 * @author ilias
 */
public class LauncherGUI_Server {
    public static ServerSocket serverSocket;
    
    public static Scanner sc;
    public static SocketReceiver_Client receiver;
    public static Thread receiver_thread;
    public static SocketSender_Client sender;

    /**
    * @param args
    */
    public static void main(String[] args) {

        try {
            System.out.println("Initialisation du serveur");
            serverSocket = new ServerSocket(2009);
            System.out.println("Le serveur est à l'écoute du port " + serverSocket.getLocalPort());

            Thread t = new Thread(new Accepter_connexion(serverSocket));
            t.start();

            
            /*ChessGameControlers chessGameControler_Client;
            JFrame frame;	
            Dimension dim;

            dim = new Dimension(800, 800);

            chessGameControler_Client = new ChessGameControler_Client(sender);

            frame = new ChessGameGUI("Jeu d'échec", chessGameControler_Client,  dim);
            //receiver.addObserver((Observer) frame);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocation(600, 10);
            frame.pack();
            frame.setVisible(true);*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
