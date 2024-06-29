package Test;

import Representation.ChanceNode;
import Representation.InnerNode;
import Representation.Node;
import Univers.Monde;
import Univers.Personnage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class ChanceNodeTest {
    private ChanceNode chanceNode;
    private Monde monde;
    private Personnage personnage;

    @BeforeEach
    public void setUp() {
        personnage = new Personnage("Luffy", "Luffy");
        monde = new Monde(personnage);
        chanceNode = new ChanceNode(1, "Chance Node Test", monde);
    }

    @Test
    public void testAffichagePoints() {
        chanceNode.afficherPoints();
        assertEquals(10, personnage.getPoints(), "Les points du personnage doivent être initialement 10.");
    }

    @Test
    public void testDisplayPile() {
        // Simulate user input for the Scanner
        String input = "0\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Mock Random to return 1 (Pile)
        Random random = new Random() {
            @Override
            public int nextInt(int bound) {
                return 0; // Return 0 to simulate Pile
            }
        };

        chanceNode.display(50);

        // Check if points were correctly added
        assertEquals(20, personnage.getPoints(), "Les points du personnage doivent être 20 après un pile.");
    }

    @Test
    public void testDisplayFace() {
        // Simulate user input for the Scanner
        String input = "0\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Mock Random to return 2 (Face)
        Random random = new Random() {
            @Override
            public int nextInt(int bound) {
                return 1; // Return 1 to simulate Face
            }
        };

        chanceNode.display(50);

        // Check if points were not added
        assertEquals(10, personnage.getPoints(), "Les points du personnage doivent être 10 après un face.");
    }

    @Test
    public void testChooseNext() {
        Node nextNode = chanceNode.chooseNext(3);
        assertTrue(nextNode instanceof InnerNode, "Le nœud suivant doit être une instance de InnerNode.");
    }

    @Test
    public void testChooseNextInvalidId() {
        assertThrows(IllegalArgumentException.class, () -> {
            chanceNode.chooseNext(99);
        }, "Devrait lancer IllegalArgumentException pour un ID non reconnu.");
    }
}
