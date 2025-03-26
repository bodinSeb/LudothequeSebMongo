package com.eni.ludotheque2.bo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Client {
    @Id
    private String id_client;

    @NonNull
    private String nom;

    @NonNull
    private String prenom;

    @NonNull
    private String email;

    @NonNull
    private String no_telephone;

    private Adresse adresse;
}
