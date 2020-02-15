package by.guru13.linkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {

  private LinkedList linkedList;
  @Before
  public void setUp() throws Exception {
    linkedList = new LinkedList();
    linkedList.addInTail(new Node(1));
    linkedList.addInTail(new Node(2));
    linkedList.addInTail(new Node(3));
    linkedList.addInTail(new Node(4));
  }

  @After
  public void tearDown() throws Exception {
    linkedList = null;
  }

  @Test
  public void find() {
    assertEquals(3,linkedList.find(3).value);
    assertEquals(4, linkedList.find(4).value);
    assertEquals(1, linkedList.find(1).value);
  }

  @Test
  public void findAll() {
    linkedList.addInTail(new Node(4));
    linkedList.addInTail(new Node(4));
    linkedList.addInTail(new Node(4));
    assertEquals(4, linkedList.findAll(4).size());
  }

  @Test
  public void remove() {
    linkedList.remove(1);
    assertEquals(3, linkedList.count());
    linkedList.remove(2);
    assertEquals(2, linkedList.count());
    linkedList.remove(3);
    assertEquals(1, linkedList.count());
    linkedList.remove(4);
    assertEquals(0, linkedList.count());
  }

  @Test
  public void removeAll() {
    linkedList.addInTail(new Node(4));
    linkedList.addInTail(new Node(4));
    linkedList.addInTail(new Node(4));
    linkedList.removeAll(4);
    assertEquals(0, linkedList.findAll(4).size());
  }

  @Test
  public void clear() {
    linkedList.clear();
    assertEquals(0, linkedList.count());
  }

  @Test
  public void count() {
    assertEquals(4, linkedList.count());
  }

  @Test
  public void insertAfter() {
    Node node = new Node(5);
    linkedList.find(2);
    linkedList.insertAfter(linkedList.find(2), node);
    assertEquals(5, linkedList.count());
    assertEquals(5, linkedList.find(2).next.value);
    linkedList.clear();
    linkedList.insertAfter(null, node);
    assertEquals(1, linkedList.count());
    assertEquals(5, linkedList.find(5).value);
    LinkedList linkedListEmpty = new LinkedList();
    linkedListEmpty.insertAfter(null, node);
    assertEquals(1, linkedListEmpty.count());
    assertEquals(5, linkedListEmpty.find(5).value);
    assertEquals(5, linkedListEmpty.head.value);
    assertEquals(node, linkedListEmpty.head);

    //if _nodeAfter is not in linkedList
    LinkedList linkedListEmpty2 = new LinkedList();
    linkedListEmpty2.insertAfter(new Node(4), node);
    assertEquals(0, linkedListEmpty2.count());
    assertNull(linkedListEmpty2.find(5));
    assertNull(linkedListEmpty2.head);

  }

  @Test
  public void joinLists() {
    LinkedList linkedList = new LinkedList();
    LinkedList firsList = new LinkedList();
    LinkedList secondList = new LinkedList();
    Node node1 = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(3);
    Node node4 = new Node(4);
    Node node5 = new Node(5);
    Node node6 = new Node(6);
    firsList.addInTail(node1);
    firsList.addInTail(node2);
    firsList.addInTail(node3);
    secondList.addInTail(node4);
    secondList.addInTail(node5);
    secondList.addInTail(node6);
    LinkedList sumList = linkedList.joinLists(firsList, secondList);
    assertEquals(5, sumList.head.value);
    assertEquals(7, sumList.head.next.value);
    assertEquals(9, sumList.tail.value);
  }

}