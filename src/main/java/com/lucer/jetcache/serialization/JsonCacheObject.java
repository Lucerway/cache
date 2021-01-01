package com.lucer.jetcache.serialization;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: liuchuan
 */
@Data
public class JsonCacheObject<V> implements Serializable {

    private String className;
    private V realObj;


    public JsonCacheObject(String className, V realObj) {
        this.className = className;
        this.realObj = realObj;
    }


}

