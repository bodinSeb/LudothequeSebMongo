package com.eni.ludotheque2.dal;

import com.eni.ludotheque2.bo.Genre;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.awt.print.Book;

public interface IGenreRepository extends MongoRepository<Genre, String> {
}
