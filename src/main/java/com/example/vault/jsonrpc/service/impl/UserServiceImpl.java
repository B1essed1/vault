package com.example.vault.jsonrpc.service.impl;

import com.example.vault.jsonrpc.dto.UserDto;
import com.example.vault.jsonrpc.service.UserService;
import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@AutoJsonRpcServiceImpl
public class UserServiceImpl implements UserService {

    private final Map<Long, UserDto> userDatabase = new HashMap<>();

    public UserServiceImpl() {
        // Initialize with some sample data
        userDatabase.put(1L, new UserDto(1L, "john_doe", "john@example.com", "John Doe"));
        userDatabase.put(2L, new UserDto(2L, "jane_smith", "jane@example.com", "Jane Smith"));
    }

    @Override
    public UserDto getUserById(Long id) {
        log.info("Getting user by id: {}", id);
        UserDto user = userDatabase.get(id);
        if (user == null) {
            log.warn("User not found with id: {}", id);
            throw new RuntimeException("User not found with id: " + id);
        }
        return user;
    }

    @Override
    public UserDto createUser(UserDto user) {
        log.info("Creating user: {}", user);
        if (user.getId() == null) {
            user.setId(System.currentTimeMillis());
        }
        userDatabase.put(user.getId(), user);
        log.info("User created successfully with id: {}", user.getId());
        return user;
    }

    @Override
    public boolean deleteUser(Long id) {
        log.info("Deleting user with id: {}", id);
        UserDto removed = userDatabase.remove(id);
        boolean success = removed != null;
        if (success) {
            log.info("User deleted successfully with id: {}", id);
        } else {
            log.warn("User not found for deletion with id: {}", id);
        }
        return success;
    }

    @Override
    public String getStatus() {
        log.info("Getting service status");
        return "JSON-RPC Service is running. Total users: " + userDatabase.size();
    }

}
