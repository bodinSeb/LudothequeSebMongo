package com.eni.ludotheque2.dal;

import com.eni.ludotheque2.bo.Facture;
import com.eni.ludotheque2.bo.Jeu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.awt.print.Book;
import java.util.List;

public interface IFactureRepository extends MongoRepository<Facture, String> {

}
