package com.ilas.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FullUserResponse {
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;

    List<Account> accounts;
}
