package com.lucer.jetcache.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author: liuchuan
 */
@Data
@Configuration
public class RedisConnectionConfig {

    @Value("${jetcache.remote.default.poolConfig.minIdle}")
    public int minIdle;

    @Value("${jetcache.remote.default.poolConfig.maxIdle}")
    public int maxIdle;

    @Value("${jetcache.remote.default.poolConfig.maxTotal}")
    public int maxTotal;

    @Value("${jetcache.remote.default.host}")
    public String host;

    @Value("${jetcache.remote.default.port}")
    public int port;

    @Value("${jetcache.remote.default.password}")
    public String password;

    @Value("${jetcache.remote.default.database}")
    public int database;

    public int timeout = 60;


    public JedisPool pool() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMinIdle(minIdle);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxTotal(maxTotal);
        return new JedisPool(jedisPoolConfig, host, port, timeout, password, database);
    }

}
