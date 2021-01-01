package com.lucer.jetcache.controller;

import com.lucer.jetcache.service.CreateCacheService;
import com.lucer.jetcache.dataobject.UserDO;
import com.lucer.jetcache.response.Response;
import com.lucer.jetcache.service.MethodCache;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: liuchuan
 */

@RestController
@RequestMapping("/jetcache")
public class Controller {

    @Resource
    private CreateCacheService createCacheService;

    @Resource
    private MethodCache methodCache;


    /**
     * 创建用户
     */
    @GetMapping("/user/init/{id}")
    public Response<UserDO> createUser(@PathVariable("id") Long id) {
        UserDO user = createCacheService.createUser(id);
        return Response.success(user);
    }

    /**
     * 查询用户
     */
    @GetMapping("/user/get/{id}")
    public Response<UserDO> getUser(@PathVariable("id") Long id) {
        UserDO user = createCacheService.getUser(id);
        return Response.success(user);
    }


    /**
     * 查询缓存如果没有的话，就再次生成
     */
    @GetMapping("/user/compute/{id}")
    public Response<UserDO> computeIfAbsent(@PathVariable("id") Long id) {
        UserDO user = createCacheService.computeIfAbsent(id);
        return Response.success(user);
    }

    /**
     * 方法缓存创建用户
     */
    @GetMapping("/user/method/init/{id}")
    public Response<UserDO> methodGetUser(@PathVariable("id") Long id) {
        UserDO user = methodCache.getUser(id);
        return Response.success(user);
    }

}
