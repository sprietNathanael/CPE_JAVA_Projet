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
public interface Pieces {
    public boolean caputre();
    
    public Couleur getCouleur();
    
    public String getName();
    
    public int getX();
    
    public int getY();
    
    public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible);
    
    public boolean move(int xFinal, int yFinal);
}
