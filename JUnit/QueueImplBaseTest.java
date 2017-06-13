import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public abstract class QueueImplBaseTest {
    protected Queue<String> q;
    protected String s0, s1, s2, s3;
    protected String[] elements;

    @Before
    public void setUp() {
        s0 = "elem0";
        s1 = "elem1";
        s2 = "elem2";
        s3 = "elem3";
    }

    @Test
    public void testAdd() {
        try {
            q.add(null);
            fail("Queue.add() should throw a NullPointerException if the specified element is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testRemove() {
        assertNull("QueueImpl.remove() should return null if the queue is empty!", q.remove());
        for (int i = 0; i < elements.length; i++) {
            q.add(elements[i]);
        }
        for (int i = 0; i < elements.length; i++) {
            assertEquals("QueueImpl.remove() should remove the first queue element and return it correctly!",
                    elements[i], q.remove());
            if (i + 1 < elements.length) {
                assertTrue("QueueImpl.remove() should remove the first element!", q.first() == elements[i + 1]);
            } else {
                assertTrue("QueueImpl.remove() should remove the first element!", q.first() == null);
            }
        }
    }

    @Test
    public void testFirst() {
        assertNull("QueueImpl.first() should return null if the queue is empty!", q.first());
        for (int i = 0; i < elements.length; i++) {
            q.add(elements[i]);
            assertEquals("QueueImpl.first() shoud return the first queue element!", elements[0], q.first());
        }
        for (int i = 0; i < elements.length; i++) {
            assertEquals("QueueImpl.first() shoud return the first queue element!", elements[i], q.first());
            q.remove();
        }
        assertNull("QueueImpl.first() should return null if the queue is empty!", q.first());
    }

    @Test
    public void testIsEmpty() {
        assertTrue("QueueImpl.isEmpty() should return true if the queue is empty!", q.isEmpty());
        q.add(s0);
        assertFalse("QueueImpl.isEmpty() should return false if the queue is not empty!", q.isEmpty());
        q.remove();
        assertTrue("QueueImpl.isEmpty() should return true if the queue is empty!", q.isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals("QueueImpl.size() should return the correct number!", 0, q.size());
        for (int i = 0; i < elements.length; i++) {
            q.add(elements[i]);
            assertEquals("QueueImpl.size() should return the correct number!", i + 1, q.size());
        }
    }
}
