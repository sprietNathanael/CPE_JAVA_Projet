/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpe_java_projet.model;

import cpe_java_projet.tools.ChessPiecesFactory;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author nathanael
 */
public class Jeu implements Games{

    private Couleur couleur;
    private List<Pieces> piecesListe;
    private boolean castling;
    private boolean possibleCapture;
    
    public Jeu(Couleur couleur)
    {
        this.couleur = couleur;
        this.piecesListe = ChessPiecesFactory.newPieces(couleur);
        this.castling = false;
        this.possibleCapture = false;
        
    }

    public Couleur getCouleur() {
        return couleur;
    }
    
    @Deprecated
    public Couleur getPieceCouleur(int x, int y)
    {
        Pieces piece = this.getPiece(x, y);
        if(piece != null)
        {
            return piece.getCouleur();
        }
        return null;
    }
    
    public String getPieceName(int x, int y)
    {
        Pieces piece = this.getPiece(x, y);
        if(piece != null)
        {
            return piece.getName();
        }
        return null;
    }
    
    public List<PieceIHM> getPieceIHM()
    {
        PieceIHM newPieceIHM = null;
        List<PieceIHM> list = new LinkedList<PieceIHM>();
        
        for(Pieces piece : this.piecesListe)
        {
            if(piece.getX() != -1)
            {
                newPieceIHM = new PieceIHM(piece);
                list.add(newPieceIHM);
            }
        }
        return list;
    }
    
    
    
    public Pieces getPiece(int x, int y)
    {
        for(Pieces piece : this.piecesListe) {
            if(piece.getX() == x && piece.getY() == y)
            {
                return piece;
            }
        }
        return null;
    }
    
    

    @Override
    public boolean isPieceHere(int x, int y) {
        return this.getPiece(x, y) != null;
    }

    @Override
    public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible)
    {
        Pieces piece = this.getPiece(xInit, yInit);
        if(piece != null)
        {
            Pieces pieceTarget = this.getPiece(xFinal, yFinal);
            if(pieceTarget == null)
            {
                return piece.isMoveOk(xFinal, yFinal, isCatchOk, isCastlingPossible);
                
            }
        }
        return false;
    }

    @Override
    public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
        Pieces piece = this.getPiece(xInit, yInit);
        if(piece != null)
        {
            return piece.move(xFinal, yFinal);
        }
        return false;
    }

    public void setCastling(boolean castling) {
        this.castling = castling;
    }

    @Override
    public String toString() {
        String message = "Jeu "+this.couleur+" : ";
        for(Pieces piece : this.piecesListe)
        {
            message+= piece.toString();
        }
        return message;
    }

    @Override
    public boolean capture(int xCatch, int yCatch) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
}


