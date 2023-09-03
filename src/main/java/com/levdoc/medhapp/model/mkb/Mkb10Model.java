package com.levdoc.medhapp.model.mkb;

import com.levdoc.medhapp.model.GenericModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "mkb10")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mkb10Model extends GenericModel {

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
