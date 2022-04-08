package com.groupa15.shiro;

import com.groupa15.entity.User;
import com.groupa15.service.UserService;
import com.groupa15.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Zirui Zhou
 * @date 2022/3/15
 */

@Component
public class AccountRealm extends AuthorizingRealm {

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserService userService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        JwtToken jwtToken = (JwtToken) token;
        Claims claim;

        try {
            claim = jwtUtils.getClaimByToken(jwtToken.getToken());
        } catch (JwtException e) {
            throw new AuthenticationException("Json web token is in wrong format.");
        } catch (IllegalArgumentException e) {
            throw new AuthenticationException("Must login first.");
        }

        if(jwtUtils.isTokenExpired(claim.getExpiration())) {
            throw new ExpiredCredentialsException("The login credential expired.");
        }

        Long userId = Long.parseLong(claim.getSubject());
        User user = userService.getUserByUserId(userId);

        /*
            TODO(Zirui): Decide an enum class to define the status of the account status.
         */

//        if (user.getStatus() == -1) {
//            throw new LockedAccountException();
//        }

        // This Info will be a param CredentialMatch(). The result keeps `true` which can be simply ignored.
        return new SimpleAuthenticationInfo(jwtToken.getPrincipal(), jwtToken.getCredentials(), this.getName());
    }
}
