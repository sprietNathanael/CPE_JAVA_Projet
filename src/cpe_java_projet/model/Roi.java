/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpe_java_projet.model;

/**
 *
 * @author nathanael
 */
public class Roi extends AbstractPiece{

    public Roi(Couleur couleur, Coord coord) {
        super(couleur, coord);
    }

    @Override
    public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible) {
        int deltaX = xFinal - this.coord.x;
        int deltaY = yFinal - this.coord.y;
        if(Math.abs(deltaX) == 1  && (deltaY == 0 || Math.abs(deltaY) == Math.abs(deltaX)))
        {
            return true;
        }
        else if(Math.abs(deltaY) == 1 && (deltaX == 0 || Math.abs(deltaY) == Math.abs(deltaX)))
        {
            return true;
        }
        return false;
    }
}
