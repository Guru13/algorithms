package by.guru13.queue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {

    Queue<Integer> queue;
    @Before
    public void setUp() throws Exception {
        queue = new Queue<Integer>();
    }

    @Test
    public void enqueue() {
        assertEquals(0, queue.size());
        queue.enqueue(1);
        assertEquals(1, queue.size());
        queue.enqueue(2);
        assertEquals(2, queue.size());
        queue.enqueue(3);
        assertEquals(3, queue.size());
    }

    @Test
    public void dequeue() {
        assertEquals(0, queue.size());
        assertNull(queue.dequeue());
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        assertEquals(4, queue.size());
        assertEquals(1, (long)queue.dequeue());
        assertEquals(2, (long)queue.dequeue());
        assertEquals(3, (long)queue.dequeue());
        assertEquals(1, queue.size());
        assertEquals(4, (long)queue.dequeue());
        assertEquals(0, queue.size());
    }

    @Test
    public void size() {
        assertEquals(0, queue.size());
        queue.enqueue(1);
        assertEquals(1, queue.size());
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(3, queue.size());
    }
}