package by.guru13.orderedList;

import java.math.BigDecimal;
import java.util.*;


class Node<T> {
    public T value;
    public Node<T> next, prev;

    public Node(T _value) {
        value = _value;
        next = null;
        prev = null;
    }
}

public class OrderedList<T> {
    public Node<T> head, tail;
    private boolean _ascending;
    private int size;

    public OrderedList(boolean asc) {
        head = null;
        tail = null;
        _ascending = asc;
        size = 0;
    }

    public int compare(T v1, T v2) {
        // -1 если v1 < v2
        // 0 если v1 == v2
        // +1 если v1 > v2
        if (v1 instanceof Number) {
            return compareNumbers((Number) v1, (Number) v2);
        } else if (v1 instanceof String) {
            return ((String) v1).trim().compareTo(((String) v2).trim());
        }
        return 0;
    }

    public int compareNumbers(Number n1, Number n2) {
        BigDecimal n2c = new BigDecimal(n2.toString());
        BigDecimal n1c = new BigDecimal(n1.toString());
        return n1c.compareTo(n2c);
    }

    public void add(T value) {
        // автоматическая вставка value
        // в нужную позицию
        if (this.head == null) {
            this.head = new Node<T>(value);
            this.tail = this.head;
            size++;
            return;
        }

        if (this._ascending) {
            if (compare(value, this.head.value) <= 0) {
                insertAfter(null, new Node<T>(value));
            } else if (compare(value, this.tail.value) >= 0) {
                addInTail(new Node<T>(value));
            } else {
                insertAfter(findInsertAfter(value), new Node<T>(value));
            }
        } else {
            if (compare(value, this.head.value) >= 0) {
                insertAfter(null, new Node<T>(value));
            } else if (compare(value, this.tail.value) <= 0) {
                addInTail(new Node<T>(value));
            } else {
                insertAfter(findInsertAfter(value), new Node<T>(value));
            }
        }
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

    public Node<T> findInsertAfter(T val) {
        Node<T> node = this.head;
        while (node != null) {
            if (this._ascending) {
                if ((compare(node.value, val) <= 0) && compare(node.next.value, val) >= 0) {
                    return node;
                }
            } else {
                if ((compare(node.value, val) >= 0) && compare(node.next.value, val) <= 0) {
                    return node;
                }
            }
            node = node.next;
        }
        return null;
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


                if (_nodeAfter == this.tail) {
                    this.tail = _nodeToInsert;
                } else {
                    _nodeAfter.next.prev = _nodeToInsert;
                }
                _nodeAfter.next = _nodeToInsert;
            }
        }
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

    public Node<T> find(T val) {
        Node<T> node = this.head;
        while (node != null) {
            if (compare(node.value, val) == 0) {
                return node;
            }
            if (this._ascending) {
                if (compare(node.value, val) == 1) {
                    return null;
                }
            } else {
                if (compare(node.value, val) == -1) {
                    return null;
                }
            }
            node = node.next;
        }
        return null; // здесь будет ваш код
    }

    public void delete(T val) {
        // здесь будет ваш код
        Node<T> currentNode = this.head;
        Node<T> prevNode = null;
        while (currentNode != null) {
            if (compare(currentNode.value, val) == 0) {
                if (prevNode != null) {
                    prevNode.next = currentNode.next;
                    if (currentNode.next == null) {
                        this.tail = prevNode;
                    } else {
                        currentNode.next.prev = prevNode;
                    }
                    size--;
                    return;
                } else {
                    if (size != 0) {
                        this.head = this.head.next;
                        size--;
                        if (size == 0) {
                            this.tail = null;
                        } else {
                            this.head.prev = null;
                        }
                        return;
                    }
                }
            }
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
    }

    public void clear(boolean asc) {
        _ascending = asc;
        // здесь будет ваш код
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int count() {
        return size; // здесь будет ваш код подсчёта количества элементов в списке
    }

    ArrayList<Node<T>> getAll() // выдать все элементы упорядоченного
    // списка в виде стандартного списка
    {
        ArrayList<Node<T>> r = new ArrayList<Node<T>>();
        Node<T> node = head;
        while (node != null) {
            r.add(node);
            node = node.next;
        }
        return r;
    }
}
