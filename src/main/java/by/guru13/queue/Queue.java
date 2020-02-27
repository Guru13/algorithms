package by.guru13.queue;

import java.util.*;

public class Queue<T>
{
    public ArrayList<T> arrayList;
    public Queue()
    {
        arrayList = new ArrayList<T>();
    }

    public void enqueue(T item)
    {
        // вставка в хвост
        ArrayList<T> newArray = new ArrayList<T>();
        newArray.add(0, item);
        newArray.addAll(1, arrayList);
        arrayList = newArray;
    }

    public T dequeue()
    {
        // выдача из головы
        if(arrayList.size() == 0) {
            return null;
        } else {
            return arrayList.remove(arrayList.size() - 1);
        }
    }

    public int size()
    {
        return arrayList.size();
    }

}