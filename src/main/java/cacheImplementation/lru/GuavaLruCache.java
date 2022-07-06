package cacheImplementation.lru;

import cacheImplementation.dao.Names;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class GuavaLruCache {
    private LoadingCache<String,Names> loadingCache;
    private RemovalListener<String, Names> removalListener;

    private static Logger logger = LoggerFactory.getLogger(GuavaLruCache.class);

    public void init(){
        //Remove key value listener
        removalListener = new RemovalListener<String, Names>(){
            public void onRemoval(RemovalNotification<String, Names> notification) {
               logger.info("RemovalListener");
                logger.info ( notification.getKey () + "removed");
                //You can get the key, value, and deletion reason in the listener
                notification.getValue();
                notification.getCause();//EXPLICIT, REPLACED, COLLECTED, EXPIRED, SIZE

            }};
    }

    public void loadCache() {
        //Specifies a method to get data if the data does not exist
        CacheLoader<String, Names> cacheLoader = getCacheLoader();

        //The number of buffers is 1 to show the effect of cache deletion
        loadingCache = CacheBuilder.newBuilder()
                .maximumSize(100)
                //Data will be removed if the data is not retrieved for 5 seconds
                .expireAfterAccess(5, TimeUnit.SECONDS)
                //If the data is not updated for 5 seconds, the data will be removed
                .expireAfterWrite(5, TimeUnit.SECONDS)
                //Refresh data every 1 second
                .refreshAfterWrite(1,TimeUnit.SECONDS)
                .removalListener(removalListener)
                .build(cacheLoader);
    }

    //Get data, if not, return null
    public Names getIfPresentLoadCache(String key){
        return loadingCache.getIfPresent(key);
    }

    //Get the data. If the data does not exist, get the data through the cacheLoader, cache and return
    public Names getCacheKeyLoadCache(String key){
        try {
            return loadingCache.get(key);
        } catch (ExecutionException e) {
            logger.error(e.getMessage());
        }
        return null;
    }

    //Put data directly to cache
    public void putLoadCache(String key,Names value){
        logger.info("LoadingCache");
        logger.info("put key :{} value : {}",key,value.getName());
        loadingCache.put(key,value);
    }

    private CacheLoader<String, Names> getCacheLoader() {
        return new CacheLoader<String, Names>() {
            @Override
            public Names load(String key) throws Exception {
                Names tmpNames = new Names();
                tmpNames.setId(key);
                tmpNames.setName("others");
                if (key.equals("001")) {
                    tmpNames.setName("Elon Musk");
                    return tmpNames;
                }
                if (key.equals("002")) {
                    tmpNames.setName("Jeff Bezos");
                    return tmpNames;
                }
                return tmpNames;
            }
        };
    }
}
