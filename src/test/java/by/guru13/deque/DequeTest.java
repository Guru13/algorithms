package by.guru13.deque;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DequeTest {

    Deque<Integer> deque;

    @Before
    public void setUp() throws Exception {
        deque = new Deque<Integer>();
    }

    @Test
    public void addFront() {
        assertEquals(0, deque.size());
        deque.addFront(1);
        assertEquals(1, deque.size());
        deque.addFront(2);
        assertEquals(2, deque.size());
        deque.addFront(3);
        assertEquals(3, deque.size());
    }

    @Test
    public void addTail() {
        assertEquals(0, deque.size());
        deque.addTail(1);
        assertEquals(1, deque.size());
        deque.addTail(2);
        assertEquals(2, deque.size());
        deque.addTail(3);
        assertEquals(3, deque.size());
        assertEquals(1, (long)deque.removeFront());
        assertEquals(2, deque.size());
    }

    @Test
    public void removeFront() {
        assertEquals(0, deque.size());
        assertNull(deque.removeFront());
        deque.addFront(1);
        deque.addFront(2);
        deque.addFront(3);
        assertEquals(3, (long)deque.removeFront());
        assertEquals(2, deque.size());
        assertEquals(2, (long)deque.removeFront());
        assertEquals(1, deque.size());
        assertEquals(1, (long)deque.removeFront());
        assertEquals(0, deque.size());

    }

    @Test
    public void removeTail() {
        assertEquals(0, deque.size());
        assertNull(deque.removeTail());
        deque.addFront(1);
        deque.addFront(2);
        deque.addFront(3);
        deque.addFront(4);
        deque.addFront(5);
        assertEquals(1, (long)deque.removeTail());
        assertEquals(4, deque.size());
        assertEquals(2, (long)deque.removeTail());
        assertEquals(3, deque.size());
        assertEquals(3, (long)deque.removeTail());
        assertEquals(2, deque.size());
        assertEquals(4, (long)deque.removeTail());
        assertEquals(1, deque.size());
        assertEquals(5, (long)deque.removeTail());
        assertEquals(0, deque.size());
    }

    @Test
    public void size() {
        assertEquals(0, deque.size());
        deque.addFront(1);
        assertEquals(1, deque.size());
        deque.addTail(2);
        assertEquals(2, deque.size());
        deque.addFront(3);
        deque.addFront(4);
        deque.addFront(5);
        deque.removeFront();
        deque.removeTail();
        assertEquals(3, deque.size());
    }
}