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
public class TourTest {
    
    public TourTest() {
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
    /*@Test
    public void testIsMoveOk() {
        System.out.println("isMoveOk");
        int xFinal = 5;
        int yFinal = 5;
        boolean isCatchOk = false;
        boolean isCastlingPossible = false;
        Tour instance = new Tour(Couleur.NOIR, new Coord(xFinal, yFinal));
        boolean expResult = false;
        boolean result = instance.isMoveOk(xFinal, yFinal, isCatchOk, isCastlingPossible);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
    /**
     * Test of toString method, of class Tour.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        int xFinal = 5;
        int yFinal = 5;
        Tour instance = new Tour(Couleur.NOIR, new Coord(xFinal, yFinal));
        String expResult = "Tour : [x="+xFinal+", y="+yFinal+"]";
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
        Tour instance = new Tour(Couleur.NOIR, new Coord(xFinal, yFinal));
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
        Tour instance = new Tour(Couleur.NOIR, new Coord(xFinal, yFinal));
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
        Tour instance = new Tour(Couleur.NOIR, new Coord(xFinal, yFinal));
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
        Tour instance = new Tour(Couleur.NOIR, new Coord(xFinal, yFinal));
        String expResult = "Tour";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    
}
