package by.guru13.linkedList2;
import java.util.*;

public class LinkedList2
{
  public Node head;
  public Node tail;
  private int size;

  public LinkedList2()
  {
    head = null;
    tail = null;
    size = 0;
  }

  public void addInTail(Node _item)
  {
    if (head == null) {
      this.head = _item;
      this.head.next = null;
      this.head.prev = null;
    } else {
      this.tail.next = _item;
      _item.prev = tail;
    }
    this.tail = _item;
    size++;
  }

  public boolean contains(Node _node) {
    if (_node == null) return false;
    Node node = this.head;
    while (node != null) {
      if (node == _node) {
        return true;
      }
      node = node.next;
    }
    return false;
  }

  public Node find(int _value)
  {
    Node node = this.head;
    while (node != null) {
      if (node.value == _value)
        return node;
      node = node.next;
    }
    return null;
  }

  public ArrayList<Node> findAll(int _value)
  {
    ArrayList<Node> nodes = new ArrayList<Node>();
    Node node = this.head;
    while (node != null) {
      if (node.value == _value)
        nodes.add(node);
      node = node.next;
    }
    return nodes;
  }

  public boolean remove(int _value)
  {
    Node currentNode = this.head;
    Node prevNode = null;
    while (currentNode != null) {
      if (currentNode.value == _value) {
        if (prevNode != null) {
          prevNode.next = currentNode.next;
          if (currentNode.next == null) {
            this.tail = prevNode;
          } else {
            currentNode.next.prev = prevNode;
          }
          size--;
        } else {
          if (size != 0) {
            this.head = this.head.next;
            size--;
            if (size == 0) {
              this.tail = null;
            } else {
              this.head.prev = null;
            }
          }
        }

        return true;
      }
      prevNode = currentNode;
      currentNode = currentNode.next;
    }
    return false;
  }

  public void removeAll(int _value)
  {
    boolean isRemoved = remove(_value);
    while (isRemoved) {
      isRemoved = remove(_value);
    }
  }

  public void clear()
  {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  public int count()
  {
    return this.size;
  }

  public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
  {
    if (_nodeToInsert == null ||_nodeAfter == _nodeToInsert) return;
    if (_nodeAfter != null && !contains(_nodeAfter)) return;

    if (this.head == null) {
      this.head = _nodeToInsert;
      this.tail = _nodeToInsert;
      this.head.prev = null;
      this.head.next = null;
    } else {
      if (_nodeAfter == null) {
        _nodeToInsert.next = this.head;
        this.head.prev = _nodeToInsert;
        _nodeToInsert.prev = null;
        this.head = _nodeToInsert;
      } else {
        _nodeToInsert.next = _nodeAfter.next;
        _nodeToInsert.prev = _nodeAfter;
        _nodeAfter.next.prev = _nodeToInsert;
        _nodeAfter.next = _nodeToInsert;
        if (_nodeAfter == this.tail) {
          this.tail = _nodeToInsert;
        }
      }
    }
    size++;
  }


}

class Node
{
  public int value;
  public Node next;
  public Node prev;

  public Node(int _value)
  {
    value = _value;
    next = null;
    prev = null;
  }
}