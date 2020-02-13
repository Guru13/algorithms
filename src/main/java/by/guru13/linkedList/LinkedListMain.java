package by.guru13.linkedList;

import by.guru13.linkedList.LinkedList;
import by.guru13.linkedList.Node;

public class LinkedListMain {

  public static void main(String[] args) {
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

    printList(sumList);
  }

  private static void printList(LinkedList linkedList) {
    Node node = linkedList.head;
    while (node != null) {
      System.out.println("node----" + node.value);
      node = node.next;
    }
  }
}
