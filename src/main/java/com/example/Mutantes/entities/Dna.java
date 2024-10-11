package com.example.Mutantes.entities;

import com.example.Mutantes.entities.Base;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Dna extends Base implements Serializable {

    private String[] StringDna;

    private boolean isMutant;
}