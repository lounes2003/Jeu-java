package Test;

import static org.junit.jupiter.api.Assertions.*;

import Univers.Cle;
import org.junit.jupiter.api.Test;

public class CleTest {

    @Test
    public void testConstructor() {
        Cle cle = new Cle(true);
        assertTrue(cle.getFlag(), "Constructor should set the flag to true");

        Cle cle2 = new Cle(false);
        assertFalse(cle2.getFlag(), "Constructor should set the flag to false");
    }

    @Test
    public void testGetFlag() {
        Cle cle = new Cle(true);
        assertTrue(cle.getFlag(), "getFlag should return true");

        Cle cle2 = new Cle(false);
        assertFalse(cle2.getFlag(), "getFlag should return false");
    }

    @Test
    public void testSetFlag() {
        Cle cle = new Cle(true);
        cle.setFlag(false);
        assertFalse(cle.getFlag(), "setFlag should update the flag to false");

        cle.setFlag(true);
        assertTrue(cle.getFlag(), "setFlag should update the flag to true");
    }
}
