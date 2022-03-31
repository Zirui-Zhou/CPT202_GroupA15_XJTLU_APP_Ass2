package com.groupa15.shiro;

import com.alibaba.fastjson.JSONObject;
import com.groupa15.common.lang.Response;
import com.groupa15.utils.JwtUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
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

    /*
        TODO(Zirui): From source code, the `isAccessAllowed` simply checks the status `isauthenticated`, which means the
         subject should be login manually each time when receiving a request. This conclusion should be checked again.
     */

    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
        String jwt = ((HttpServletRequest) request).getHeader(jwtUtils.getHeader());
        return new JwtToken(jwt);
    }

    /*
        TODO(Zirui): Implement a more reasonable method to throw exceptions.
     */

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        return executeLogin(request, response);
    }

    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        try {
            response.getWriter().print(JSONObject.toJSONString(Response.fail(HttpStatus.BAD_REQUEST, e.getMessage())));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return false;
    }


    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {

        HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
        HttpServletResponse httpServletResponse = WebUtils.toHttp(response);
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, Content-Length, Authorization, Accept, X-Requested-With , yourHeaderFeild");
        // 跨域时会首先发送一个OPTIONS请求，这里我们给OPTIONS请求直接返回正常状态
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(org.springframework.http.HttpStatus.OK.value());
            return false;
        }

        return super.preHandle(request, response);
    }
}
