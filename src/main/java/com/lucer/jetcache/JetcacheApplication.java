package com.lucer.jetcache;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@EnableMethodCache(basePackages = "com.lucer.jetcache")
@EnableCreateCacheAnnotation
@SpringBootApplication
public class JetcacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(JetcacheApplication.class, args);
        log.info(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss|SSS").format(new Date()) + " xxq-draw-service started!");
    }

}
