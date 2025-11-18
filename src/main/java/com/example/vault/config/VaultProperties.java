package com.example.vault.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "app")
public class VaultProperties {

    private String secretKey;
    private String databasePassword;
    private String apiKey;

}
