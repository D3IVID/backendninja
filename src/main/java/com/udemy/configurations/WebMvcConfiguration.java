package com.udemy.configurations;

import com.udemy.component.RequestTimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Guillermo Loyo on 17/05/2017.
 */
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

    @Autowired
    @Qualifier("requestTimeInterceptor")
    RequestTimeInterceptor requestTimeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(requestTimeInterceptor);
    }
}
