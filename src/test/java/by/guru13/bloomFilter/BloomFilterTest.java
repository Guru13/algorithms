package by.guru13.bloomFilter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BloomFilterTest {
    BloomFilter filter;

    @Before
    public void setUp() throws Exception {
        filter = new BloomFilter(32);
    }

    @Test
    public void hash1() {
    }

    @Test
    public void hash2() {
    }

    @Test
    public void add() {
    }

    @Test
    public void isValue() {
        filter.add("0123456789");
        filter.add("1234567890");
        filter.add("2345678901");
        filter.add("3456789012");
        filter.add("4567890123");
        filter.add("5678901234");
        filter.add("6789012345");
        filter.add("7890123456");
        filter.add("8901234567");
        filter.add("9012345678");
        assertTrue(filter.isValue("0123456789"));
        assertTrue(filter.isValue("1234567890"));
        assertTrue(filter.isValue("2345678901"));
        assertTrue(filter.isValue("3456789012"));
        assertTrue(filter.isValue("4567890123"));
        assertTrue(filter.isValue("5678901234"));
        assertTrue(filter.isValue("6789012345"));
        assertTrue(filter.isValue("7890123456"));
        assertTrue(filter.isValue("8901234567"));
        assertTrue(filter.isValue("9012345678"));
    }
}