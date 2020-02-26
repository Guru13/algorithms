package by.guru13.stack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {

    Stack<Integer> stack;
    @Before
    public void setUp() throws Exception {
        stack = new Stack<Integer>();
    }

    @After
    public void tearDown() throws Exception {
        stack = null;
    }
    @Test
    public void size() {
        assertEquals(0, stack.size());
        stack.push(1);
        assertEquals(1, stack.size());
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.size());
    }

    @Test
    public void pop() {
        assertEquals(0, stack.size());
        assertNull(stack.pop());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, (long)stack.pop());
        assertEquals(2, stack.size());
        assertEquals(2, (long)stack.pop());
        assertEquals(1, stack.size());
        assertEquals(1, (long)stack.pop());
        assertEquals(0, stack.size());
    }

    @Test
    public void push() {
        assertEquals(0, stack.size());
        assertNull(stack.peek());
        stack.push(1);
        assertEquals(1, (long)stack.peek());
        assertEquals(1, stack.size());
        stack.push(2);
        assertEquals(2, (long)stack.peek());
        assertEquals(2, stack.size());
        stack.push(3);
        assertEquals(3, (long)stack.peek());
        assertEquals(3, stack.size());
    }

    @Test
    public void peek() {
        assertEquals(0, stack.size());
        assertNull(stack.peek());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, (long)stack.peek());
        assertEquals(3, stack.size());
        stack.pop();
        assertEquals(2, (long)stack.peek());
        assertEquals(2, stack.size());

    }
}