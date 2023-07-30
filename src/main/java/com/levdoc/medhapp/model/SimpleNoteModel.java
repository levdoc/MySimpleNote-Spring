package com.levdoc.medhapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "notes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SimpleNoteModel extends GenericModel{
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "main_text", nullable = false)
    private String mainText;

    @Column(name = "publish_date", nullable = false)
    private LocalDate publishDate;

}
