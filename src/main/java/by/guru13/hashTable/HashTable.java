package by.guru13.hashTable;

public class HashTable {
    public int size;
    public int step;
    public String[] slots;

    public HashTable(int sz, int stp) {
        size = sz;
        step = stp;
        slots = new String[size];
        for (int i = 0; i < size; i++) slots[i] = null;
    }

    public int hashFun(String value) {
        // всегда возвращает корректный индекс слота
        int hashVal = 0;
        for (int i = 0; i < value.length(); i++) {
            int letter = value.charAt(i) - 96;
            hashVal = (hashVal * 27 + letter) % size;
        }

        return  Math.abs(hashVal);
    }

    public int seekSlot(String value) {
        // находит индекс пустого слота для значения, или -1
        int idx = hashFun(value);
        if (slots[idx] == null || slots[idx].equals(value)) return idx;
        int circleCount = slots.length;
        while (slots[idx] != null && circleCount != 0) {
            idx = idx + step;
            if (idx > slots.length - 1) {
                idx = slots.length - circleCount;
            }
            circleCount--;
        }
        if (slots[idx] == null) {
            return idx;
        } else {
            return -1;
        }
    }

    public int put(String value) {
        // записываем значение по хэш-функции
        int idxToPut = seekSlot(value);
        if (idxToPut == -1) return -1;
        slots[idxToPut] = value;
        return idxToPut;
        // возвращается индекс слота или -1
        // если из-за коллизий элемент не удаётся разместить
    }

    public int find(String value) {
        // находит индекс слота со значением, или -1
        int idx = hashFun(value);
        if (slots[idx] != null && slots[idx].equals(value)) return idx;
        int circleCount = slots.length;
        while ((slots[idx] != null && !slots[idx].equals(value)) && circleCount != 0) {
            idx = idx + step;
            if (idx > slots.length - 1) {
                idx = slots.length - circleCount;
            }
            circleCount--;
        }
        if (slots[idx] != null && slots[idx].equals(value)) {
            return idx;
        } else {
            return -1;
        }
    }
}