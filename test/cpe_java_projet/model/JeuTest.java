/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpe_java_projet.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nathanael
 */
public class JeuTest {
    
    public JeuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCouleur method, of class Jeu.
     */
    @Test
    public void testGetCouleur() {
        System.out.println("getCouleur");
        Couleur couleurInstance = Couleur.BLANC;
        Jeu instance = new Jeu(couleurInstance);
        Couleur expResult = couleurInstance;
        Couleur result = instance.getCouleur();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPieceCouleur method, of class Jeu.
     */
    @Test
    public void testGetPieceCouleur() {
        System.out.println("getPieceCouleur");
        int x = 0;
        int y = 0;
        Jeu instance = new Jeu(Couleur.NOIR);
        Couleur expResult = Couleur.NOIR;
        Couleur result = instance.getPieceCouleur(x, y);
        assertEquals(expResult, result);
    }

    /**
     * Test of getPieceName method, of class Jeu.
     */
    @Test
    public void testGetPieceName() {
        System.out.println("getPieceName");
        int x = 0;
        int y = 0;
        Jeu instance = new Jeu(Couleur.NOIR);
        String expResult = "Tour";
        String result = instance.getPieceName(x, y);
        assertEquals(expResult, result);
    }

    /**
     * Test of getPieceIHM method, of class Jeu.
     */
//    @Test
//    public void testGetPieceIHM() {
//        System.out.println("getPieceIHM");
//        Jeu instance = null;
//        PieceIHM expResult = null;
//        PieceIHM result = instance.getPieceIHM();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of isPieceHere method, of class Jeu.
     */
    @Test
    public void testIsPieceHere() {
        System.out.println("isPieceHere");
        int x = 0;
        int y = 0;
        Jeu instance = new Jeu(Couleur.NOIR);
        boolean expResult = true;
        boolean result = instance.isPieceHere(x, y);
        assertEquals(expResult, result);
    }

    /**
     * Test of isMoveOk method, of class Jeu.
     */
    @Test
    public void testIsMoveOk() {
        System.out.println("isMoveOk");
        int xInit = 0;
        int yInit = 0;
        int xFinal = 0;
        int yFinal = 1;
        boolean isCatchOk = false;
        boolean isCastlingPossible = false;
        Jeu instance = new Jeu(Couleur.NOIR);
        boolean expResult = true;
        boolean result = instance.isMoveOk(xInit, yInit, xFinal, yFinal, isCatchOk, isCastlingPossible);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Jeu.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        int xInit = 0;
        int yInit = 0;
        int xFinal = 0;
        int yFinal = 1;
        Jeu instance = new Jeu(Couleur.NOIR);
        boolean expResult = true;
        boolean result = instance.move(xInit, yInit, xFinal, yFinal);
        assertEquals(expResult, result);
    }

    /**
     * Test of setCastling method, of class Jeu.
     */
    @Test
    public void testSetCastling() {
        System.out.println("setCastling");
        boolean castling = true;
        Jeu instance = new Jeu(Couleur.NOIR);
        instance.setCastling(castling);
    }
    
}
