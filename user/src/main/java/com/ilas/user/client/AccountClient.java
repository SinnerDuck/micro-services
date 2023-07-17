package com.ilas.user.client;


import com.ilas.user.model.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "account-service", url = "${application.config.accounts-url}")
public interface AccountClient {

    @GetMapping("/user/{user-id}")
    List<Account> findAllAccountsByUser(@PathVariable("user-id") Long userId);

}
