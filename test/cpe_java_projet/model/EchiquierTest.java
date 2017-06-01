package cpe_java_projet.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.*;

/**
 * @author ilias
 */
public class EchiquierTest {
    private Echiquier echiquier;

    @Before
    public void setUp() throws Exception {
        echiquier = new Echiquier();
    }

    @Test
    public void switchJoueur() throws Exception {
        Couleur result = echiquier.getColorCurrentPlayer();
        Couleur expected = Couleur.BLANC;
        assertEquals(result, expected);

        echiquier.switchJoueur();

        result = echiquier.getColorCurrentPlayer();
        expected = Couleur.NOIR;
        assertEquals(result, expected);
    }

    @Test
    public void isMoveOk() throws Exception {
        int xInit = 7;
        int yInit = 7;
        int xFinal = 7;
        int yFinal = 0;
        boolean result = echiquier.isMoveOk(xInit, yInit, xFinal, yFinal);
        assertEquals(result, true);
    }

}