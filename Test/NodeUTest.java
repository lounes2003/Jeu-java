package Test;

import Representation.Node;
import Representation.NodeCombat;
import Representation.NodeU;
import Univers.Monde;
import Univers.Personnage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class NodeUTest {
    private NodeU nodeU;
    private Monde monde;
    private Personnage personnage;

    @BeforeEach
    public void setUp() {
        personnage = new Personnage("Luffy", "Luffy");
        monde = new Monde(personnage);
        nodeU = new NodeU(1, "Node U Test", monde);
    }

    @Test
    public void testAffichagePoints() {
        nodeU.afficherPoints();
        assertEquals(10, personnage.getPoints(), "Les points du personnage doivent être initialement 10.");
    }

    @Test
    public void testGetFlag() {
        assertTrue(nodeU.getFlag(), "Le flag doit être true par défaut.");
    }

    @Test
    public void testSetFlag() {
        nodeU.setFlag(false);
        assertFalse(nodeU.getFlag(), "Le flag doit être false après l'appel de setFlag(false).");
    }

    @Test
    public void testDisplay() {
        nodeU.display(11);
        assertEquals(30, personnage.getPoints(), "Le personnage doit avoir des points après avoir résolu l'énigme.");
    }

    @Test
    public void testChooseNext() {
        Node nextNode = nodeU.chooseNext(22);
        assertNotNull(nextNode, "Le nœud suivant ne doit pas être nul.");
        assertTrue(nextNode instanceof NodeCombat, "Le nœud suivant doit être une instance de NodeCombat.");
    }

    @Test
    public void testChooseNextInvalidId() {
        assertThrows(IllegalArgumentException.class, () -> {
            nodeU.chooseNext(99);
        }, "Devrait lancer IllegalArgumentException pour un ID non reconnu.");
    }
}
