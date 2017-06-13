import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

public class OrderedSetImplTest {
    private OrderedSet<String> os;
    private String s0, s1, s2;

    @Before
    public void setUp() {
        os = new OrderedSetImpl<String>(2);
        s0 = "elem0";
        s1 = "elem1";
        s2 = "elem2";
    }

    @Test
    public void testAddObjectNullArgument() {
        try {
            os.add(null);
            fail("OrderedSet.add(Object) should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testAddObject() {
        String[] elems = new String[] { s0, s1, s2 };
        for (int i = 0; i < elems.length; i++) {
            assertTrue("OrderedSet.add(Object) should return true if the specified element is added to the set!",
                    os.add(elems[i]));
            assertTrue("OrderedSet.add(Object) should actually add the element!", os.contains(elems[i]));

            assertFalse(
                    "OrderedSet.add(Object) should return false if the set already contains the specified element!",
                    os.add(elems[i]));
            if (os.size() > i + 1) {
                fail("OrderedSet.add(Object) should not add the specified element if it is already within the set!");
            }
        }
    }

    @Test
    public void testAddIntObjectNullArgument() {
        try {
            os.add(null);
            fail("OrderedSet.add(int, Object) should throw a NullPointerException if the specified element is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testAddIntObjectIndexOutOfBounds() {
        try {
            os.add(100, "test");
            fail("OrderedSet.add(int, Object) should throw an IndexOutOfBoundsException if the specified index is out of range!");
        } catch (IndexOutOfBoundsException e) {
        }
    }

    @Test
    public void testAddIntObject() {
        os.add(0, s0);
        assertTrue("OrderedSet.add(int, Object) should actually add the element!", os.contains(s0));
        os.add(0, s0);
        if (os.size() > 1) {
            fail("OrderedSet.add(int, Object) should not add the specified element if it is already within the set!");
        }

        os.add(0, s1);
        assertTrue("OrderedSet.add(int, Object) should actually add the element!", os.contains(s1));
        assertTrue("OrderedSet.add(int, Object) should not remove any elements!", os.contains(s0));
        assertTrue(
                "OrderedSet.add(int, Object) should store the element at the specified position and shift other elements to the right if needed!",
                os.get(0) == s1 && os.get(1) == s0);
        os.add(1, s1);
        if (os.size() > 2) {
            fail("OrderedSet.add(int, Object) should not add the specified element if it is already within the set!");
        }

        os.add(1, s2);
        assertTrue("OrderedSet.add(int, Object) should actually add the element!", os.contains(s2));
        assertTrue("OrderedSet.add(int, Object) should not remove any elements!", os.contains(s0) && os.contains(s1));
        assertTrue(
                "OrderedSet.add(int, Object) should store the element at the specified position and shift other elements to the right if needed!",
                os.get(0) == s1 && os.get(1) == s2 && os.get(2) == s0);
        os.add(0, s2);
        if (os.size() > 3) {
            fail("OrderedSet.add(int, Object) should not add the specified element if it is already within the set!");
        }
    }

    @Test
    public void testSetNullArgument() {
        os.add(s0);
        try {
            os.set(0, null);
            fail("OrderedSet.set() should throw a NullPointerException if the specified element is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testSetIndexOutOfBounds() {
        try {
            os.set(100, "test");
            fail("OrderedSet.set() should throw an IndexOutOfBoundsException if the specified position is out of range!");
        } catch (IndexOutOfBoundsException e) {
        }
    }

    @Test
    public void testSet() {
        os.add(s0);
        os.add(s1);
        assertNull("OrderedSet.set() should return null if the set already contains the specified element!",
                os.set(0, s1));
        assertTrue(
                "OrderedSet.set() should not replace any element of the set if the set already contains the specified element!",
                os.contains(s0));
        assertNull("OrderedSet.set() should return null if the set already contains the specified element!",
                os.set(1, s1));
        assertEquals("OrderedSet.set() should return the element that was previously at the specified position!", s1,
                os.set(1, s2));
        assertEquals(
                "OrderedSet.set() should actually put the specified element on the specified position of the set!",
                s2, os.get(1));
        assertEquals(
                "OrderedSet.set() should replace the element at the specified position rather than adding the specified element as separate set element!",
                2, os.size());
    }

    @Test
    public void testAddAllCollection() {
        try {
            os.addAll(new LinkedList<String>());
            fail("OrderedSet.addAll(Collection) should throw an UnsupportedOperationException!");
        } catch (UnsupportedOperationException uoe) {
        }
    }

    @Test
    public void testAddAllIntCollection() {
        try {
            os.addAll(0, new LinkedList<String>());
            fail("OrderedSet.addAll(int, Collection) should throw an UnsupportedOperationException!");
        } catch (UnsupportedOperationException uoe) {
        }
    }
}
