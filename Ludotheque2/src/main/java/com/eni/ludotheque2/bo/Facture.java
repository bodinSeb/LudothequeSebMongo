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
public class Facture {
    @Id
    private String id_facture;

    @NonNull
    private Date date_paiement;

    @NonNull
    private Float montantFacture;

    @NonNull
    private List<Location> locations;
}
