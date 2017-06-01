/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket.socketClient;

import cpe_java_projet.model.PieceIHM;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.List;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nathanael
 */
public class SocketReceiver_Client extends Observable implements Runnable{
    private Socket socket;
    
    public SocketReceiver_Client(Socket socket) {
        this.socket = socket;
        
    }

    @Override
    public void run() {
        try {
            ObjectInputStream socket_in;
            socket_in = new ObjectInputStream(socket.getInputStream());
            while(true){
                Object reponse;
                try {
                    reponse =  socket_in.readObject();
                    if(reponse instanceof List)
                    {
                        this.notifyObservers(reponse);
                    }
                    //TODO sort responses hint : getInstaceOf
                    this.notifyObservers(reponse);
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(SocketReceiver_Client.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(SocketReceiver_Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
