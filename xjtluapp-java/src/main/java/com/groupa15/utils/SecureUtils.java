package com.groupa15.utils;

import lombok.Data;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Zirui Zhou
 * @date 2022/3/20
 */

@Data
@Component
@ConfigurationProperties(prefix = "secure")
public class SecureUtils {
    int saltLength = 32;
    int hashIterations = 1024;

    public String getSalt() {
        return new SecureRandomNumberGenerator().nextBytes(saltLength).toHex();
    }

    public String getHashedPassword(String password, String salt) {
        return new Md5Hash(password, salt, hashIterations).toHex();
    }

}
