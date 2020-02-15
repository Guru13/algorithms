package by.guru13.linkedList;

import java.util.ArrayList;

public class LinkedList {
  public Node head;
  public Node tail;
  private int size;

  public LinkedList() {
    head = null;
    tail = null;
    size = 0;
  }

  public void addInTail(Node item) {
    if (this.head == null)
      this.head = item;
    else
      this.tail.next = item;
    this.tail = item;
    size++;
  }

  public Node find(int value) {
    Node node = this.head;
    while (node != null) {
      if (node.value == value)
        return node;
      node = node.next;
    }
    return null;
  }

  public ArrayList<Node> findAll(int _value) {
    ArrayList<Node> nodes = new ArrayList<Node>();
    Node node = this.head;
    while (node != null) {
      if (node.value == _value)
        nodes.add(node);
      node = node.next;
    }
    return nodes;
  }

  public boolean remove(int _value) {
    Node currentNode = this.head;
    Node prevNode = null;
    while (currentNode != null) {
      if (currentNode.value == _value) {
        if (prevNode != null) {
          prevNode.next = currentNode.next;
          if (currentNode.next == null) {
            this.tail = prevNode;
          }
        } else {
          this.head = this.head.next;
          if (this.head == null) {
            this.tail = null;
          }
        }
        size--;
        return true;
      }
      prevNode = currentNode;
      currentNode = currentNode.next;
    }
    return false;
  }

  public void removeAll(int _value) {
    boolean isRemoved = remove(_value);
    while (isRemoved) {
      isRemoved = remove(_value);
    }
  }

  public void clear() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  public int count() {
    return this.size;
  }

  public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
    if (_nodeToInsert == null ||_nodeAfter == _nodeToInsert) return;
    Node prevNode = null;
    Node cpNode = this.head;
    while (cpNode != null) {
      if (cpNode == _nodeAfter) {
        prevNode = _nodeAfter;
        break;
      }
      cpNode = cpNode.next;
    }

    if (_nodeAfter != null && prevNode == null) return;
    if (this.head == null) {
      this.head = _nodeToInsert;
      this.tail = _nodeToInsert;
    } else {
      if (_nodeAfter == null) {
        _nodeToInsert.next = this.head;
        this.head = _nodeToInsert;
      } else {
        _nodeToInsert.next = _nodeAfter.next;
        _nodeAfter.next = _nodeToInsert;
        if (_nodeAfter == this.tail) {
          this.tail = _nodeToInsert;
        }
      }
    }
    size++;
  }

  public LinkedList joinLists(LinkedList first, LinkedList second) {
    if (first.count() == second.count()) {
      LinkedList sumList = new LinkedList();
      Node firstListNode = first.head;
      Node secondListNode = second.head;
      for (int i=0; i < first.count(); i++) {
        sumList.addInTail(new Node(firstListNode.value + secondListNode.value));
        firstListNode = firstListNode.next;
        secondListNode = secondListNode.next;
      }
      return sumList;
    } else {
      return null;
    }
  }

}

class Node
{
  public int value;
  public Node next;
  public Node(int _value)
  {
    value = _value;
    next = null;
  }

  @Override
  public String toString() {
    return value + " - "  ;
  }
}