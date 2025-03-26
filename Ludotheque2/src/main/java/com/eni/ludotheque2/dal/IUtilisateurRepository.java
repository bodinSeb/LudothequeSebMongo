package com.eni.ludotheque2.dal;

import com.eni.ludotheque2.bo.Utilisateur;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.awt.print.Book;

public interface IUtilisateurRepository extends MongoRepository<Utilisateur, String> {
}
