package com.eni.ludotheque2.dto;

import lombok.Data;

import java.util.List;

@Data
public class CreateFacture {
    private List<String> idsLoc;
    private String idClient;
}
