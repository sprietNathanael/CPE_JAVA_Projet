package socket.socketServer;

import cpe_java_projet.model.Coord;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ilias
 */
public class SocketReceiver_Server implements Runnable {
    private Socket socket;
    private Partie partie;

    public SocketReceiver_Server(Socket socket, Partie partie) {
        this.socket = socket;
        this.partie = partie;

    }

    @Override
    public void run() {
        try {
            ObjectInputStream socket_in;
            socket_in = new ObjectInputStream(socket.getInputStream());
            while (true) {
                Object reponse;
                try {
                    reponse = socket_in.readObject();
                    System.out.print("Receive : ");
                    System.out.println(reponse);
                    if (reponse instanceof List) {
                        this.partie.move(socket, (Coord) ((List) reponse).get(0), (Coord) ((List) reponse).get(1));
                    }
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(SocketReceiver_Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(SocketReceiver_Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
