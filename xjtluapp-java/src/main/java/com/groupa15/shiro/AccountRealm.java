package com.groupa15.shiro;

import com.groupa15.entity.User;
import com.groupa15.service.UserService;
import com.groupa15.utils.JwtUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
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
        return token instanceof BearerToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        BearerToken jwtToken = (BearerToken) token;

        String userId = jwtUtils.getClaimByToken((String) jwtToken.getPrincipal()).getSubject();


        User user = userService.getUserByUserId(Integer.parseInt(userId));

//        if (user == null) {
//            throw new UnknownAccountException();
//        }
//        // TODO(Zirui): Decide an enum class to define the status of the account status.
//        if (user.getStatus() == -1) {
//            throw new LockedAccountException();
//        }

        AccountProfile profile = new AccountProfile();
//        BeanUtils.copyProperties(user, profile);
        profile.setUserId(user.getUserId())
                .setUsername(user.getUsername());

        return new SimpleAuthenticationInfo(profile, jwtToken.getCredentials(), this.getName());
    }
}
