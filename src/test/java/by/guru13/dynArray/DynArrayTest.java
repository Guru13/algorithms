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
    public void whenIndexBiggerThanCapacity() {
        dynArray.getItem(25);
    }

    @Test
    public void append() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void remove() {
    }
}