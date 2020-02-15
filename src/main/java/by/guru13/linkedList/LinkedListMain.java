package by.guru13.linkedList;


public class LinkedListMain {

  public static void main(String[] args) {
    Node node1 = new Node(1);
    Node node2 = new Node(2);

    LinkedList emptyList = new LinkedList();
//    emptyList.addInTail(node1);
    emptyList.insertAfter(null, node1);
    printList(emptyList);
    System.out.println("tail---" + emptyList.tail);
    System.out.println("head---" + emptyList.head);
    System.out.println("size---" + emptyList.count());
  }

  private static void printList(LinkedList linkedList) {
    Node node = linkedList.head;
    while (node != null) {
      System.out.println("node----" + node.value);
      node = node.next;
    }
  }
}
