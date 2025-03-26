package com.eni.ludotheque2.bo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Adresse {
//    @Id
//    private String id;

    @NonNull
    private int num_rue;

    @NonNull
    private String rue;

    @NonNull
    private String code_postal;

    @NonNull
    private String ville;
}
