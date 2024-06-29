package Test;

import Representation.NodeCombat;
import Univers.Monde;
import Univers.Personnage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NodeCombatTest {
    private NodeCombat nodeCombat;
    private Monde monde;
    private Personnage personnage;

    @BeforeEach
    public void setUp() {
        personnage = new Personnage("Luffy", "Luffy");
        monde = new Monde(personnage);
        nodeCombat = new NodeCombat(1, "Combat contre Doflamingo", monde);
    }

    @Test
    public void testAffichagePoints() {
        nodeCombat.afficherPoints();
        assertEquals(10, personnage.getPoints(), "Les points du personnage doivent être initialement 10.");
    }

    @Test
    public void testCombat() {

        personnage.ajouterPoints(10);
        nodeCombat.combat();
        assertTrue(personnage.getPoints() < 20, "Le combat doit réduire les points du personnage.");
    }

    @Test
    public void testEnigmeSurprise() {
        // Directly call the method for testing purpose
        nodeCombat.enigmeSurprise();
        assertTrue(personnage.getPoints() != 10, "Les points du personnage doivent changer après l'énigme surprise.");
    }

    @Test
    public void testGetFlag() {
        assertTrue(nodeCombat.getFlag(), "Le flag doit être true par défaut.");
    }

    @Test
    public void testSetFlag() {
        nodeCombat.setFlag(false);
        assertFalse(nodeCombat.getFlag(), "Le flag doit être false après l'appel de setFlag(false).");
    }
}
