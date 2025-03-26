package com.eni.ludotheque2.bo;

import lombok.*;
import org.springframework.data.annotation.Id;

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

//    @ManyToMany
//    @JoinTable(name = "Jeu_Genre",
//            joinColumns = {@JoinColumn(name = "id_jeu")},
//            inverseJoinColumns = {@JoinColumn(name = "id_genre")}
//    )
//    private List<Genre> genres =  new ArrayList<>();
//
//    public  void addGenre(Genre genre) {
//        genres.add(genre);
//    }
}
