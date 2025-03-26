package com.eni.ludotheque2.bo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Utilisateur {
    @Id
    private String id_utilisateur;

    @NonNull
    private String login;

    @NonNull
    private String password;

    @NonNull
    private Boolean isAdmin = false;
}
