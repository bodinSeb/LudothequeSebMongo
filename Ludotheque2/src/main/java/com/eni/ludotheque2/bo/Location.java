package com.eni.ludotheque2.bo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Document("locations")
public class Location {
    @Id
    private String id_location;

    @NonNull
    private Date date_debut;

    private Date date_retour;

    @NonNull
    private float tarif_jour;


    @NonNull
    private Exemplaire exemplaire;

    @NonNull
    private Client client;
}
