package com.eni.ludotheque2.bo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Genre {
    @NonNull
    private String libelle;
}
