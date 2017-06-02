package socket.socketServer;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ilias
 */
public class SocketSender_Server {

    private static ObjectOutputStream socket_out;
    public SocketSender_Server(ObjectOutputStream out) {
        socket_out = out;
    }
    
    public void send(Object objectToSend)
    {
        System.out.print("Send : ");
        System.out.println(objectToSend);
        try {
            socket_out.writeObject(objectToSend);
            socket_out.reset();
            socket_out.writeObject("Test");
        } catch (IOException ex) {
            Logger.getLogger(SocketSender_Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
