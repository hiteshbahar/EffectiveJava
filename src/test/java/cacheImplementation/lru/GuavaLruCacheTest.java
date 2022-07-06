package cacheImplementation.lru;

import cacheImplementation.dao.Names;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GuavaLruCacheTest {

    @Test
    void SuccessTest() {

        GuavaLruCache cachDemo = new GuavaLruCache();
        cachDemo.init();
        cachDemo.loadCache();
        Names name = cachDemo.getCacheKeyLoadCache("Jeff Bezos");
        assertEquals("Jeff Bezos", name.getId());
        name = cachDemo.getIfPresentLoadCache("002");
        assertEquals(null, name);
        name = cachDemo.getCacheKeyLoadCache("002");
        assertEquals("Jeff Bezos", name.getName());
        name = cachDemo.getCacheKeyLoadCache("002");
        assertEquals("Jeff Bezos", name.getName());
        name = cachDemo.getCacheKeyLoadCache("001");
        assertEquals("Elon Musk", name.getName());
        name = cachDemo.getIfPresentLoadCache("001");
        assertEquals("Elon Musk", name.getName());
    }

}