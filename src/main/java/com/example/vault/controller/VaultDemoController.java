package com.example.vault.controller;

import com.example.vault.config.VaultProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/vault")
@RequiredArgsConstructor
public class VaultDemoController {

    private final VaultProperties vaultProperties;

    @Value("${app.secretKey:default-secret}")
    private String secretKey;

    @GetMapping("/properties")
    public Map<String, String> getProperties() {
        Map<String, String> response = new HashMap<>();
        response.put("secretKey", vaultProperties.getSecretKey() != null ? "***" : "not configured");
        response.put("databasePassword", vaultProperties.getDatabasePassword() != null ? "***" : "not configured");
        response.put("apiKey", vaultProperties.getApiKey() != null ? "***" : "not configured");
        response.put("message", "Secrets are loaded from Vault");
        return response;
    }

    @GetMapping("/health")
    public Map<String, String> health() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "UP");
        response.put("vault", "Connected");
        return response;
    }

}
