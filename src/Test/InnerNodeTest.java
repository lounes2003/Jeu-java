package Test;

import Representation.ChanceNode;
import Representation.DecisionNode;
import Representation.Node;
import Univers.Monde;
import Univers.Personnage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Representation.InnerNode;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class InnerNodeTest {
    private InnerNode innerNode;
    private Monde monde;
    private Personnage personnage;

    @BeforeEach
    public void setUp() {
        personnage = new Personnage("Luffy", "Luffy");
        monde = new Monde(personnage);
        innerNode = new InnerNode(1, "Inner Node Test", monde);
    }

    @Test
    public void testAffichagePoints() {
        innerNode.afficherPoints();
        assertEquals(10, personnage.getPoints(), "Les points du personnage doivent être initialement 10.");
    }


    @Test
    public void testDisplayId2() {
        innerNode.display(2);
    }

    @Test
    public void testDisplayId3() {
        innerNode.display(3);
    }

    @Test
    public void testChooseNextId1() {
        Node nextNode = innerNode.chooseNext(1);
        assertTrue(nextNode instanceof DecisionNode, "Le nœud suivant doit être une instance de DecisionNode.");
    }

    @Test
    public void testChooseNextId2() {
        Node nextNode = innerNode.chooseNext(2);
        assertTrue(nextNode instanceof DecisionNode, "Le nœud suivant doit être une instance de DecisionNode.");
    }

    @Test
    public void testChooseNextId3() {
        Node nextNode = innerNode.chooseNext(3);
        assertTrue(nextNode instanceof DecisionNode, "Le nœud suivant doit être une instance de DecisionNode.");
    }

    @Test
    public void testChooseNextId50() {
        Node nextNode = innerNode.chooseNext(50);
        assertTrue(nextNode instanceof ChanceNode, "Le nœud suivant doit être une instance de ChanceNode.");
    }

    @Test
    public void testChooseNextInvalidId() {
        assertThrows(IllegalArgumentException.class, () -> {
            innerNode.chooseNext(99);
        }, "Devrait lancer IllegalArgumentException pour un ID non reconnu.");
    }
}
