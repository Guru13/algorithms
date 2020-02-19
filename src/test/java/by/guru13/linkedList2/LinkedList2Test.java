package by.guru13.linkedList2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class LinkedList2Test {

  private LinkedList2 linkedList2;

  @Before
  public void setUp() throws Exception {
    linkedList2 = new LinkedList2();
    linkedList2.addInTail(new Node(1));
    linkedList2.addInTail(new Node(2));
    linkedList2.addInTail(new Node(3));
    linkedList2.addInTail(new Node(4));
  }

  @After
  public void tearDown() throws Exception {
    linkedList2 = null;
  }

  @Test
  public void find() {
    assertEquals(3,linkedList2.find(3).value);
    assertEquals(4, linkedList2.find(4).value);
    assertEquals(1, linkedList2.find(1).value);
  }

  @Test
  public void findAll() {
    linkedList2.addInTail(new Node(4));
    linkedList2.addInTail(new Node(4));
    linkedList2.addInTail(new Node(4));
    assertEquals(4, linkedList2.findAll(4).size());
  }

  @Test
  public void remove() {
    linkedList2.remove(1);
    assertEquals(3, linkedList2.count());
    linkedList2.remove(2);
    assertEquals(2, linkedList2.count());
    linkedList2.remove(3);
    assertEquals(1, linkedList2.count());
    linkedList2.remove(4);
    assertEquals(0, linkedList2.count());
  }

  @Test
  public void removeAll() {
    linkedList2.addInTail(new Node(4));
    linkedList2.addInTail(new Node(4));
    linkedList2.addInTail(new Node(4));
    linkedList2.removeAll(4);
    assertEquals(0, linkedList2.findAll(4).size());
  }

  @Test
  public void clear() {
    linkedList2.clear();
    assertEquals(0, linkedList2.count());
  }

  @Test
  public void count() {
    assertEquals(4, linkedList2.count());
  }

  @Test
  public void contains() {
    linkedList2.contains(new Node(5));
    assertFalse(linkedList2.contains(new Node(5)));
    Node node6 = new  Node(6);
    linkedList2.addInTail(node6);
    assertTrue(linkedList2.contains(node6));
  }

  @Test
  public void insertAfter() {
    Node node = new Node(5);
    linkedList2.find(2);
    linkedList2.insertAfter(linkedList2.find(2), node);
    assertEquals(5, linkedList2.count());
    assertEquals(5, linkedList2.find(2).next.value);
    linkedList2.clear();
    linkedList2.insertAfter(null, node);
    assertEquals(1, linkedList2.count());
    assertEquals(5, linkedList2.find(5).value);
    LinkedList2 linkedListEmpty = new LinkedList2();
    linkedListEmpty.insertAfter(null, node);
    assertEquals(1, linkedListEmpty.count());
    assertEquals(5, linkedListEmpty.find(5).value);
    assertEquals(5, linkedListEmpty.head.value);
    assertEquals(node, linkedListEmpty.head);

    //if _nodeAfter is not in linkedList
    LinkedList2 linkedListEmpty2 = new LinkedList2();
    linkedListEmpty2.insertAfter(new Node(4), node);
    assertEquals(0, linkedListEmpty2.count());
    assertNull(linkedListEmpty2.find(5));
    assertNull(linkedListEmpty2.head);
  }
}