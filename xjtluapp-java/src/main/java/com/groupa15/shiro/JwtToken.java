package com.groupa15.shiro;

import org.apache.shiro.authc.BearerToken;

/**
 * @author Zirui Zhou
 * @date 2022/3/15
 */

public class JwtToken extends BearerToken {

    public JwtToken(String token) {
        super(token);
    }

}
