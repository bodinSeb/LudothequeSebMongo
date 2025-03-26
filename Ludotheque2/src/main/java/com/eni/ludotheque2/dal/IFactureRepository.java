package com.eni.ludotheque2.dal;

import com.eni.ludotheque2.bo.Facture;
import com.eni.ludotheque2.bo.Jeu;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.awt.print.Book;
import java.util.List;

public interface IFactureRepository extends MongoRepository<Facture, String> {
//    @Query("SELECT f FROM Facture f " +
//            "JOIN f.locations l " +
//            "WHERE l.client.id_client = :idClient")
//    List<Facture> findFactureByIdClient(@Param("idClient") int idClient);
}
