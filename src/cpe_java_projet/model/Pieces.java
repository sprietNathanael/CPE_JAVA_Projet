/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpe_java_projet.model;

import java.io.Serializable;

/**
 *
 * @author nathanael
 */
public interface Pieces extends Serializable {
    public boolean capture();
    
    public Couleur getCouleur();
    
    public String getName();
    
    public int getX();
    
    public int getY();
    
    public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible);
    
    public boolean move(int xFinal, int yFinal);
}
