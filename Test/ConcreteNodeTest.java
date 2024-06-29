package Test;

import Representation.ConcreteNode;
import Representation.Node;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConcreteNodeTest {

    @Test
    public void testConstructor() {
        int id = 1;
        String description = "Test Node";
        ConcreteNode node = new ConcreteNode(id, description);

        assertEquals(id, node.getId());
        assertEquals(description, node.getDescription());
    }

    @Test
    public void testDisplay() {
        ConcreteNode node = new ConcreteNode(1, "Test Node");
        // Since display only prints to console, you can manually check the output
        // or use a library to capture and assert console output
        node.display(1);
    }

    @Test
    public void testChooseNext() {
        ConcreteNode node = new ConcreteNode(1, "Test Node");
        Node nextNode = node.chooseNext(2);

        assertNotNull(nextNode);
        assertTrue(nextNode instanceof ConcreteNode);
        assertEquals(2, nextNode.getId());
        assertEquals("Next node", nextNode.getDescription());
    }
}
