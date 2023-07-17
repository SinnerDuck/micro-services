package com.ilas.user.service;

import com.ilas.user.client.AccountClient;
import com.ilas.user.model.FullUserResponse;
import com.ilas.user.model.User;
import com.ilas.user.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final AccountClient accountClient;

    public void createUser(User user){
        log.info("Saving new user with email: {}", user.getEmail());
        userRepository.save(user);
    }

    public List<User> listUsers(){
        return userRepository.findAll();
    }

    public FullUserResponse listUsersWithAccounts(Long userId) {
        var user = userRepository.findById(userId).orElse(null);
        var accounts = accountClient.findAllAccountsByUser(userId);
        assert user != null;
        return FullUserResponse.builder()
                .name(user.getName())
                .email(user.getEmail())
                .accounts(accounts)
                .build();
    }
}
