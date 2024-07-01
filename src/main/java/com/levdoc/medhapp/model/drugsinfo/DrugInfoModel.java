package com.levdoc.medhapp.model.drugsinfo;

import com.levdoc.medhapp.model.GenericModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "drug_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DrugInfoModel extends GenericModel {

    @Column(name = "name_drug", nullable = false, length = 200)
    private String name;
    @Column(name = "description_info", nullable = false,  length = 5000)
    private String description;
    @Column(name = "publish_date", nullable = false)
    private LocalDate publishDate;

}
