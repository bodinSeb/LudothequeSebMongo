package com.eni.ludotheque2.dal;

import com.eni.ludotheque2.bo.Adresse;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.awt.print.Book;

public interface IAdresseRepository extends MongoRepository<Adresse, String> {
}
