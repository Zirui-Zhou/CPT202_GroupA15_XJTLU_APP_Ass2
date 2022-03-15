package com.groupa15.config;

import com.groupa15.shiro.AccountRealm;
import com.groupa15.shiro.JwtFilter;
import com.groupa15.utils.JwtUtils;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Zirui Zhou
 * @date 2022/3/15
 */

@Configuration
public class ShiroConfig {

    @Autowired
    JwtFilter jwtFilter;

    @Bean
    public DefaultWebSecurityManager securityManager(AccountRealm accountRealm) {

        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager(accountRealm);

        //inject sessionManager
        //securityManager.setSessionManager(sessionManager);

        // inject redisCacheManager
        //securityManager.setCacheManager(redisCacheManager);
        return securityManager;
    }

    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();

//        Map<String, String> filterMap = new LinkedHashMap<>();
//        filterMap.put("/**", "jwt");
//        chainDefinition.addPathDefinitions(filterMap);

        chainDefinition.addPathDefinition("/**", "jwt");

        return chainDefinition;
    }

   // @Bean("shiroFilterFactoryBean")
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager,
                                                         ShiroFilterChainDefinition shiroFilterChainDefinition) {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);

        Map<String, Filter> filters = new HashMap<>();
        filters.put("jwt", jwtFilter);
        shiroFilter.setFilters(filters);

        Map<String, String> filterMap = shiroFilterChainDefinition.getFilterChainMap();

        shiroFilter.setFilterChainDefinitionMap(filterMap);
        return shiroFilter;
    }

}
