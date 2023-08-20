package com.levdoc.medhapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "mkb10")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mkb10Model {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "kod_mkb", nullable = true)
    private String kodMkb;

    @Column(name = "disease_name", nullable = true)
    private String diseaseName;

    @Column(name = "perents_kod_mkb", nullable = true)
    private String perentsKodMkb;

    @Column(name = "field4", nullable = true)
    private String field;

    @Column(name = "favorite", nullable = true)
    private Boolean isFavorite;

}
