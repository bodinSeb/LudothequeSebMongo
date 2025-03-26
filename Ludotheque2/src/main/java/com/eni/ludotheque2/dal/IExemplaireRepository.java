package com.eni.ludotheque2.dal;

import com.eni.ludotheque2.bo.Exemplaire;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.awt.print.Book;

public interface IExemplaireRepository extends MongoRepository<Exemplaire, String> {
}
