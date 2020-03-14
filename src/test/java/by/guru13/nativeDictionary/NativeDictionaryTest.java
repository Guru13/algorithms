package by.guru13.nativeDictionary;

import by.guru13.hashTable.HashTable;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NativeDictionaryTest {
    NativeDictionary<Integer> nativeDictionary;

    @Before
    public void setUp() throws Exception {
        nativeDictionary = new NativeDictionary<Integer>(19, Integer.class);
    }

    @Test
    public void isKey() {
        nativeDictionary.put("one", 1);
        nativeDictionary.put("two", 2);
        nativeDictionary.put("three", 3);
        nativeDictionary.put("four", 4);
        nativeDictionary.put("five", 5);
        nativeDictionary.put("five", 6);
        assert nativeDictionary.isKey("one");
        assert nativeDictionary.isKey("two");
        assert nativeDictionary.isKey("three");
        assert nativeDictionary.isKey("four");
        assert nativeDictionary.isKey("five");
        assert !nativeDictionary.isKey("six");
    }

    @Test
    public void put() {
        nativeDictionary.put("one", 1);
        nativeDictionary.put("two", 2);
        nativeDictionary.put("three", 3);
        nativeDictionary.put("four", 4);
        nativeDictionary.put("five", 5);
        assertEquals(1, (long)nativeDictionary.get("one"));
        assertEquals(2, (long)nativeDictionary.get("two"));
        assertEquals(3, (long)nativeDictionary.get("three"));
        assertEquals(4, (long)nativeDictionary.get("four"));
        assertEquals(5, (long)nativeDictionary.get("five"));
        nativeDictionary.put("five", 6);
        assertEquals(6, (long)nativeDictionary.get("five"));
    }

    @Test
    public void get() {
        for (int i = 0; i < nativeDictionary.size; i++) {
            nativeDictionary.put(""+i, i);
        }
        for (int i = 0; i < nativeDictionary.size; i++) {
            assertEquals(i, (long)nativeDictionary.get(""+i));
        }

    }
}