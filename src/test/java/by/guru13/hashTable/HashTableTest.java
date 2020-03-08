package by.guru13.hashTable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HashTableTest {
    HashTable hashTable;

    @Before
    public void setUp() throws Exception {
        hashTable = new HashTable(19, 3);
    }

    @Test
    public void hashFun() {
        assertEquals(hashTable.hashFun("hello world"), hashTable.hashFun("hello world"));
        assertEquals(12, hashTable.hashFun("hello world"));
//        System.out.println(hashTable.hashFun("hello world"));
    }

    @Test
    public void seekSlot() {
        for (int i = 0; i <= 18; i++) {
            hashTable.put("hello world " + i);
        }
        assertEquals(-1, hashTable.seekSlot("hello world 19"));
    }

    @Test
    public void put() {
        for (int i = 0; i <= 18; i++) {
            hashTable.put("hello world " + i);
        }
        assertEquals(-1, hashTable.put("hello world 19"));
        assertEquals(10, hashTable.put("hello world 10"));
//        for (String str : hashTable.slots) {
//            System.out.println("hash table str===" + str);
//        }
    }

    @Test
    public void putEqualsStrings() {
        String helloW = "hello world";
        hashTable.put(helloW);
        hashTable.put(helloW);
        long count = 0;
        for (String str : hashTable.slots) {
            if (helloW.equals(str)) {
                count++;
            }
        }
        assertEquals(1, count);
    }

    @Test
    public void find() {
        for (int i = 0; i <= 18; i++) {
            hashTable.put("hello world " + i);
        }
        assertEquals(7, hashTable.find("hello world 8"));
        assertEquals(9, hashTable.find("hello world 11"));
        assertEquals(-1, hashTable.find("hello world 138"));
        assertEquals(-1, hashTable.find("hello world 19"));
    }
}