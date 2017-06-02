package socket.socketServer;

import cpe_java_projet.controleur.ChessGameControlers;
import cpe_java_projet.controleur.controleurLocal.ChessGameControler;
import cpe_java_projet.model.Coord;
import cpe_java_projet.model.Couleur;
import cpe_java_projet.model.PieceIHM;
import cpe_java_projet.model.observable.ChessGameServer;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.*;

/**
 * @author ilias
 */
public class Partie extends Thread implements Observer {
    private Map<Socket, Joueur> joueurs;
    private Map<Socket, SocketReceiver_Server> receivers;
    private Map<Socket, SocketSender_Server> senders;
    private int minNumOfPlayers;
    private int maxNumOfPlayers;

    private Couleur turn;
    private boolean endOfGame;
    private Couleur winner;

    private ChessGameServer chessGame;
    private ChessGameControlers controlers;

    public Partie() {
        this.joueurs = new HashMap<>();
        this.receivers = new HashMap<>();
        this.senders = new HashMap<>();
        this.chessGame = new ChessGameServer();
        this.controlers = new ChessGameControler(chessGame);
        this.maxNumOfPlayers = 2;
        this.minNumOfPlayers = 2;
        this.turn = Couleur.BLANC;

        this.chessGame.addObserver(this);
    }

    public boolean addPlayer(Socket socket) {
        if (joueurs.size() == maxNumOfPlayers) {
            return false;
        }
        if(joueurs.containsKey(socket)) {
            return false;
        }
        Joueur joueur = new Joueur();
        if (joueurs.size() % 2 == 0) {
            joueur.setCouleur(Couleur.BLANC);
        } else {
            joueur.setCouleur(Couleur.NOIR);
        }
        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            SocketSender_Server senderServer = new SocketSender_Server(out);
            this.senders.put(socket, senderServer);

            SocketReceiver_Server receiverServer = new SocketReceiver_Server(socket, this);
            new Thread(receiverServer).start();
            this.receivers.put(socket, receiverServer);

            senderServer.send(chessGame.getEchiquier().getPiecesIHM());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Un joueur a été ajouté à la partie");
        joueurs.put(socket, joueur);
        return true;
    }

    public boolean move(Socket socket, Coord init, Coord end) {
        if (!joueurs.containsKey(socket)) {
            return false;
        }
        if (joueurs.get(socket).getCouleur() == turn && chessGame.getPieceColor(init.x, init.y) == turn) {
            turn = turn == Couleur.BLANC ? Couleur.BLANC : Couleur.NOIR;
            return controlers.move(init, end);
        }
        return false;
    }

    @Override
    public void update(Observable observable, Object o) {
        List<PieceIHM> piecesIHM = (List<PieceIHM>) o;

        joueurs.forEach((socket, joueur) -> {
            senders.get(socket).send(piecesIHM);
        });
    }
}
