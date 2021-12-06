package ru.ketbiev.srcibble.model;

import lombok.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class User {

    private int id;
    private String signature;
    @NonNull private String createAccount;
    @NonNull private String lastLogin;
    @NonNull private String login;
    @NonNull private String password;
    @NonNull private String username;
}
