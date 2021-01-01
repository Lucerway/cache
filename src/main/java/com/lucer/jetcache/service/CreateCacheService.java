package com.lucer.jetcache.service;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.CacheGetResult;
import com.alicp.jetcache.ResultData;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.lucer.jetcache.dataobject.UserDO;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;

/**
 * @author: liuchuan
 */
@Component
public class CreateCacheService {


    /**
     * @CreateCache 介绍
     * 属性	       默认值	             说明
     * area	        “default”	         如果需要连接多个缓存系统，可在配置多个cache area，这个属性指定要使用的那个area的name
     * name	        未定义	             指定缓存的名称，不是必须的，如果没有指定，会使用类名+方法名。name会被用于远程缓存的key前缀。另外在统计中，一个简短有意义的名字会提高可读性。如果两个@CreateCache的name和area相同，它们会指向同一个Cache实例
     * expire	    未定义	             该Cache实例的默认超时时间定义，注解上没有定义的时候会使用全局配置，如果此时全局配置也没有定义，则取无穷大
     * timeUnit     TimeUnit.SECONDS	 指定expire的单位
     * cacheType	CacheType.REMOTE	 缓存的类型，包括CacheType.REMOTE、CacheType.LOCAL、CacheType.BOTH。如果定义为BOTH，会使用LOCAL和REMOTE组合成两级缓存
     * localLimit	未定义	             如果cacheType为CacheType.LOCAL或CacheType.BOTH，这个参数指定本地缓存的最大元素数量，以控制内存占用。注解上没有定义的时候会使用全局配置，如果此时全局配置也没有定义，则取100
     * serialPolicy	未定义	             如果cacheType为CacheType.REMOTE或CacheType.BOTH，指定远程缓存的序列化方式。JetCache内置的可选值为SerialPolicy.JAVA和SerialPolicy.KRYO。注解上没有定义的时候会使用全局配置，如果此时全局配置也没有定义，则取SerialPolicy.JAVA
     * keyConvertor	未定义	             指定KEY的转换方式，用于将复杂的KEY类型转换为缓存实现可以接受的类型，JetCache内置的可选值为KeyConvertor.FASTJSON和KeyConvertor.NONE。NONE表示不转换，FASTJSON通过fastjson将复杂对象KEY转换成String。如果注解上没有定义，则使用全局配置。
     */
    @CreateCache(name = "user_cache.", expire = 60, cacheType = CacheType.BOTH, localLimit = 50)
    private Cache<Long, UserDO> userCache;


    public UserDO createUser(Long id) {
        UserDO userDO = new UserDO(id);
        userCache.put(id, userDO);
        userCache.GET(id);
        return userDO;
    }

    public UserDO getUser(Long id) {
        return userCache.get(id);
    }

    /**
     * 自有特性，computeIfAbsent3个方法
     *
     * @param id
     * @return
     */
    public UserDO computeIfAbsent(Long id) {
        return userCache.computeIfAbsent(id, k -> createUser(id));
    }


    public UserDO createForExpire(Long id) {
        UserDO userDO = new UserDO(id);
        userCache.put(id, userDO, 10, TimeUnit.SECONDS);
        return userDO;
    }

    /**
     * 分布式锁
     */
    public void lock(Long id) {
        userCache.tryLockAndRun(id, 60, TimeUnit.SECONDS, () -> {
            // do business
        });
    }

    /**
     * 异步特性，jedis客户端不支持；需要使用lettuce客户端
     *
     * @param id
     */
    public void feature(Long id) {
        CacheGetResult<UserDO> r = userCache.GET(id);
        CompletionStage<ResultData> future = r.future();
        future.thenRun(() -> {
            if (r.isSuccess()) {
                System.out.println("value:" + r.getValue());
            }
        });
        System.out.println("success");
    }


}
