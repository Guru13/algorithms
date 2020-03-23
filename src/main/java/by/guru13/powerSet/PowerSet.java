package by.guru13.powerSet;



public class PowerSet {
    public int size;
    public int step;
    public String[] slots;

    public PowerSet() {
        // ваша реализация хранилища
        step = 3;
        size = 0;
        slots = new String[20000];
    }

    public int size() {
        // количество элементов в множестве
        return size;
    }


    public void put(String value) {
        // всегда срабатывает
        int idxToPut = seekSlot(value);
        if (idxToPut == -1 || get(value)) return;
        slots[idxToPut] = value;
        size++;
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
                circleCount--;
            }
        }
        if (slots[idx] == null) {
            return idx;
        } else {
            return -1;
        }
    }

    public int hashFun(String value) {
        // всегда возвращает корректный индекс слота
        int hashVal = 0;
        for (int i = 0; i < value.length(); i++) {
            int letter = value.charAt(i) - 96;
            hashVal = (hashVal * 27 + letter) % slots.length;
        }

        return  Math.abs(hashVal);
    }

    public boolean get(String value) {
        // возвращает true если value имеется в множестве,
        // иначе false
        int idx = hashFun(value);
        if (slots[idx] != null && slots[idx].equals(value)) return true;
        int circleCount = slots.length;
        while ((slots[idx] != null && !slots[idx].equals(value)) && circleCount != 0) {
            idx = idx + step;
            if (idx > slots.length - 1) {
                idx = slots.length - circleCount;
                circleCount--;
            }
        }
        return slots[idx] != null && slots[idx].equals(value);
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
                circleCount--;
            }

        }
        if (slots[idx] != null && slots[idx].equals(value)) {
            return idx;
        } else {
            return -1;
        }
    }

    public boolean remove(String value) {
        // возвращает true если value удалено
        // иначе false
        if (value == null) return false;
//        int idx = find(value);
//        if(idx != -1) {
//            slots[idx] = null;
//            size--;
//            return true;
//        } else {
//            return false;
//        }
        for (int i = 0; i < slots.length; i++) {
            if (value.equals(slots[i])) {
                slots[i] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    public PowerSet intersection(PowerSet set2) {
        // пересечение текущего множества и set2
        PowerSet intersectionSet = new PowerSet();
        PowerSet compareSet = this;
        PowerSet runSet = set2;
        if (set2.slots.length > this.slots.length) {
            runSet = this;
            compareSet = set2;
        }
        for (String str : runSet.slots) {
            if (str != null && compareSet.get(str)) {
                intersectionSet.put(str);
            }
        }
        return intersectionSet;
    }

    public PowerSet union(PowerSet set2) {
        // объединение текущего множества и set2
        PowerSet unionSet = new PowerSet();
        unionSet.slots = new String[set2.slots.length + this.slots.length];
        for (String str : set2.slots) {
            if (str != null) {
                unionSet.put(str);
            }
        }
        for (String str : this.slots) {
            if (str != null) {
                unionSet.put(str);
            }
        }
        return unionSet;
    }

    public PowerSet difference(PowerSet set2) {
        // разница текущего множества и set2
        PowerSet differenceSet = new PowerSet();
        for (String str : this.slots) {
            if (str != null && !set2.get(str)) {
                differenceSet.put(str);
            }
        }
        return differenceSet;
    }

    public boolean isSubset(PowerSet set2) {
        // возвращает true, если set2 есть
        // подмножество текущего множества,
        // иначе false
        for (String str : set2.slots) {
            if (str != null && !this.get(str)) {
                return false;
            }
        }
        return true;
    }
}
