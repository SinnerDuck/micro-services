package com.ilas.account.service;

import com.ilas.account.model.Account;
import com.ilas.account.repos.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountService {
    private final AccountRepository accountRepository;
    public void createAccount(Account account){
        accountRepository.save(account);
        log.info("Created new account");
    }

    public List<Account> listAccounts(){
        return accountRepository.findAll();
    }

    public List<Account> listAllAccountsByUser(Long userId) {
        return accountRepository.findAllByUserId(userId);
    }
}
