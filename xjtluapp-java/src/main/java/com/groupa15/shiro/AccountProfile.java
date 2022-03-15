package com.groupa15.shiro;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Zirui Zhou
 * @date 2022/3/15
 */

@Data
public class AccountProfile implements Serializable {

    private Integer id;
    private String username;
    private String avatar;
    private String email;

}
