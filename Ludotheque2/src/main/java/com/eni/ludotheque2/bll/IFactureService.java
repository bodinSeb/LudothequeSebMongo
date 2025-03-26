package com.eni.ludotheque2.bll;

import com.eni.ludotheque2.bo.Facture;

import java.util.List;

public interface IFactureService {
    Facture createFacture(List<String> idsLoc, String idClient);
    List<Facture> findFactureByIdClient(String idClient);
}
