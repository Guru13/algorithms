package by.guru13.bloomFilter;

public class BloomFilter {
    public int filter_len;
    public int[] blumArray;

    public BloomFilter(int f_len) {
        filter_len = f_len;
        blumArray = new int[f_len];
        for (int i = 0; i < f_len; i++) {
            blumArray[i] = 0;
        }
        // создаём битовый массив длиной f_len ...
    }

    // хэш-функции
    public int hash1(String str1) {
        // 17
        int hashVal = 0;
        for (int i = 0; i < str1.length(); i++) {
            int code = (int) str1.charAt(i);
            hashVal = (hashVal * 17 + code) % filter_len;
        }
        return hashVal;
    }

    public int hash2(String str1) {
        // 223
        int hashVal = 0;
        for (int i = 0; i < str1.length(); i++) {
            int code = (int) str1.charAt(i);
            hashVal = (hashVal * 223 + code) % filter_len;
        }
        return hashVal;
    }

    public void add(String str1) {
        blumArray[hash1(str1)] = 1;
        blumArray[hash2(str1)] = 1;
        // добавляем строку str1 в фильтр
    }

    public boolean isValue(String str1) {
        // проверка, имеется ли строка str1 в фильтре
        return blumArray[hash1(str1)] == 1 && blumArray[hash2(str1)] == 1;
    }
}