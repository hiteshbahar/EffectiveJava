package cacheImplementation.lfu;

import org.junit.jupiter.api.Test;

class LFUCacheTest {

    @Test
    void successTest() {
        LFUCache lfuCache = new LFUCache(100);

        lfuCache.put(1, "Tesla");
        lfuCache.put(2, "Mercedes");
        lfuCache.put(3, "BMW");
        lfuCache.put(4, "Toyota");
        lfuCache.put(5, "Honda");
        lfuCache.put(6, "Hyundai");
        lfuCache.put(7, "Subaru");
        lfuCache.put(8, "Kia");
        lfuCache.put(9, "Acura");
        lfuCache.put(10, "Lexus");
        lfuCache.put(11, "Tesla");
        lfuCache.put(12, "Mercedes");
        lfuCache.put(13, "Tesla");


        System.out.println(lfuCache.get(1));


    }
}