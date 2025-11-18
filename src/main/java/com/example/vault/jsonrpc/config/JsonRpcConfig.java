package com.example.vault.jsonrpc.config;

import com.example.vault.jsonrpc.service.UserService;
import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImplExporter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JsonRpcConfig {

    @Bean
    public AutoJsonRpcServiceImplExporter autoJsonRpcServiceImplExporter() {
        AutoJsonRpcServiceImplExporter exporter = new AutoJsonRpcServiceImplExporter();
        // Optional: You can add error resolvers, interceptors, etc. here
        return exporter;
    }

}
