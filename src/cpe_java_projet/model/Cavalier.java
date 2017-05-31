/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpe_java_projet.model;

import java.util.Comparator;

/**
 *
 * @author nathanael
 */
public class Cavalier extends AbstractPiece{

    public Cavalier(Couleur couleur, Coord coord) {
        super(couleur, coord);
    }

    @Override
    public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible) {
        if ((yFinal == this.coord.y + 2 || yFinal == this.coord.y - 2) &&
                (xFinal == this.coord.x + 1 || xFinal == this.coord.x - 1)) {
            return true;
        } else if ((xFinal == this.coord.x + 2 || xFinal == this.coord.x - 2) &&
                (yFinal == this.coord.y + 1 || yFinal == this.coord.y - 1)) {
            return true;
        }
        return false;
    }
}
