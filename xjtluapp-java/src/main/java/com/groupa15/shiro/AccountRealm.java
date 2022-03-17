package com.groupa15.shiro;

import com.groupa15.entity.User;
import com.groupa15.service.UserService;
import com.groupa15.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;

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

//        String userId = jwtUtils.getClaimByToken((String) jwtToken.getPrincipal()).getSubject();
        Claims claim = jwtUtils.getClaimByToken(jwtToken.getToken());

        if(claim == null) {
            System.out.println("now throw authentication exception");
            throw new AuthenticationException("Authentication Exception Information");
        }

        System.out.println("now go no");

        if(jwtUtils.isTokenExpired(claim.getExpiration())) {
            throw new ExpiredCredentialsException();
        }

        int userId = Integer.parseInt(claim.getSubject());

        User user = userService.getUserByUserId(userId);


//        // TODO(Zirui): Decide an enum class to define the status of the account status.
//        if (user.getStatus() == -1) {
//            throw new LockedAccountException();
//        }


//        AccountProfile profile = new AccountProfile();
////        BeanUtils.copyProperties(user, profile);
//        profile.setUserId(user.getUserId())
//                .setUsername(user.getUsername());

        // This Info will be a param CredentialMatch(). The result keeps `true` which can be simply ignored.

        return new SimpleAuthenticationInfo(jwtToken.getPrincipal(), jwtToken.getCredentials(), this.getName());
    }
}
