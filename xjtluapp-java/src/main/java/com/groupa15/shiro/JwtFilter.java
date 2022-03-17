package com.groupa15.shiro;

import com.alibaba.fastjson.JSON;
import com.groupa15.common.lang.Response;
import com.groupa15.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.SneakyThrows;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.BearerToken;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Zirui Zhou
 * @date 2022/3/15
 */

@Component
public class JwtFilter extends BasicHttpAuthenticationFilter {

    @Autowired
    JwtUtils jwtUtils;

    /* TODO(Zirui): From source code, the `isAccessAllowed` simply checks the status `isauthenticated`, which means the
        subject should be login manually each time when receiving a request. This conclusion should be checked again. */

    @Override
    protected AuthenticationToken createToken(ServletRequest servletRequest, ServletResponse servletResponse) {
        AuthenticationToken result = null;

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String jwt = request.getHeader(jwtUtils.getHeader());
        if (StringUtils.hasLength(jwt)) {
            result = new JwtToken(jwt);
        }

        return result;
    }

    // TODO(Zirui): Implement a more reasonable method to throw exceptions.
    @SneakyThrows
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object mappedValue) {
        return executeLogin(servletRequest, servletResponse);
    }



//    @Override
//    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
//        return false;
//    }
//
//    @Override
//    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object mappedValue) {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        String jwt = request.getHeader(jwtUtils.getHeader());
//        if(!StringUtils.hasLength(jwt)) {
//            return true;
//        } else {
//
//            Claims claim = jwtUtils.getClaimByToken(jwt);
//            if(claim == null || jwtUtils.isTokenExpired(claim.getExpiration())) {
//                throw new ExpiredCredentialsException();
//            }
//
//
//            try {
//                return executeLogin(servletRequest, servletResponse);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//            return false;
//
//        }
//    }
//
//    @Override
//    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
//
//        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
//
//        Throwable throwable = e.getCause() == null ? e : e.getCause();
//        Response result = Response.fail(HttpStatus.BAD_REQUEST, throwable.getMessage(), null);
//        String json = JSON.toJSONString(result);
//
//        try {
//            httpServletResponse.getWriter().print(json);
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//        return false;
//    }
//
//    @Override
//    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
//
//        HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
//        HttpServletResponse httpServletResponse = WebUtils.toHttp(response);
//        httpServletResponse.setHeader("Access-Control-Allow-Origin", httpServletRequest.getHeader("Origin"));
//        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
//        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
//        // 跨域时会首先发送一个OPTIONS请求，这里我们给OPTIONS请求直接返回正常状态
//        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
//            httpServletResponse.setStatus(org.springframework.http.HttpStatus.OK.value());
//            return false;
//        }
//
//        return super.preHandle(request, response);
//    }
}
