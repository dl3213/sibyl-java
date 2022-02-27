package com.sibyl.sshm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Classname SpringConfiguration
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2022/02/27 14:11
 */
@Configuration
@ComponentScan("com.sibyl.sshm")
@Import({DataSourceConfiguration.class})
public class SpringConfiguration {



}
