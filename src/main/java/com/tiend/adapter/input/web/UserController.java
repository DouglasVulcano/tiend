package com.tiend.adapter.input.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiend.adapter.input.dto.UserDto;
import com.tiend.adapter.input.mappers.UserDtoMapper;
import com.tiend.adapter.output.responses.ApiResponse;
import com.tiend.domain.port.input.UserService;
import com.tiend.infra.security.SecurityUtility;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public ResponseEntity<ApiResponse<UserDto>> getAuthenticatedUser() {
        Long userId = SecurityUtility.authenticatedUserId();
        UserDto userDto = userService.getUserById(userId).map(UserDtoMapper::toDto).orElseThrow(
                () -> new RuntimeException("User not found"));
        return ResponseEntity.ok(ApiResponse.success("User retrieved successfully", userDto));
    }
}