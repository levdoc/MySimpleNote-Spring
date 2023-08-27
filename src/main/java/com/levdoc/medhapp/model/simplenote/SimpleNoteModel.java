package com.levdoc.medhapp.model.simplenote;

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
public class SimpleNoteModel {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "main_text", nullable = false, length = 3000)
    private String mainText;

    @Column(name = "publish_date", nullable = false)
    private LocalDate publishDate;

    @Column(name = "type_of_note", nullable = false)
    @Enumerated
    private TypeOfNote typeOfNote;

}
