package Test;

import static org.junit.jupiter.api.Assertions.*;

import Univers.Personnage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonnageTest {
    private Personnage personnage;

    @BeforeEach
    public void setUp() {
        personnage = new Personnage("Monkey D. Luffy", "Luffy");
    }

    @Test
    public void testGetNom() {
        assertEquals("Luffy", personnage.getNom());
    }

    @Test
    public void testGetPoints() {
        assertEquals(10, personnage.getPoints());
    }

    @Test
    public void testAjouterPoints() {
        personnage.ajouterPoints(5);
        assertEquals(15, personnage.getPoints());
    }

    @Test
    public void testRetirerPoints() {
        personnage.retirerPoints(3);
        assertEquals(7, personnage.getPoints());
    }
}