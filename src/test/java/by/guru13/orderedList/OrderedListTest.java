package by.guru13.orderedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderedListTest {

    OrderedList<Integer> orderedList;
    OrderedList<Integer> orderedListDesc;
    @Before
    public void setUp() throws Exception {
        orderedList = new OrderedList<Integer>(true);
        orderedListDesc = new OrderedList<Integer>(false);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void compareNumbers() {

        //compare integers
        assertEquals(-1, orderedList.compare(5, 6));
        assertEquals(1, orderedList.compare(6, 5));
        assertEquals(0, orderedList.compare(6, 6));

        //compare double
        OrderedList<Double> orderedListDouble = new OrderedList<Double>(true);
        assertEquals(-1, orderedListDouble.compare(5.2, 6.2));
        assertEquals(1, orderedListDouble.compare(6.2, 5.2));
        assertEquals(0, orderedListDouble.compare(6.2, 6.2));
    }

    @Test
    public void compareStrings() {
        OrderedList<String> orderedListString = new OrderedList<String>(true);
        assertEquals(-1, orderedListString.compare("a", "b"));
        assertEquals(1, orderedListString.compare("b", "a"));
        assertEquals(0, orderedListString.compare("b", "b"));

        assertEquals(-1, orderedListString.compare(" a", "b"));
        assertEquals(1, orderedListString.compare(" b", "a"));
        assertEquals(0, orderedListString.compare(" b", "b"));

        assertEquals(-1, orderedListString.compare(" a ", "b"));
        assertEquals(1, orderedListString.compare(" b ", "a"));
        assertEquals(0, orderedListString.compare(" b ", "b"));

        assertEquals(-1, orderedListString.compare(" a ", "b "));
        assertEquals(1, orderedListString.compare(" b ", " a"));
        assertEquals(0, orderedListString.compare(" b ", " b"));

    }

    @Test
    public void add() {
        orderedList.add(3);
        assertEquals(1, orderedList.count());
        assertEquals(3, (long)orderedList.head.value);
        assertEquals(3, (long)orderedList.tail.value);
        orderedList.add(8);
        orderedList.add(7);
        orderedList.add(4);
        assertEquals(4, orderedList.count());
        assertEquals(3, (long)orderedList.head.value);
        assertEquals(8, (long)orderedList.tail.value);

        assertEquals(4, (long)orderedList.head.next.value);
        assertEquals(7, (long)orderedList.tail.prev.value);
        assertNull(orderedList.tail.next);
        assertNull(orderedList.head.prev);
        orderedList.add(5);
        orderedList.add(4);
        printList(orderedList);
    }

    @Test
    public void add_desc() {
        orderedListDesc.add(3);
        assertEquals(1, orderedListDesc.count());
        assertEquals(3, (long)orderedListDesc.head.value);
        assertEquals(3, (long)orderedListDesc.tail.value);
        orderedListDesc.add(8);
        orderedListDesc.add(7);
        orderedListDesc.add(4);
        assertEquals(4, orderedListDesc.count());
        assertEquals(8, (long)orderedListDesc.head.value);
        assertEquals(3, (long)orderedListDesc.tail.value);

        assertEquals(7, (long)orderedListDesc.head.next.value);
        assertEquals(4, (long)orderedListDesc.tail.prev.value);
        assertNull(orderedListDesc.tail.next);
        assertNull(orderedListDesc.head.prev);
        orderedList.add(5);
        orderedList.add(4);
        printList(orderedListDesc);
    }

    @Test
    public void find() {
        orderedList.add(3);
        orderedList.add(8);
        orderedList.add(7);
        orderedList.add(4);
        orderedList.add(4);
        assertEquals(7, (long)orderedList.find(7).value);
        assertEquals(4, (long)orderedList.find(4).value);
        assertEquals(8, (long)orderedList.tail.value);
        assertNull(orderedList.find(5));
        printList(orderedList);
    }

    @Test
    public void find_desc() {
        orderedListDesc.add(3);
        orderedListDesc.add(8);
        orderedListDesc.add(7);
        orderedListDesc.add(4);
        orderedListDesc.add(4);
        assertEquals(7, (long)orderedListDesc.find(7).value);
        assertEquals(4, (long)orderedListDesc.find(4).value);
        assertEquals(3, (long)orderedListDesc.tail.value);
        assertNull(orderedListDesc.find(5));
        printList(orderedListDesc);
    }

    @Test
    public void delete() {
        orderedList.add(3);
        orderedList.add(5);
        orderedList.add(8);
        orderedList.add(7);
        orderedList.add(4);
        orderedList.add(4);
        assertEquals(6, orderedList.count());
        orderedList.delete(5);
        printList(orderedList);
        assertEquals(5, orderedList.count());
        orderedList.delete(5);
        assertEquals(5, orderedList.count());
        orderedList.delete(4);
        printList(orderedList);
        assertEquals(4, orderedList.count());
        orderedList.delete(4);
        assertEquals(3, orderedList.count());
        orderedList.delete(7);
        assertEquals(2, orderedList.count());
        orderedList.delete(8);
        assertEquals(1, orderedList.count());
        orderedList.delete(3);
        assertEquals(0, orderedList.count());
        orderedList.add(4);
        orderedList.add(4);
        orderedList.delete(4);
        assertEquals(1, orderedList.count());
        orderedList.delete(4);
        assertEquals(0, orderedList.count());
        printList(orderedList);
    }

    @Test
    public void delete_desc() {
        orderedListDesc.add(3);
        orderedListDesc.add(5);
        orderedListDesc.add(8);
        orderedListDesc.add(7);
        orderedListDesc.add(4);
        orderedListDesc.add(4);
        assertEquals(6, orderedListDesc.count());
        orderedListDesc.delete(5);
        printList(orderedListDesc);
        assertEquals(5, orderedListDesc.count());
        orderedListDesc.delete(5);
        assertEquals(5, orderedListDesc.count());
        orderedListDesc.delete(4);
        printList(orderedListDesc);
        assertEquals(4, orderedListDesc.count());
        orderedListDesc.delete(4);
        assertEquals(3, orderedListDesc.count());
        orderedListDesc.delete(7);
        assertEquals(2, orderedListDesc.count());
        orderedListDesc.delete(8);
        assertEquals(1, orderedListDesc.count());
        orderedListDesc.delete(3);
        assertEquals(0, orderedListDesc.count());
        orderedListDesc.add(4);
        orderedListDesc.add(4);
        orderedListDesc.delete(4);
        assertEquals(1, orderedListDesc.count());
        orderedListDesc.delete(4);
        assertEquals(0, orderedListDesc.count());
        printList(orderedListDesc);
    }

    @Test
    public void getAll() {
        orderedList.add(3);
        orderedList.add(5);
        orderedList.add(8);
        orderedList.add(7);
        orderedList.add(4);
        orderedList.add(4);
        orderedList.getAll();
        assertEquals(6, orderedList.getAll().size());
        assertEquals(3, (long)orderedList.getAll().get(0).value);
        assertEquals(4, (long)orderedList.getAll().get(1).value);
        assertEquals(4, (long)orderedList.getAll().get(2).value);
        assertEquals(5, (long)orderedList.getAll().get(3).value);
        assertEquals(7, (long)orderedList.getAll().get(4).value);
        assertEquals(8, (long)orderedList.getAll().get(5).value);
    }

    @Test
    public void getAll_desc() {
        orderedListDesc.add(3);
        orderedListDesc.add(5);
        orderedListDesc.add(8);
        orderedListDesc.add(7);
        orderedListDesc.add(4);
        orderedListDesc.add(4);
        orderedListDesc.getAll();
        assertEquals(6, orderedListDesc.getAll().size());
        assertEquals(3, (long)orderedListDesc.getAll().get(5).value);
        assertEquals(4, (long)orderedListDesc.getAll().get(4).value);
        assertEquals(4, (long)orderedListDesc.getAll().get(3).value);
        assertEquals(5, (long)orderedListDesc.getAll().get(2).value);
        assertEquals(7, (long)orderedListDesc.getAll().get(1).value);
        assertEquals(8, (long)orderedListDesc.getAll().get(0).value);
    }

    @Test
    public void clear() {
        orderedList.add(3);
        orderedList.add(5);
        orderedList.add(8);
        orderedList.add(7);
        orderedList.add(4);
        orderedList.add(4);
        orderedList.clear(true);
        assertEquals(0, orderedList.count());
    }

    private static void printList(OrderedList<Integer> orderedList) {
        Node node = orderedList.head;
        while (node != null) {
            System.out.print("-" + node.value);
            node = node.next;
        }
        System.out.println();
    }
}