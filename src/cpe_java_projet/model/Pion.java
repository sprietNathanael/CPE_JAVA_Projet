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
public class Pion extends AbstractPiece{

    private boolean firstMove;
    
    public Pion(Couleur couleur, Coord coord) {
        super(couleur, coord);
        this.firstMove = true;
        
    }

    @Override
    public boolean move(int xFinal, int yFinal)
    {
        boolean hasMoved = super.move(xFinal, yFinal);
        if(hasMoved)
        {
            this.firstMove = false;
        }
        return hasMoved;
    }
    
    

   @Override
    public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible) {
        int deltaX = xFinal - this.coord.x;
        int deltaY = yFinal - this.coord.y;
        if(deltaX == 0 && (this.firstMove && deltaY == 2 || deltaY == 1))
        {
            return true;                
        }
        else if(isCatchOk && (deltaY == 1 && Math.abs(deltaX) == 1))
        {
            return true;
        }            
        return false;
    }
    
}
