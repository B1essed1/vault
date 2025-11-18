package com.example.vault.jsonrpc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonRpcServiceDoc {

    private String serviceName;
    private String endpoint;
    private String version;
    private List<JsonRpcMethodDoc> methods;

}
