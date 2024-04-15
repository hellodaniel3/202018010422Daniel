package com.pandahis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class SystemApplication {


    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SystemApplication.class, args);
        ConfigurableEnvironment environment = run.getEnvironment();
        String property = environment.getProperty("server.port");
        System.out.println("http://loclahost:"+property);

    }

}
