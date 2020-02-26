package by.guru13.stack;
import java.util.*;

public class Stack<T>
{
    public ArrayList<T> arrayList;
    public Stack()
    {
       arrayList = new ArrayList<T>();
    }

    public int size()
    {
        return arrayList.size();
    }

    public T pop()
    {
        if(arrayList.size() == 0) {
            return null;
        } else {
            return arrayList.remove(arrayList.size() - 1);
        }
    }

    public void push(T val)
    {
        arrayList.add(val);
    }

    public T peek()
    {
        if(arrayList.size() == 0) {
            return null;
        } else {
            return arrayList.get(arrayList.size()-1);
        }
    }
}