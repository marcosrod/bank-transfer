package com.banktransfer.userapi.modules.user.controller;

import com.banktransfer.userapi.modules.user.dto.UserRequest;
import com.banktransfer.userapi.modules.user.dto.UserResponse;
import com.banktransfer.userapi.modules.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    public UserResponse save(@RequestBody UserRequest request) {
        return service.save(request);
    }
}
