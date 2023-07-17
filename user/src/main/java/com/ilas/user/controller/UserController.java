package com.ilas.user.controller;


import com.ilas.account.model.Account;
import com.ilas.user.model.FullUserResponse;
import com.ilas.user.model.User;
import com.ilas.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody User user){
        userService.createUser(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> findAllUser(){
        return ResponseEntity.ok(userService.listUsers());
    }

    @GetMapping("/with-accounts/{user-id}")
    public ResponseEntity<FullUserResponse> findAllUser(@PathVariable("user-id") Long userId){
        return ResponseEntity.ok(userService.listUsersWithAccounts(userId));
    }
}
