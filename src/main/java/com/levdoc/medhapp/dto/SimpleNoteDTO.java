package com.levdoc.medhapp.dto;

import com.levdoc.medhapp.model.simplenote.TypeOfNote;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SimpleNoteDTO
        extends GenericModelDTO{

    private String mainText;
    private LocalDate publishDate;
    @NotEmpty(message = "Следует указать тип заметки!!! ")
    private TypeOfNote typeOfNote;

}
