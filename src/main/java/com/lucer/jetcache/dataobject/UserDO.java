package com.lucer.jetcache.dataobject;

import lombok.Data;

import java.io.Serializable;
import java.util.Random;

/**
 * @author: liuchuan
 */
@Data
public class UserDO implements Serializable {

    private Long id;

    private String username;

    private String address;

    private String mobile;


    public UserDO(Long id) {
        this.id = id;
        this.username = "person" + new Random().nextInt(1000);
        this.address = "beijing" + new Random().nextInt(1000);
        this.mobile = String.valueOf(new Random(10000).nextInt());
    }

}
