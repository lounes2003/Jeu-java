package Test;

import static org.junit.jupiter.api.Assertions.*;

import Univers.Monde;
import Univers.Personnage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MondeTest {
    private Monde monde;
    private Personnage personnage;

    @BeforeEach
    public void setUp() {
        personnage = new Personnage("Luffy", "Luffy");
        monde = new Monde(personnage);
    }

    @Test
    public void testGetPersonnage() {
        assertEquals(personnage, monde.getPersonnage());
    }

    @Test
    public void testSetPersonnage() {
        Personnage nouveauPersonnage = new Personnage("Sakura", "Sakura");
        monde.setPersonnage(nouveauPersonnage);
        assertEquals(nouveauPersonnage, monde.getPersonnage());
    }

    @Test
    public void testGetLieuActuel() {
        assertEquals("East Blue", monde.getLieuActuel());
    }

    @Test
    public void testSetLieuActuel() {
        monde.setLieuActuel("Grand Line");
        assertEquals("Grand Line", monde.getLieuActuel());
    }
}
