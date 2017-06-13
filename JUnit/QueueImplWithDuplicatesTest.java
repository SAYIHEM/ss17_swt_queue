import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class QueueImplWithDuplicatesTest extends QueueImplBaseTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
        elements = new String[] { s0, s1, s1, s2, s1, s3, s2, s0, s3 };
        q = new QueueImpl<String>(true);
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
        }
    }
}
