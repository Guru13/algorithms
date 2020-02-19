package by.guru13.linkedList2;

public class LinkedList2Main {
  public static void main(String[] args) {
    test1Element();
    addInTail();
    addInHead();
    addInHead1Element();
    addInTail1Element();
    addInEmptyList();
    addInEmptyListNoExistsNode();



  }

  private static void printList(LinkedList2 linkedList) {
    Node node = linkedList.head;
    while (node != null) {
      System.out.println("node----" + node.value);
      node = node.next;
    }
  }

  private static void printReverseList(LinkedList2 linkedList) {
    Node node = linkedList.tail;
    while (node != null) {
      System.out.println("node----" + node.value);
      node = node.prev;
    }
  }

  private static void test1Element(){
    System.out.println("test1Element----");
    Node node1 = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(3);
    Node node4 = new Node(4);
    LinkedList2 linkedList2 = new LinkedList2();
    linkedList2.addInTail(node1);
    linkedList2.addInTail(node2);
    linkedList2.addInTail(node3);
//    linkedList2.insertAfter(null, new Node(2));
//    System.out.println("test add null----");
//    printList(linkedList2);
    linkedList2.insertAfter(node1, node4);
    System.out.println("test add 1----");
    System.out.println("test add 12----" + node4.prev.value);
    printList(linkedList2);

    System.out.println("test add 12----" + node4.prev.value);
    printReverseList(linkedList2);
    System.out.println("test tail----" + (linkedList2.head == node1));
    System.out.println("test head----" + (linkedList2.tail == node3));
  }

  private static void addInTail() {
    Node node1 = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(3);
    Node node4 = new Node(4);
    LinkedList2 linkedList2 = new LinkedList2();
    linkedList2.addInTail(node1);
    linkedList2.addInTail(node2);
    linkedList2.addInTail(node3);
    linkedList2.insertAfter(node3, node4);
    System.out.println("test tail----" + (linkedList2.head == node1));
    System.out.println("test head----" + (linkedList2.tail == node4));
    printList(linkedList2);
    printReverseList(linkedList2);
  }

  private static void addInHead() {
    Node node1 = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(3);
    Node node4 = new Node(4);
    LinkedList2 linkedList2 = new LinkedList2();
    linkedList2.addInTail(node1);
    linkedList2.addInTail(node2);
    linkedList2.addInTail(node3);
    linkedList2.insertAfter(null, node4);
    System.out.println("test head----" + (linkedList2.head == node4));
    System.out.println("test tail----" + (linkedList2.tail == node3));
    printList(linkedList2);
    printReverseList(linkedList2);
  }

  private static void addInHead1Element() {
    Node node1 = new Node(1);
    Node node4 = new Node(4);
    LinkedList2 linkedList2 = new LinkedList2();
    linkedList2.addInTail(node1);
    linkedList2.insertAfter(null, node4);
    System.out.println("test head----" + (linkedList2.head == node4));
    System.out.println("test tail----" + (linkedList2.tail == node1));
    printList(linkedList2);
    printReverseList(linkedList2);
  }
  private static void addInTail1Element() {
    Node node1 = new Node(1);
    Node node4 = new Node(4);
    LinkedList2 linkedList2 = new LinkedList2();
    linkedList2.addInTail(node1);
    linkedList2.insertAfter(node1, node4);
    System.out.println("test head----" + (linkedList2.head == node1));
    System.out.println("test tail----" + (linkedList2.tail == node4));
    printList(linkedList2);
    printReverseList(linkedList2);
  }
  private static void addInEmptyList() {
    Node node1 = new Node(1);
    Node node4 = new Node(4);
    LinkedList2 linkedList2 = new LinkedList2();
//    linkedList2.addInTail(node1);
    linkedList2.insertAfter(null, node4);
    System.out.println("test head----" + (linkedList2.head == node4));
    System.out.println("test tail----" + (linkedList2.tail == node4));
    printList(linkedList2);
    printReverseList(linkedList2);
  }

  private static void addInEmptyListNoExistsNode() {
    Node node1 = new Node(1);
    Node node4 = new Node(4);
    LinkedList2 linkedList2 = new LinkedList2();
//    linkedList2.addInTail(node1);
    linkedList2.insertAfter(node1, node4);
    System.out.println("test head----" + (linkedList2.head == null));
    System.out.println("test tail----" + (linkedList2.tail == null));
    printList(linkedList2);
    printReverseList(linkedList2);
  }
}
