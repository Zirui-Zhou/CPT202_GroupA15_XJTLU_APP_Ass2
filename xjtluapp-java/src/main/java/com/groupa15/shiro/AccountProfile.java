package com.groupa15.shiro;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author Zirui Zhou
 * @date 2022/3/15
 */

@Data
@Accessors(chain = true)
public class AccountProfile implements Serializable {

    private Integer userId;
    private String username;
//    private String avatar;
//    private String email;

}
