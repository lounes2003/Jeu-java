package Test;

import Representation.Node;
import Representation.NodeCombat;
import Representation.NodeN;
import Univers.Monde;
import Univers.Personnage;
import Univers.Cle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NodeNTest {
    private NodeN nodeN;
    private Monde monde;
    private Personnage personnage;
    private Cle cle;

    @BeforeEach
    public void setUp() {
        personnage = new Personnage("Luffy", "Luffy");
        monde = new Monde(personnage);
        nodeN = new NodeN(1, "Enigme de Nami", monde);
        cle = new Cle(true);
    }

    @Test
    public void testAffichagePoints() {
        nodeN.afficherPoints();
        assertEquals(10, personnage.getPoints(), "Les points du personnage doivent être initialement 10.");
    }

    @Test
    public void testResoudreEnigmeNami() {
        // Simulate answering the riddle
        nodeN.resoudreEnigmeNami();
        // Check if points were correctly added or deducted
        assertTrue(personnage.getPoints() != 10, "Les points du personnage doivent changer après la résolution de l'énigme.");
    }

    @Test
    public void testGetFlag() {
        assertTrue(cle.getFlag(), "Le flag doit être true par défaut.");
    }

    @Test
    public void testSetFlag() {
        cle.setFlag(false);
        assertFalse(cle.getFlag(), "Le flag doit être false après l'appel de setFlag(false).");
    }

    @Test
    public void testDisplay() {
        nodeN.display(10);
        assertEquals(10, personnage.getPoints(), "Le personnage doit avoir des points après avoir résolu l'énigme.");
    }

    @Test
    public void testChooseNext() {
        Node nextNode = nodeN.chooseNext(22);
        assertNotNull(nextNode, "Le nœud suivant ne doit pas être nul.");
        assertTrue(nextNode instanceof NodeCombat, "Le nœud suivant doit être une instance de NodeCombat.");
    }
}
