package by.guru13.powerSet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PowerSetTest {
    PowerSet powerSet;

    @Before
    public void setUp() throws Exception {
        powerSet = new PowerSet();
    }

    @Test
    public void put() {
        for (int i = 0; i <= 5; i++) {
            powerSet.put("hello world " + i);
        }
        powerSet.put("hello world 19");
        powerSet.put("hello world 19");
        powerSet.put("hello world 10");
        powerSet.put("hello world 10");
        assertTrue(powerSet.get("hello world 19"));
        assertTrue(powerSet.get("hello world 10"));
        assertEquals(8, powerSet.size);
        assertFalse(powerSet.get("hello world 9"));
//        for (String str : powerSet.slots) {
//            System.out.println("hash table str===" + str);
//        }
//        powerSet.put(null);
    }

    @Test
    public void putEqualsStrings() {
        String helloW = "hello world";
        powerSet.put(helloW);
        powerSet.put(helloW);
        long count = 0;
        for (String str : powerSet.slots) {
            if (helloW.equals(str)) {
                count++;
            }
        }
        assertEquals(1, count);
        assertEquals(1, powerSet.size);
    }

    @Test
    public void get() {
        for (int i = 0; i <= 18; i++) {
            powerSet.put("hello world " + i);
        }
        for (int i = 0; i <= 18; i++) {
            assertTrue(powerSet.get("hello world " + i));
        }

        assertTrue(powerSet.get("hello world 8"));
        assertTrue(powerSet.get("hello world 9"));
    }

    @Test
    public void remove() {
        for (int i = 0; i <= 10; i++) {
            powerSet.put("" + i);
        }
        assertEquals(11, powerSet.size);
        assertTrue(powerSet.remove("9"));
        assertFalse(powerSet.remove("9"));
        assertFalse(powerSet.remove("11"));

        assertEquals(10, powerSet.size);

        assertTrue(powerSet.remove("0"));
        assertTrue(powerSet.remove("1"));
        assertFalse(powerSet.remove("0"));
        assertFalse(powerSet.remove("1"));
        assertFalse(powerSet.remove(null));

        assertEquals(8, powerSet.size);
    }

    @Test
    public void removeAll() {
        for (int i = 0; i < powerSet.slots.length; i++) {
            powerSet.put("" + i);
        }
        for (String str : powerSet.slots) {
            assertTrue(powerSet.remove(str));
        }
    }

    @Test
    public void intersection() {
        PowerSet set2 = new PowerSet();
        powerSet.put("10");
        powerSet.put("11");
        powerSet.put("8");
        powerSet.put("4");
        set2.put("5");
        set2.put("1");
        set2.put("11");
        set2.put("4");
        PowerSet intersectionSet = powerSet.intersection(set2);

        assertTrue(intersectionSet.get("11"));
        assertTrue(intersectionSet.get("4"));
        assertFalse(intersectionSet.get("10"));
        assertFalse(intersectionSet.get("8"));
        assertFalse(intersectionSet.get("5"));
        assertFalse(intersectionSet.get("1"));
        assertEquals(2, intersectionSet.size);
    }

    @Test
    public void intersectionEmpty() {
        PowerSet set2 = new PowerSet();
        powerSet.put("10");
        powerSet.put("11");
        powerSet.put("8");
        powerSet.put("4");
        set2.put("5");
        set2.put("1");
        set2.put("111");
        set2.put("3");
        PowerSet intersectionSet = powerSet.intersection(set2);

        assertFalse(intersectionSet.get("11"));
        assertFalse(intersectionSet.get("4"));
        assertFalse(intersectionSet.get("10"));
        assertFalse(intersectionSet.get("8"));
        assertFalse(intersectionSet.get("5"));
        assertFalse(intersectionSet.get("1"));
        assertEquals(0, intersectionSet.size);
    }

    @Test
    public void intersectionEmpty2() {
        PowerSet set2 = new PowerSet();
        powerSet.put("10");
        powerSet.put("11");
        powerSet.put("8");
        powerSet.put("4");
        PowerSet intersectionSet = powerSet.intersection(set2);

        assertFalse(intersectionSet.get("11"));
        assertFalse(intersectionSet.get("4"));
        assertFalse(intersectionSet.get("10"));
        assertFalse(intersectionSet.get("8"));
        assertFalse(intersectionSet.get("5"));
        assertFalse(intersectionSet.get("1"));
        assertEquals(0, intersectionSet.size);
    }

    @Test
    public void intersectionEmpty3() {
        PowerSet set2 = new PowerSet();
        set2.put("10");
        set2.put("11");
        set2.put("8");
        set2.put("4");
        PowerSet intersectionSet = powerSet.intersection(set2);

        assertFalse(intersectionSet.get("11"));
        assertFalse(intersectionSet.get("4"));
        assertFalse(intersectionSet.get("10"));
        assertFalse(intersectionSet.get("8"));
        assertFalse(intersectionSet.get("5"));
        assertFalse(intersectionSet.get("1"));
        assertEquals(0, intersectionSet.size);
    }

    @Test
    public void union() {
        PowerSet set2 = new PowerSet();
        powerSet.put("10");
        powerSet.put("11");
        powerSet.put("8");
        powerSet.put("4");
        set2.put("5");
        set2.put("1");
        set2.put("11");
        set2.put("4");
        PowerSet unionSet = powerSet.union(set2);

        assertTrue(unionSet.get("11"));
        assertTrue(unionSet.get("4"));
        assertTrue(unionSet.get("10"));
        assertTrue(unionSet.get("8"));
        assertTrue(unionSet.get("5"));
        assertTrue(unionSet.get("1"));
        assertFalse(unionSet.get("111"));
        assertEquals(6, unionSet.size);
    }

    @Test
    public void unionEmpty() {
        PowerSet set2 = new PowerSet();
        powerSet.put("10");
        powerSet.put("11");
        powerSet.put("8");
        powerSet.put("4");
        PowerSet unionSet = powerSet.union(set2);

        assertTrue(unionSet.get("11"));
        assertTrue(unionSet.get("4"));
        assertTrue(unionSet.get("10"));
        assertTrue(unionSet.get("8"));
        assertFalse(unionSet.get("5"));
        assertFalse(unionSet.get("1"));
        assertFalse(unionSet.get("111"));
        assertEquals(4, unionSet.size);
    }

    @Test
    public void unionEmpty2() {
        PowerSet set2 = new PowerSet();
        powerSet.put("10");
        powerSet.put("11");
        powerSet.put("8");
        powerSet.put("4");
        PowerSet unionSet = set2.union(powerSet);

        assertTrue(unionSet.get("11"));
        assertTrue(unionSet.get("4"));
        assertTrue(unionSet.get("10"));
        assertTrue(unionSet.get("8"));
        assertFalse(unionSet.get("5"));
        assertFalse(unionSet.get("1"));
        assertFalse(unionSet.get("111"));
        assertEquals(4, unionSet.size);
    }

    @Test
    public void difference() {
        PowerSet set2 = new PowerSet();
        powerSet.put("10");
        powerSet.put("11");
        powerSet.put("8");
        powerSet.put("4");
        set2.put("5");
        set2.put("1");
        set2.put("11");
        set2.put("4");
        PowerSet differenceSet = powerSet.difference(set2);

        assertFalse(differenceSet.get("11"));
        assertFalse(differenceSet.get("4"));
        assertTrue(differenceSet.get("10"));
        assertTrue(differenceSet.get("8"));
        assertFalse(differenceSet.get("5"));
        assertFalse(differenceSet.get("1"));
        assertEquals(2, differenceSet.size);
    }

    @Test
    public void differenceEmpty() {
        PowerSet set2 = new PowerSet();
        powerSet.put("10");
        powerSet.put("11");
        powerSet.put("8");
        powerSet.put("4");
        set2.put("10");
        set2.put("11");
        set2.put("8");
        set2.put("4");
        PowerSet differenceSet = powerSet.difference(set2);

        assertFalse(differenceSet.get("111"));
        assertFalse(differenceSet.get("44"));
        assertFalse(differenceSet.get("10"));
        assertFalse(differenceSet.get("8"));
        assertFalse(differenceSet.get("5"));
        assertFalse(differenceSet.get("1"));
        assertEquals(0, differenceSet.size);
    }

    @Test
    public void isSubsetTrue() {
        PowerSet set2 = new PowerSet();
        powerSet.put("10");
        powerSet.put("11");
        powerSet.put("8");
        powerSet.put("4");
        powerSet.put("44");
        powerSet.put("54");
        set2.put("10");
        set2.put("11");
        set2.put("8");
        set2.put("4");
        assertTrue(powerSet.isSubset(set2));
    }

    @Test
    public void isSubsetFalse() {
        PowerSet set2 = new PowerSet();
        powerSet.put("10");
        powerSet.put("11");
        powerSet.put("8");
        powerSet.put("4");
        powerSet.put("44");
        powerSet.put("54");
        set2.put("10");
        set2.put("11");
        set2.put("111");
        set2.put("8");
        set2.put("4");
        assertFalse(powerSet.isSubset(set2));
    }

    @Test
    public void isSubsetFalse2() {
        PowerSet set2 = new PowerSet();
        powerSet.put("10");
        powerSet.put("11");
        powerSet.put("8");
        powerSet.put("4");

        set2.put("10");
        set2.put("11");
        set2.put("111");
        set2.put("8");
        set2.put("4");
        assertFalse(powerSet.isSubset(set2));
    }

    @Test
    public void isSubsetEmpty() {
        PowerSet set2 = new PowerSet();
        powerSet.put("10");
        powerSet.put("11");
        powerSet.put("8");
        powerSet.put("4");

        assertTrue(powerSet.isSubset(set2));
    }

    @Test
    public void isSubsetEmpty2() {
        PowerSet set2 = new PowerSet();
        set2.put("10");
        set2.put("11");
        set2.put("8");
        set2.put("4");

        assertFalse(powerSet.isSubset(set2));
    }
}