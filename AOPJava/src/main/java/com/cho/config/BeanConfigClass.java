package com.cho.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages= {"com.cho.beans", "com.cho.advisor"})
@EnableAspectJAutoProxy
public class BeanConfigClass {

}
