package com.eni.ludotheque2.dal;

import com.eni.ludotheque2.bo.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.awt.print.Book;
import java.util.List;

public interface IClientRepository extends MongoRepository<Client, String> {
    List<Client> findClientByNom(String nom);
}
