package by.guru13.nativeDictionary;

import java.lang.reflect.Array;

class NativeDictionary<T>
{
    public int size;
    public String [] slots;
    public T [] values;

    public NativeDictionary(int sz, Class clazz)
    {
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
    }

    public int hashFun(String key)
    {
        // всегда возвращает корректный индекс слота
        int hashVal = 0;
        for (int i = 0; i < key.length(); i++) {
            int letter = key.charAt(i) - 96;
            hashVal = (hashVal * 27 + letter) % size;
        }
        return  Math.abs(hashVal);
    }

    public boolean isKey(String key)
    {
        // возвращает true если ключ имеется,
        // иначе false
        return find(key) > -1;
    }

    public void put(String key, T value)
    {
        // гарантированно записываем
        // значение value по ключу key
        int idxToPut = find(key);
        if (idxToPut == -1) idxToPut = seekSlot(key);
        if (idxToPut != -1) {
            slots[idxToPut] = key;
            values[idxToPut] = value;
        }
    }

    public T get(String key)
    {
        // возвращает value для key,
        // или null если ключ не найден
        if (isKey(key)) {
            return values[find(key)];
        }
        return null;
    }

    public int find(String key) {
        // находит индекс слота со значением, или -1
        int idx = hashFun(key);
        if (slots[idx] != null && slots[idx].equals(key)) return idx;
        int circleCount = slots.length;
        while ((slots[idx] != null && !slots[idx].equals(key)) && circleCount != 0) {
            idx = idx + 3;
            if (idx > slots.length - 1) {
                idx = slots.length - circleCount;
                circleCount--;
            }

        }
        if (slots[idx] != null && slots[idx].equals(key)) {
            return idx;
        } else {
            return -1;
        }
    }

    public int seekSlot(String key) {
        // находит индекс пустого слота для значения, или -1
        int idx = hashFun(key);
        if (slots[idx] == null || slots[idx].equals(key)) return idx;
        int circleCount = slots.length;
        while (slots[idx] != null && circleCount != 0) {
            idx = idx + 3;
            if (idx > slots.length - 1) {
                idx = slots.length - circleCount;
                circleCount--;
            }

        }
        if (slots[idx] == null) {
            return idx;
        } else {
            return -1;
        }
    }
}
