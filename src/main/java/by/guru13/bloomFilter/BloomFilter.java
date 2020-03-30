package by.guru13.bloomFilter;

public class BloomFilter {
    public int filter_len;
    public int bitMask;

    public BloomFilter(int f_len) {
        filter_len = f_len;
        bitMask = 0;
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
        bitMask = bitMask | (1<<hash1(str1));
        bitMask = bitMask | (1<<hash2(str1));
        // добавляем строку str1 в фильтр
    }

    public boolean isValue(String str1) {
        // проверка, имеется ли строка str1 в фильтре
        int val1 = 1<<hash1(str1);
        int val2 = 1<<hash2(str1);
        return (bitMask & (val1)) == (val1) && (bitMask & (val2)) == (val2) ;
    }
}