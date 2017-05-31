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
}
