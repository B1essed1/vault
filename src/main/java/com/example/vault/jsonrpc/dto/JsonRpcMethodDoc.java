package com.example.vault.jsonrpc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonRpcMethodDoc {

    private String method;
    private String description;
    private List<Parameter> parameters;
    private String returnType;
    private Map<String, Object> example;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Parameter {
        private String name;
        private String type;
        private String description;
        private boolean required;
    }

}
