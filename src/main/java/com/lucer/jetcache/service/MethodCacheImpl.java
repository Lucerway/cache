package com.lucer.jetcache.service;

import com.lucer.jetcache.dataobject.UserDO;
import org.springframework.stereotype.Component;

/**
 * @author: liuchuan
 */
@Component
public class MethodCacheImpl implements MethodCache {

    @Override
    public UserDO getUser(long id) {
        return new UserDO(id);
    }

    @Override
    public void updateUser(UserDO user) {
        // do nothing
    }

    @Override
    public void deleteUser(long id) {
        // do nothing
    }

}
