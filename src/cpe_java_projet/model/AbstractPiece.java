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
public abstract class AbstractPiece implements Pieces{
 
    protected Coord coord;
    protected Couleur couleur;
    protected String name;

    public AbstractPiece(Couleur couleur, Coord coord) {
        this.couleur = couleur;
        this.coord = coord;
    }

    @Override
    public Couleur getCouleur() {
        return this.couleur;
    }

    @Override
    public int getX() {
        return this.coord.x;
    }

    @Override
    public int getY() {
        return this.coord.y;
    }

    @Override
    public String toString() {
        return this.name+" : "+this.coord;
    }

    @Override
    public boolean capture() {
        this.coord.x = -1;
        this.coord.y = -1;
        return true;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean move(int xFinal, int yFinal) {
        this.coord.x = xFinal;
        this.coord.y = yFinal;
        return true;
    }

    @Override
    public abstract boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible);
    
    
    
    
}
