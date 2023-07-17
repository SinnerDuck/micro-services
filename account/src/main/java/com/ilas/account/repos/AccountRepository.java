package com.ilas.account.repos;

import com.ilas.account.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findAllByUserId(Long userId);
}
