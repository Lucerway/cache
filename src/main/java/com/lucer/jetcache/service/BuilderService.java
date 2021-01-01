package com.lucer.jetcache.service;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.MultiLevelCacheBuilder;
import com.alicp.jetcache.RefreshPolicy;
import com.alicp.jetcache.embedded.LinkedHashMapCacheBuilder;
import com.alicp.jetcache.redis.RedisCacheBuilder;
import com.alicp.jetcache.support.FastjsonKeyConvertor;
import com.alicp.jetcache.support.JavaValueDecoder;
import com.alicp.jetcache.support.JavaValueEncoder;
import com.lucer.jetcache.config.RedisConnectionConfig;
import com.lucer.jetcache.dataobject.UserDO;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author: liuchuan
 */
@Component
public class BuilderService {

    @Resource
    private RedisConnectionConfig redisConnectionConfig;


    /**
     * 本地缓存构造
     */
    Cache<Long, UserDO> localCache = LinkedHashMapCacheBuilder.createLinkedHashMapCacheBuilder()
            .limit(100)
            // 自动刷新缓存
            .loader(this::autoRefresh)
            // 刷新策略
            .refreshPolicy(RefreshPolicy.newPolicy(1, TimeUnit.MINUTES).stopRefreshAfterLastAccess(30, TimeUnit.MINUTES))
            .expireAfterWrite(100, TimeUnit.SECONDS)
            .buildCache();

    private UserDO autoRefresh(Long id) {
        return new UserDO(id);
    }


    Cache<Long, UserDO> remoteCache;

    @PostConstruct
    public void init() {
        remoteCache = RedisCacheBuilder.createRedisCacheBuilder()
                .keyConvertor(FastjsonKeyConvertor.INSTANCE)
                .jedisPool(redisConnectionConfig.pool())
                .keyPrefix("user_cache.")
                .keyConvertor(FastjsonKeyConvertor.INSTANCE)
                .valueEncoder(JavaValueEncoder.INSTANCE)
                .valueDecoder(JavaValueDecoder.INSTANCE)
                .expireAfterWrite(100, TimeUnit.SECONDS)
                .buildCache();
    }


    public void put(Long id) {
        remoteCache.put(id, new UserDO(id));
    }

    public UserDO get(Long id) {
        return remoteCache.get(id);
    }


//    /**
//     * 多级缓存
//     */
//    Cache<Long, UserDO> multiLevelCache = MultiLevelCacheBuilder.createMultiLevelCacheBuilder()
//            .addCache(localCache, remoteCache)
//            .expireAfterWrite(100, TimeUnit.SECONDS)
//            .buildCache();

}
