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
        boolean res = jeuCourant.isMoveOk(xInit, yInit,xFinal,yFinal, false, false);
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
        return jeuCourant.move(xInit, yInit, xFinal,yFinal);
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
}
