package by.guru13.dynArray;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DynArrayTest {
    DynArray<Integer> dynArray = new DynArray<Integer>(Integer.class);

    @Before
    public void setUp() throws Exception {
        for (int i = 0; i < dynArray.array.length; i++) {
            dynArray.array[i] = i;
            dynArray.count++;
        }
    }

    @After
    public void tearDown() throws Exception {
        dynArray.array = null;
        dynArray.count = 0;
    }

    @Test
    public void makeArray() {
        dynArray.makeArray(20);
        assertEquals(0, (long)dynArray.array[0]);
        assertEquals(1, (long)dynArray.array[1]);
        assertEquals(15, (long)dynArray.array[15]);
        assertNull(dynArray.array[16]);
        assertEquals(20, (long)dynArray.capacity);
    }

    @Test
    public void getItem() {
        assertEquals(0, (long)dynArray.getItem(0));
        assertEquals(1, (long)dynArray.getItem(1));
        assertEquals(15, (long)dynArray.getItem(15));
        dynArray.makeArray(20);
        assertNull(dynArray.getItem(16));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenIndexBiggerThanCount() {
        dynArray.getItem(16);
    }

    @Test
    public void append() {
        dynArray.append(16);
        assertEquals(16, (long)dynArray.getItem(16));
        assertEquals(5, (long)dynArray.getItem(5));
        assertEquals(17, dynArray.count);
        assertEquals(32, dynArray.capacity);
    }

    @Test
    public void insert() {
        dynArray.insert(17, 2);
        assertEquals(17, (long)dynArray.getItem(2));
        assertEquals(2, (long)dynArray.getItem(3));
        assertEquals(17, dynArray.count);
        assertEquals(32, dynArray.capacity);
        assertNull(dynArray.getItem(17));
        assertNull(dynArray.getItem(18));
    }

    @Test
    public void insertToTheEnd() {
        dynArray.insert(16, 16);
        assertEquals(16, (long)dynArray.getItem(16));
        assertEquals(17, dynArray.count);
        assertEquals(32, dynArray.capacity);
        assertNull(dynArray.getItem(17));
        assertNull(dynArray.getItem(18));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenIndexBiggerThanCountInsert() {
        dynArray.insert(16, 16);
        dynArray.insert(19, 19);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenIndexBiggerThanCountRemove() {
        dynArray.remove(16);

    }

    @Test
    public void remove() {
        dynArray.remove(15);
        assertEquals(15, dynArray.count);
        assertEquals(16, dynArray.capacity);
        dynArray.remove(7);
        assertEquals(14, dynArray.count);
        assertEquals(16, dynArray.capacity);
    }

    @Test
    public void removeWhenBufferChanged() {
        dynArray.insert(16, 16);
        assertEquals(17, dynArray.count);
        assertEquals(32, dynArray.capacity);
        dynArray.remove(2);
        assertEquals(16, dynArray.count);
        assertEquals(32, dynArray.capacity);
        dynArray.remove(3);
        assertEquals(15, dynArray.count);
        assertEquals(21, dynArray.capacity);
    }
}