/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket.socketClient;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nathanael
 */
public class SocketSender_Client{

    private static ObjectOutputStream socket_out;
    public SocketSender_Client(ObjectOutputStream out) {
        socket_out = out;
    }
    
    public void send(Object objectToSend)
    {
        try {
            socket_out.writeObject(objectToSend);
            socket_out.reset();
        } catch (IOException ex) {
            Logger.getLogger(SocketSender_Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
