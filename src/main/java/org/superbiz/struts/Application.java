package org.superbiz.struts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public FilterRegistrationBean strutsFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new org.apache.struts2.dispatcher.FilterDispatcher());
        registration.addInitParameter("actionPackages", "com.lq");
        registration.setName("struts2");
        registration.setOrder(2);
        registration.addUrlPatterns("/*");
        return registration;
    }

    @Bean
    public FilterRegistrationBean strutsCleanupFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new org.apache.struts2.dispatcher.ActionContextCleanUp());
        registration.setName("struts-cleanup");
        registration.setOrder(1);
        registration.addUrlPatterns("/*");
        return registration;
    }

    @Bean
    public FilterRegistrationBean sitemeshFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new com.opensymphony.module.sitemesh.filter.PageFilter());
        registration.setName("sitemesh");
        registration.setOrder(3);
        registration.addUrlPatterns("/*");
        return registration;
    }

}
