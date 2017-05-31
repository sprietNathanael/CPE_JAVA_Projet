package cpe_java_projet.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author ilias
 */
public class CavalierTest {

    /**
     * Test of isMoveOk method, of class Cavalier.
     */
    @Test
    public void isMoveOk() throws Exception {
        int xInit = 4;
        int yInit = 4;
        int xFinal = 5;
        int yFinal = 6;
        Cavalier instance = new Cavalier(Couleur.NOIR, new Coord(xInit, yInit));

        Boolean result = instance.isMoveOk(xFinal, yFinal, false, false);
        assertEquals(true, result);

        xFinal = 6;
        yFinal = 5;
        result = instance.isMoveOk(xFinal, yFinal, false, false);
        assertEquals(true, result);

        xFinal = 6;
        yFinal = 3;
        result = instance.isMoveOk(xFinal, yFinal, false, false);
        assertEquals(true, result);

        xFinal = 5;
        yFinal = 2;
        result = instance.isMoveOk(xFinal, yFinal, false, false);
        assertEquals(true, result);

        xFinal = 3;
        yFinal = 2;
        result = instance.isMoveOk(xFinal, yFinal, false, false);
        assertEquals(true, result);

        xFinal = 2;
        yFinal = 3;
        result = instance.isMoveOk(xFinal, yFinal, false, false);
        assertEquals(true, result);

        xFinal = 2;
        yFinal = 5;
        result = instance.isMoveOk(xFinal, yFinal, false, false);
        assertEquals(true, result);

        xFinal = 3;
        yFinal = 6;
        result = instance.isMoveOk(xFinal, yFinal, false, false);
        assertEquals(true, result);
    }

    /**
     * Test of toString method, of class Cavalier.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        int xFinal = 5;
        int yFinal = 5;
        Cavalier instance = new Cavalier(Couleur.NOIR, new Coord(xFinal, yFinal));
        String expResult = "Cavalier : [x="+xFinal+", y="+yFinal+"]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getX method, of class Cavalier.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        int xFinal = 5;
        int yFinal = 5;
        Cavalier instance = new Cavalier(Couleur.NOIR, new Coord(xFinal, yFinal));
        int expResult = xFinal;
        int result = instance.getX();
        assertEquals(expResult, result);
    }

    /**
     * Test of getY method, of class Cavalier.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        int xFinal = 5;
        int yFinal = 5;
        Cavalier instance = new Cavalier(Couleur.NOIR, new Coord(xFinal, yFinal));
        int expResult = yFinal;
        int result = instance.getY();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCouleur method, of class Cavalier.
     */
    @Test
    public void testGetCouleur() {
        System.out.println("getCouleur");
        int xFinal = 5;
        int yFinal = 5;
        Cavalier instance = new Cavalier(Couleur.NOIR, new Coord(xFinal, yFinal));
        Couleur expResult = Couleur.NOIR;
        Couleur result = instance.getCouleur();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Cavalier.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        int xFinal = 5;
        int yFinal = 5;
        Cavalier instance = new Cavalier(Couleur.NOIR, new Coord(xFinal, yFinal));
        String expResult = "Cavalier";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

}