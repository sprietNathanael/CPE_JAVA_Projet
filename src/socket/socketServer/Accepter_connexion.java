package socket.socketServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Accepter_connexion implements Runnable {

	private ServerSocket socketserver = null;
	private Socket socket = null;

	public Partie t1 = new Partie();
	public Accepter_connexion(ServerSocket ss){
		socketserver = ss;
	}

	public void run() {

        t1.start();

		try {
			while(true){

				socket = socketserver.accept();
				System.out.println("Un joueur veut se connecter  ");

				t1.addPlayer(socket);

			}
		} catch (IOException e) {

			System.err.println("Erreur serveur");
		}

	}
}