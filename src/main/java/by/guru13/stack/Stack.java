package by.guru13.stack;
import java.util.*;

public class Stack<T>
{
    public ArrayList<T> arrayList;
    public Stack()
    {
        // инициализация внутреннего хранилища стека
       arrayList = new ArrayList<T>();
    }

    public int size()
    {
        // размер текущего стека
        return arrayList.size();
    }

    public T pop()
    {
        // ваш код
//        T popValue = arrayList.get(arrayList.size()-1);
//        arrayList.remove(arrayList.size()-1);
        if(arrayList.size() == 0) {
            return null;
        } else {
            return arrayList.remove(arrayList.size() - 1);
        }
    }

    public void push(T val)
    {
        // ваш код
        arrayList.add(val);
    }

    public T peek()
    {
        // ваш код
        if(arrayList.size() == 0) {
            return null;
        } else {
            return arrayList.get(arrayList.size()-1);
        }
         // если стек пустой
    }
}