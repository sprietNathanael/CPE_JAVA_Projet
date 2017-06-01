/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpe_java_projet.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nathanael
 */
public class Echiquier implements BoardGames{

    private Jeu jeuNoir;
    private Jeu jeuBlanc;
    private Jeu jeuCourant = null;
    private Jeu jeuNonCourant = null;

    private String message = "";

    public Echiquier() {
        jeuBlanc = new Jeu(Couleur.BLANC);
        jeuNoir = new Jeu(Couleur.NOIR);

        jeuCourant = jeuBlanc;
        jeuNonCourant = jeuNoir;
    }

    private void setMessage(String message) {
        this.message = message;
    }

    public void switchJoueur() {
        Jeu tmp = jeuCourant;
        jeuCourant = jeuNonCourant;
        jeuNonCourant = tmp;
    }

    public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal) {
        boolean capture = this.isPieceTargetIsAdverse(xFinal, yFinal);
        boolean res = jeuCourant.isMoveOk(xInit, yInit,xFinal,yFinal, capture, false);
        res &= !(this.isPieceOnTrajectory(xInit, yInit, xFinal, yFinal));
        this.setMessage(res ? "OK" : "NOPE");
        return res;
    }

    public List<PieceIHMs> getPiecesIHM() {
        List<PieceIHMs> pieceIHMs = new ArrayList<>();
        pieceIHMs.addAll(jeuBlanc.getPieceIHM());
        pieceIHMs.addAll(jeuNoir.getPieceIHM());
        return pieceIHMs;
    }

    @Override
    public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
        if(jeuCourant.move(xInit, yInit, xFinal,yFinal))
        {
            if(isPieceTargetIsAdverse(xFinal, yFinal))
            {
                jeuNonCourant.capture(xFinal, yFinal);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean isEnd() {
        return false;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Couleur getColorCurrentPlayer() {
        return jeuCourant.getCouleur();
    }

    @Override
    public Couleur getPieceColor(int x, int y) {
        return this.jeuCourant.getPieceCouleur(x, y);
    }

    @Override
    public String toString() {
        String message = "";
        message += jeuBlanc;
        message += "\n";
        message += jeuNoir;
        return message;
    }
    
    private boolean isPieceTargetIsAdverse(int xFinal,int yFinal)
    {
        return jeuNonCourant.isPieceHere(xFinal, yFinal);
    }
    
    private boolean isPieceOnTrajectory(int xInit, int yInit, int xFinal, int yFinal)
    {
        boolean res = false;
        int yStart;
        int yStop;
        int xStart;
        int xStop;
        if(yInit < yFinal)
        {
            yStart = yInit;
            yStop = yFinal;
        }
        else
        {
            yStart = yFinal;
            yStop = yInit;
        }
        if(xInit < xFinal)
        {
            xStart = xInit;
            xStop = xFinal;
        }
        else
        {
            xStart = xFinal;
            xStop = xInit;
        }
        if(xInit == xFinal)
        {
            for(int yInc = yStart+1; yInc < yStop; yInc++)
            {
                res |= jeuCourant.isPieceHere(xInit, yInc);
                res |= jeuCourant.isPieceHere(xInit, yInc);
            }
        }
        else if(yInit == yFinal)
        {
            for(int xInc = xStart+1; xInc < xStop; xInc++)
            {
                res |= jeuCourant.isPieceHere(xInc, yInit);
                res |= jeuCourant.isPieceHere(xInc, yInit);
            }
        }
        else
        {
            int yInc = yStart+1;
            for(int xInc = xStart+1; xInc < xStop; xInc++)
            {
                res |= jeuCourant.isPieceHere(xInc, yInc);
                res |= jeuCourant.isPieceHere(xInc, yInc);
                yInc++;
            }
        }
        return res;
    }
}
