package com.misicode.purpost.userservice.controller;

import com.misicode.purpost.userservice.dto.UserResponse;
import com.misicode.purpost.userservice.mappers.UserMapper;
import com.misicode.purpost.userservice.services.user.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{email}")
    public ResponseEntity<UserResponse> getUserByEmail(@PathVariable String email) {
        return ResponseEntity.ok(
                UserMapper.mapToUserResponse(userService.getUserByEmail(email))
        );
    }
}
