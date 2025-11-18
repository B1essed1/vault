package com.example.vault.jsonrpc.service;

import com.example.vault.jsonrpc.dto.UserDto;
import com.googlecode.jsonrpc4j.JsonRpcParam;
import com.googlecode.jsonrpc4j.JsonRpcService;

@JsonRpcService("/api/rpc/user")
public interface UserService {

    UserDto getUserById(@JsonRpcParam(value = "id") Long id);

    UserDto createUser(@JsonRpcParam(value = "user") UserDto user);

    boolean deleteUser(@JsonRpcParam(value = "id") Long id);

    String getStatus();

}
