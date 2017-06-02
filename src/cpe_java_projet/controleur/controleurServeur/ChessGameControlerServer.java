package cpe_java_projet.controleur.controleurServeur;

import cpe_java_projet.controleur.AbstractChessGameControler;
import cpe_java_projet.model.Coord;
import cpe_java_projet.model.observable.ChessGame;

/**
 * @author ilias
 */
public class ChessGameControlerServer extends AbstractChessGameControler {

    public ChessGameControlerServer(ChessGame chessGame) {
        super(chessGame);
    }

    @Override
    public boolean isPlayerOK(Coord initCoord) {
        return false;
    }

    @Override
    protected void endMove(Coord initCoord, Coord finalCoord, String promotionType) {

    }
}
