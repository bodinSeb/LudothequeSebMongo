package com.eni.ludotheque2.bo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Location {
    @Id
    private String id_location;

    @NonNull
    private Date date_debut;

    private Date date_retour;

    @NonNull
    private float tarif_jour;

//    @ManyToOne
//    @NonNull
//    @JoinColumn(name = "id_exemplaire", referencedColumnName = "id_exemplaire")
//    private Exemplaire exemplaire;
//
//    @ManyToOne
//    @NonNull
//    @JoinColumn(name = "id_client", referencedColumnName = "id_client")
//    private Client client;
}
