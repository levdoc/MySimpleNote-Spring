package com.levdoc.medhapp.service;

import com.levdoc.medhapp.constants.FileConstants;
import com.levdoc.medhapp.dto.EmergencyNotificationDTO;
import com.levdoc.medhapp.dto.PatientDTO;
import com.levdoc.medhapp.model.notification.LaboratoryConfirmationEnum;
import com.levdoc.medhapp.model.notification.SexEnum;
import com.levdoc.medhapp.model.notification.SocialGroupEnum;
import com.levdoc.medhapp.model.notification.TypeOfDiagnosisEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import static com.levdoc.medhapp.constants.FileConstants.EM_OUTPUT_EXTENTION;
import static com.levdoc.medhapp.constants.FileConstants.XLSX_TEMP_DIRECTORY;
import static org.aspectj.util.FileUtil.copyFile;

@Slf4j
@Service
public class EmExcelExporter {

    private XSSFWorkbook workbook;
    private Sheet sheet;
    private File tmp;

    private void writeXlsxFromEmDto(EmergencyNotificationDTO emergencyNotification) {
        int rowIndex = FileConstants.START_ROW_INDEX;

        openTemplateFileEM();
        openSheetTemplate();

        for (PatientDTO patient :
                emergencyNotification.getPatientList()) {
            Row row = sheet.getRow(rowIndex);
            createCell(row, 3, emergencyNotification.getInnMo());
            createCell(row, 4, emergencyNotification.getMoName());
            createCell(row, 5, emergencyNotification.getDocFio());
            createCell(row, 6, emergencyNotification.getDocPhoneNumber());
            createCell(row, 8, patient.getSurname());
            createCell(row, 9, patient.getName());
            createCell(row, 10, patient.getPatronymic());
            createCell(row, 11, patient.getDateOfBirth());
            createCell(row, 12, patient.getSex());
            createCell(row, 13, patient.getPatientPhoneNumber());
            createCell(row, 15, patient.getMunicipality());
            createCell(row, 16, patient.getCommunity());
            createCell(row, 17, patient.getStreet());
            createCell(row, 18, patient.getHouseNumber());
            createCell(row, 19, patient.getApartmentNumber());
            createCell(row, 20, patient.getPlaceOfStudy());
            createCell(row, 27, patient.getSocialGroup());
            createCell(row, 28, patient.getDateOfSchoolVisit());
            createCell(row, 29, patient.getTypeOfDiagnosis());
            createCell(row, 30, patient.getMkb10CodeOfDisease());
            createCell(row, 31, patient.getMkb10CodeOfDiseaseRefined());
            createCell(row, 32, patient.getDateOfDiagnosis());
            createCell(row, 33, patient.getDateOfConfirmationOfDiagnosis());
            createCell(row, 34, patient.getDiagnosisConfirmedByLaboratory());
            createCell(row, 35, patient.getDateOfWithdrawalOfTheDiagnosis());
            createCell(row, 36, patient.getDateAndTimeOfHospitalization()); //TODO Исправить формат даты!!!
            createCell(row, 37, emergencyNotification.getInnMo());
            createCell(row, 38, emergencyNotification.getMoName());
            createCell(row, 39, patient.getDateOfIllness());
            createCell(row, 40, patient.getDateOfTheApplication());
            rowIndex++;
        }
        closeTemplateFileEM();
    }

    public File getEmExcleFile(EmergencyNotificationDTO emergencyNotification) {
        writeXlsxFromEmDto(emergencyNotification);
        return tmp;
    }

    /**
     * Метод создает копию (UUID) шаблона и открывает его для внесения данных (java.io.File)
     */
    private void openTemplateFileEM() {
        try {
            File original = new File("tmp/file/xlsxTemplateEm.xlsx");
            tmp = new File(XLSX_TEMP_DIRECTORY + UUID.randomUUID() + EM_OUTPUT_EXTENTION);
            copyFile(original, tmp);
            log.info("Create tmp file xlsx!");
            log.info(tmp.getCanonicalPath());
            workbook = new XSSFWorkbook(tmp);
        } catch (IOException | InvalidFormatException e) {
            log.warn(e.getLocalizedMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     * Метод открывает лист документа для внесения изменений.
     * Активный лист указан в FileConstants.ACTIVE_SHEET
     */
    private void openSheetTemplate() {
        sheet = workbook.getSheetAt(FileConstants.ACTIVE_SHEET);
    }

    /**
     * Метод закрывает ранее открытую копию книги Excel (шаблон экстренного извещения),
     * и сохраняет внесенные изменения.
     */
    private void closeTemplateFileEM() {
        try (OutputStream stream = OutputStream.nullOutputStream()) {
            workbook.write(stream);
            workbook.close();
            log.info("Документ успешно создан!");
        } catch (IOException e) {
            log.error(e.getLocalizedMessage());
            throw new RuntimeException(e);
        }
    }

    private void createCell(Row row, int columnCount, Object value) {
        Cell cell = row.createCell(columnCount);
        if (value != null) {
            if (value instanceof Long) {
                cell.setCellValue((Long) value);
            } else if (value instanceof String) {
                cell.setCellValue((String) value);
            } else if (value instanceof LocalDate) {
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                cell.setCellValue(((LocalDate) value).format(dateTimeFormatter));
            } else if (value instanceof SexEnum) {
                cell.setCellValue(((SexEnum) value).getSex());
            } else if (value instanceof SocialGroupEnum) {
                cell.setCellValue(((SocialGroupEnum) value).getTypeOfSocialGroup());
            } else if (value instanceof TypeOfDiagnosisEnum) {
                cell.setCellValue(((TypeOfDiagnosisEnum) value).getTypeOfDiagnosis());
            } else if (value instanceof LaboratoryConfirmationEnum) {
                cell.setCellValue(((LaboratoryConfirmationEnum) value).getLaboratoryConfirmation());
            } else if (value instanceof LocalDateTime) {
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
                cell.setCellValue(((LocalDateTime) value).format(dateTimeFormatter));
            }
        }
    }
}
