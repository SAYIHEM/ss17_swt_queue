import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class QueueImplWithoutDuplicatesTest extends QueueImplBaseTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
        elements = new String[] { s0, s1, s2, s3 };
        q = new QueueImpl<String>(false);
    }

    @Override
    @Test
    public void testAdd() {
        super.testAdd();
        for (int i = 0; i < elements.length; i++) {
            assertTrue("Queue.add() should return true if the specified element is added to the queue!",
                    q.add(elements[i]));
            assertEquals("Queue.add() should actually add the specified element if it is not contained in the queue!",
                    i + 1, q.size());
            assertFalse("Queue.add() should return false if the queue already contains the specified element!",
                    q.add(elements[i]));
            assertEquals("Queue.add() should not add the specified element if it is already contained in the queue!",
                    i + 1, q.size());
        }
    }
}
