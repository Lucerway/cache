package com.lucer.jetcache;

import com.alibaba.fastjson.JSONObject;
import com.lucer.jetcache.config.RedisConnectionConfig;
import com.lucer.jetcache.dataobject.UserDO;
import com.lucer.jetcache.service.BuilderService;
import com.lucer.jetcache.service.CreateCacheService;
import com.lucer.jetcache.service.MethodCache;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest(classes = JetcacheApplication.class)
class JetcacheApplicationTests {

    @Resource
    private CreateCacheService createCacheService;

    @Resource
    private MethodCache methodCache;

    @Resource
    private BuilderService builderService;

    @Resource
    private RedisConnectionConfig redisConnectionConfig;


    @Test
    public void test() {

        long userId = 13;

        UserDO userDO = createCacheService.computeIfAbsent(userId);
        System.out.println("缓存初始值：" + JSONObject.toJSONString(userDO));

        userDO.setAddress("武汉");
        userDO.setMobile("123456");
        methodCache.updateUser(userDO);

        userDO = methodCache.getUser(userId);
        System.out.println("缓存修改后值：" + JSONObject.toJSONString(userDO));
    }

    @Test
    public void methodCacheTest() {

        long userId = 13;
        // 第一次执行插入缓存
        UserDO userDO = methodCache.getUser(userId);
        System.out.println("最初缓存值：" + JSONObject.toJSONString(userDO));

        // 更新缓存
        userDO.setMobile("123456");
        userDO.setAddress("上海");
        methodCache.updateUser(userDO);

        // 再次查询
        userDO = methodCache.getUser(userId);
        System.out.println("更新后缓存值1：" + JSONObject.toJSONString(userDO));

        // 再次查询
        userDO = methodCache.getUser(userId);
        System.out.println("更新后缓存值2：" + JSONObject.toJSONString(userDO));

        // 删除缓存
        methodCache.deleteUser(userId);

        // 再次查询
        userDO = methodCache.getUser(userId);
        System.out.println("删除后缓存值：" + JSONObject.toJSONString(userDO));
    }

    @Test
    public void conditionTest() {
        methodCache.getUser(1);
        methodCache.getUser(2);
        methodCache.getUser(3);
        methodCache.getUser(4);
        methodCache.getUser(5);
        methodCache.getUser(6);
    }

    @Test
    public void redisBuilder() {
        builderService.put(123L);
        UserDO userDO = builderService.get(123L);
        System.out.println("缓存值：" + JSONObject.toJSONString(userDO));
    }

    @Test
    public void feature() {
        createCacheService.createUser(123L);
        createCacheService.feature(123L);
    }



}
