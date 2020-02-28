package by.guru13.deque;

import java.util.*;

public class Deque<T>
{
    public ArrayList<T> arrayList;
    public Deque()
    {
        arrayList = new ArrayList<T>();
    }

    public void addFront(T item)
    {
        // добавление в голову
        arrayList.add(item);
    }

    public void addTail(T item)
    {
        // добавление в хвост
        ArrayList<T> newArray = new ArrayList<T>();
        newArray.add(0, item);
        newArray.addAll(1, arrayList);
        arrayList = newArray;
    }

    public T removeFront()
    {
        // удаление из головы
        if(arrayList.size() == 0) {
            return null;
        } else {
            return arrayList.remove(arrayList.size() - 1);
        }
    }

    public T removeTail()
    {
        // удаление из хвоста
        if(arrayList.size() == 0) {
            return null;
        } else {
            return arrayList.remove(0);
        }
    }

    public int size()
    {
        return arrayList.size(); // размер очереди
    }
}
