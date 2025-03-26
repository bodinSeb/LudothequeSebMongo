package com.eni.ludotheque2.dal;

import com.eni.ludotheque2.bo.Location;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.awt.print.Book;
import java.util.List;

public interface ILocationRepository extends MongoRepository<Location, String> {
//    @Query("SELECT l FROM Location l " +
//            "WHERE l.client.id_client = :idClient " +
//            "AND l.date_retour = null")
//    List<Location> findLocationByIdClientAndTerminee(@Param("idClient") Integer idClient);
}
