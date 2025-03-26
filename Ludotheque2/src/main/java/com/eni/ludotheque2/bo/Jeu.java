package com.eni.ludotheque2.bo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class Jeu {
    @Id
    private String id_jeu;

    @NonNull
    private String titre;

    @NonNull
    private String reference;

    private int age_min;

    private String description;

    private int duree;

    @NonNull
    private float tarif_jour;

    @Transient
    private int nbExemplaire;

    @Transient
    private int nbExemplaireDispo;

    @NonNull
    private List<Genre> genres =  new ArrayList<>();


}
