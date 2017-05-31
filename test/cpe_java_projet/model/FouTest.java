package cpe_java_projet.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ilias
 */
public class FouTest {

    /**
     * Test of isMoveOk method, of class Fou.
     */
    @Test
    public void isMoveOk() throws Exception {
        int xInit = 0;
        int yInit = 0;
        int xFinal = 5;
        int yFinal = 5;
        Fou instance = new Fou(Couleur.NOIR, new Coord(xInit, yInit));
        Boolean result = instance.isMoveOk(xFinal, yFinal, false, false);
        assertEquals(true, result);
    }

    /**
     * Test of toString method, of class Fou.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        int xFinal = 5;
        int yFinal = 5;
        Fou instance = new Fou(Couleur.NOIR, new Coord(xFinal, yFinal));
        String expResult = "Fou : [x="+xFinal+", y="+yFinal+"]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getX method, of class Fou.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        int xFinal = 5;
        int yFinal = 5;
        Fou instance = new Fou(Couleur.NOIR, new Coord(xFinal, yFinal));
        int expResult = xFinal;
        int result = instance.getX();
        assertEquals(expResult, result);
    }

    /**
     * Test of getY method, of class Fou.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        int xFinal = 5;
        int yFinal = 5;
        Fou instance = new Fou(Couleur.NOIR, new Coord(xFinal, yFinal));
        int expResult = yFinal;
        int result = instance.getY();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCouleur method, of class Fou.
     */
    @Test
    public void testGetCouleur() {
        System.out.println("getCouleur");
        int xFinal = 5;
        int yFinal = 5;
        Fou instance = new Fou(Couleur.NOIR, new Coord(xFinal, yFinal));
        Couleur expResult = Couleur.NOIR;
        Couleur result = instance.getCouleur();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Fou.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        int xFinal = 5;
        int yFinal = 5;
        Fou instance = new Fou(Couleur.NOIR, new Coord(xFinal, yFinal));
        String expResult = "Fou";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

}