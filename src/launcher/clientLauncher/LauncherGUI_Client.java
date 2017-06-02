/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package launcher.clientLauncher;

import controleur.controleurClient.ChessGameControler_Client;
import cpe_java_projet.controleur.ChessGameControlers;
import cpe_java_projet.vue.ChessGameGUI;
import socket.socketClient.SocketReceiver_Client;
import socket.socketClient.SocketSender_Client;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Observer;
import java.util.Scanner;

/**
 *
 * @author nathanael
 */
public class LauncherGUI_Client {
    public static Socket socket;
    public static ObjectOutputStream out;
    
    public static Scanner sc;
    public static SocketReceiver_Client receiver;
    public static Thread receiver_thread;
    public static SocketSender_Client sender;
    /**
    * @param args
    */
    public static void main(String[] args) {

        try {

            System.out.println("Demande de connexion au serveur");
            socket = new Socket("127.0.0.1",2009);
            System.out.println("Connexion établie avec le serveur"); // Si le message s'affiche c'est que je suis connect�
            out = new ObjectOutputStream(socket.getOutputStream());
            
            
            sc = new Scanner(System.in);

            sender = new SocketSender_Client(out);

            ChessGameControlers chessGameControler_Client;
            JFrame frame;
            Dimension dim;

            dim = new Dimension(800, 800);

            chessGameControler_Client = new ChessGameControler_Client(sender);

            frame = new ChessGameGUI("Jeu d'échec", chessGameControler_Client,  dim);
            receiver = new SocketReceiver_Client(socket);
            receiver.addObserver((Observer) frame);


            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocation(600, 10);
            frame.pack();
            frame.setVisible(true);

            Thread receiver_thread = new Thread(receiver);
            receiver_thread.start();
        } catch (UnknownHostException e) {
                System.err.println("Impossible de se connecter à l'adresse "+socket.getLocalAddress());
        } catch (IOException e) {
                System.err.println("Aucun serveur à l'écoute du port "+socket.getLocalPort());
        }
    }
}
