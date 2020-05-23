package com.lpg.gmall.user.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @Description
 * @auther l
 * @create 2020-05-22 11:45
 */
@Configuration
public class DruidConfig {

    @ConfigurationProperties("spring.datasource")
    @Bean
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }


    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        HashMap<String, String> initParams = new HashMap<>();
        initParams.put("loginUsername", "admin");
        initParams.put("loginPassword", "123456");
        initParams.put("allow", ""); // 允许谁访问
        initParams.put("deny", "192.168.15.21"); // 拒绝谁访问
        bean.setInitParameters(initParams);
        return bean;

    }
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        HashMap<String, String> initparams = new HashMap<>();
        initparams.put("exclusion", "*.js,*.css,/druid/*");
        bean.setInitParameters(initparams);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }

}
