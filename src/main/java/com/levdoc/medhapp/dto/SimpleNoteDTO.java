package com.levdoc.medhapp.dto;

import com.levdoc.medhapp.model.simplenote.TypeOfNote;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class SimpleNoteDTO {
    private Long id;
    private String mainText;
    private LocalDate publishDate;
    private TypeOfNote typeOfNote;

}
