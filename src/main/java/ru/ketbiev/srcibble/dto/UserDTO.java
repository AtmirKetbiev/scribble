package ru.ketbiev.srcibble.dto;

import lombok.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private int id;
    @NonNull private String login;
    @NonNull private String password;
    @NonNull private String username;
    private String signature;
    @NonNull private String createAccount;
    @NonNull private String lastLogin;
}
