package com.pandahis.dashboard.framework.codegen.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(CodegenProperties.class)
public class CodegenConfiguration {
}
