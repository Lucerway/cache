package com.lucer.jetcache.service;

import com.alicp.jetcache.anno.CacheInvalidate;
import com.alicp.jetcache.anno.CacheRefresh;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CacheUpdate;
import com.alicp.jetcache.anno.Cached;
import com.lucer.jetcache.dataobject.UserDO;

/**
 * @author: liuchuan
 */

public interface MethodCache {

    /**
     * @Cached
     * 重要属性             默认值      说明
     * cacheNullValue     false       当方法返回值为null的时候是否要缓存
     * condition          未定义       使用SpEL指定条件，如果表达式返回true的时候才进行缓存 (#id%2==1)
     */
    /**
     * @CacheRefresh 自动刷新
     * refresh                      未定义               刷新间隔
     * timeUnit                     未定义               时间单位
     * stopRefreshAfterLastAccess   TimeUnit.SECONDS    指定该key多长时间没有访问就停止刷新，如果不指定会一直刷新
     * refreshLockTimeout           60秒                类型为BOTH/REMOTE的缓存刷新时，同时只会有一台服务器在刷新，这台服务器会在远程缓存放置一个分布式锁，此配置指定该锁的超时时间
     */
    @Cached(name = "user_cache.", key = "#id", expire = 10, cacheType = CacheType.BOTH, condition = "#id%2==1")
    @CacheRefresh(refresh = 3)
    UserDO getUser(long id);

    @CacheUpdate(name = "user_cache.", key = "#user.id", value = "#user")
    void updateUser(UserDO user);

    @CacheInvalidate(name = "user_cache.", key = "#id")
    void deleteUser(long id);


}
