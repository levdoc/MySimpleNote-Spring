package com.levdoc.medhapp.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Mkb10Dto {
    private Long id;
    private String kodMkb;
    private String diseaseName;
    private String perentsKodMkb;
    private String field;
    private Boolean isFavorite;
}
