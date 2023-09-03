package com.levdoc.medhapp.model.notification;

import com.levdoc.medhapp.model.GenericModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "patient_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patient extends GenericModel {

    @Column(name = "surname")
    private String surname;

}
