package com.eni.ludotheque2.bo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Exemplaire {
    @Id
    private String id_exemplaire;

    @NonNull
    private String code_barre;

    @NonNull
    private boolean louable;

    @NonNull
    private Jeu jeu;
}
