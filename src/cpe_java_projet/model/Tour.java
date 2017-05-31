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
public class Tour extends AbstractPiece{

    public Tour(Couleur couleur, Coord coord) {
        super(couleur, coord);
    }

    @Override
    public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible) {
        int deltaX = xFinal - this.coord.x;
        int deltaY = yFinal - this.coord.y;
        if(Math.abs(deltaX) > 0 && deltaY == 0)
        {
            return true;
        }
        else if(Math.abs(deltaY) > 0 && deltaX == 0)
        {
            return true;
        }
        return false;
    }
    
}
