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

    @Column(name = "name_drug", nullable = false, length = 100)
    private String name; // Коммерческое наименование лекарственного препарата
    @Column(name = "drug_form", nullable = false, length = 100)
    private String nameForm; // Форма выпуска лекарственного препарата
    @Column(name = "name_drug_mnn", nullable = false, length = 100)
    private String nameMnn; // Международное наименование лекарственного препарата
    @Column(name = "description_info", nullable = false,  length = 5000)
    private String description; // Описание лекарственного препарата
    @Column(name = "contraindication_info", nullable = false,  length = 5000)
    private String contraindicationInfo; // Противопоказания и предупреждения
    @Column(name = "publish_date", nullable = false)
    private LocalDate publishDate; // Дата публикации
    @Column(name = "is_active")
    private Boolean isActive; // Флаг активности
    @Column(name = "is_deleted")
    private Boolean isDeleted; // Флаг удаления

}
