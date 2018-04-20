package com.hxh.skymall.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration

public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean createFilter(DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean sfb = new ShiroFilterFactoryBean();
        sfb.setSecurityManager(securityManager);
        sfb.setLoginUrl("/user/toLogin");
        sfb.setUnauthorizedUrl("/user/toNoQx");
        Map<String,String> rule = new LinkedHashMap<>();
        rule.put("/html/*","authc");
        rule.put("/*","anon");
        sfb.setFilterChainDefinitionMap(rule);
        return sfb;
    }

    @Bean
    public DefaultWebSecurityManager createSecurityManager(JdbcRealm jdbcRealm){

        DefaultWebSecurityManager dsm = new DefaultWebSecurityManager();
        dsm.setRealm(jdbcRealm);

        return dsm;
    }

    @Bean
    public JdbcRealm createJdbcRealm(DruidDataSource dd){
        JdbcRealm jdbcRealm = new JdbcRealm();
        jdbcRealm.setDataSource(dd);
        jdbcRealm.setAuthenticationQuery("select password from user where name = ?");
        jdbcRealm.setUserRolesQuery("select r.name from  role r left join user_role ur on r.id=ur.rid left join user u on ur.uid=u.id  where u.name=?");
        jdbcRealm.setPermissionsQuery("select t.text from tool t left join r_t rt on t.id=rt.tid left join role r on rt.rid=r.id where r.name=?");

        return jdbcRealm;
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource createDruidDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }
}
