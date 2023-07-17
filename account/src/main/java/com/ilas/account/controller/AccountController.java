package com.ilas.account.controller;

import com.ilas.account.model.Account;
import com.ilas.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {
    private final AccountService accountService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Account account){
        accountService.createAccount(account);
    }

    @GetMapping
    public ResponseEntity<List<Account>> findAllUser(){
        return ResponseEntity.ok(accountService.listAccounts());
    }

    @GetMapping("/user/{user-id}")
    public ResponseEntity<List<Account>> findAllUser(@PathVariable("user-id") Long userId){
        return ResponseEntity.ok(accountService.listAllAccountsByUser(userId));
    }
}
