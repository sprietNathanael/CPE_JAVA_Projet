/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpe_java_projet.model;

import java.util.ArrayList;
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
public class ReineTest {
    
    public ReineTest() {
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
     * Test of isMoveOk method, of class Tour.
     */
    @Test
    public void testIsMoveOk() {
        System.out.println("isMoveOk");
        int xFinal = 5;
        int yFinal = 5;
        boolean isCatchOk = false;
        boolean isCastlingPossible = false;
        Reine instance = new Reine(Couleur.NOIR, new Coord(xFinal, yFinal));
        ArrayList<Boolean> expResult = new ArrayList();
        ArrayList<Boolean> result = new ArrayList();
        expResult.add(true);
        result.add(instance.isMoveOk(5, 7, isCatchOk, isCastlingPossible));
        expResult.add(true);
        result.add(instance.isMoveOk(5, 6, isCatchOk, isCastlingPossible));
        expResult.add(true);
        result.add(instance.isMoveOk(5, 3, isCatchOk, isCastlingPossible));
        expResult.add(true);
        result.add(instance.isMoveOk(3, 5, isCatchOk, isCastlingPossible));
        expResult.add(true);
        result.add(instance.isMoveOk(7, 5, isCatchOk, isCastlingPossible));
        expResult.add(true);
        result.add(instance.isMoveOk(7, 7, true, isCastlingPossible));
        expResult.add(true);
        result.add(instance.isMoveOk(3, 3, true, isCastlingPossible));
        expResult.add(true);
        result.add(instance.isMoveOk(7, 3, true, isCastlingPossible));
        expResult.add(true);
        result.add(instance.isMoveOk(3, 7, true, isCastlingPossible));
        expResult.add(false);
        result.add(instance.isMoveOk(4, 7, true, isCastlingPossible));
        expResult.add(false);
        result.add(instance.isMoveOk(5, 5, isCatchOk, isCastlingPossible));
        assertEquals(expResult, result);
    }
    
    /**
     * Test of toString method, of class Tour.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        int xFinal = 5;
        int yFinal = 5;
        Reine instance = new Reine(Couleur.NOIR, new Coord(xFinal, yFinal));
        String expResult = "Reine : [x="+xFinal+", y="+yFinal+"]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getX method, of class Tour.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        int xFinal = 5;
        int yFinal = 5;
        Reine instance = new Reine(Couleur.NOIR, new Coord(xFinal, yFinal));
        int expResult = xFinal;
        int result = instance.getX();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getY method, of class Tour.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        int xFinal = 5;
        int yFinal = 5;
        Reine instance = new Reine(Couleur.NOIR, new Coord(xFinal, yFinal));
        int expResult = yFinal;
        int result = instance.getY();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getCouleur method, of class Tour.
     */
    @Test
    public void testGetCouleur() {
        System.out.println("getCouleur");
        int xFinal = 5;
        int yFinal = 5;
        Reine instance = new Reine(Couleur.NOIR, new Coord(xFinal, yFinal));
        Couleur expResult = Couleur.NOIR;
        Couleur result = instance.getCouleur();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getName method, of class Tour.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        int xFinal = 5;
        int yFinal = 5;
        Reine instance = new Reine(Couleur.NOIR, new Coord(xFinal, yFinal));
        String expResult = "Reine";
        String result = instance.getName();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of capture method, of class Tour.
     */
    @Test
    public void testCapture() {
        System.out.println("capture");
        int xFinal = 5;
        int yFinal = 5;
        Reine instance = new Reine(Couleur.NOIR, new Coord(xFinal, yFinal));
        instance.capture();
        Coord expResult = new Coord(-1, -1);
        Coord result = new Coord(instance.getX(),instance.getY());
        assertEquals(expResult, result);
    }
    
}
