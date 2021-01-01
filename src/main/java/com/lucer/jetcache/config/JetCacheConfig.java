package com.lucer.jetcache.config;

import com.alicp.jetcache.anno.support.SpringConfigProvider;
import com.lucer.jetcache.serialization.JsonSerialPolicy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class JetCacheConfig {


    @Bean
    public SpringConfigProvider springConfigProvider() {
        return new SpringConfigProvider() {
            @Override
            public Function<Object, byte[]> parseValueEncoder(String valueEncoder) {
                if (valueEncoder.equals("my_encode")) {
                    return new JsonSerialPolicy().encoder();
                } else {
                    return super.parseValueEncoder(valueEncoder);
                }
            }


            @Override
            public Function<byte[], Object> parseValueDecoder(String valueDecoder) {
                if (valueDecoder.equals("my_decode")) {
                    return new JsonSerialPolicy().decoder();
                } else {
                    return super.parseValueDecoder(valueDecoder);
                }
            }
        };
    }
}