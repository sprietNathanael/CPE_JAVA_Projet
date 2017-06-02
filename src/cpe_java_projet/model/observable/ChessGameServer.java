package cpe_java_projet.model.observable;


import cpe_java_projet.model.BoardGames;
import cpe_java_projet.model.Echiquier;


/**
 * @author francoise.perrin
 *         <p>
 *         Cette classe est fortement couplée à un Echiquier qu'elle crée
 *         Elle le rend  Observable et en simplifie l'interface
 *         (DP Proxy, Facade, Observer)
 */
public class ChessGameServer extends ChessGame implements BoardGames {

    private Echiquier echiquier;

    /**
     * Cree une instance de la classe Echiquier
     * et notifie ses observateurs
     */
    public ChessGameServer() {
        super();
        this.echiquier = new Echiquier();
        this.notifyObservers(echiquier.getPiecesIHM());
    }

    public Echiquier getEchiquier() {
        return echiquier;
    }
}
