package com.levdoc.medhapp.service;

import com.levdoc.medhapp.constants.FileConstants;
import com.levdoc.medhapp.dto.EmergencyNotificationDTO;
import com.levdoc.medhapp.dto.PatientDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import static com.levdoc.medhapp.constants.FileConstants.XLSX_TEMP_DIRECTORY;
import static org.aspectj.util.FileUtil.copyFile;

@Slf4j
@Service
public class EmExcelExporter {
    @Value("classpath:file/xlsxTemplateEm.xlsx")
    private Resource xlsxTemplateEm;
    private XSSFWorkbook workbook;
    private Sheet sheet;

    public void createXlsxFromEmDto(EmergencyNotificationDTO emergencyNotification) {
        int rowIndex = FileConstants.START_ROW_INDEX;

        openTemplateFileEM(emergencyNotification.getDocFio());
        openSheetTemplate();

        for (PatientDTO patient :
                emergencyNotification.getPatientList()) {

            Row row = sheet.getRow(rowIndex);
            Cell cell = row.createCell(3);
            cell.setCellValue(emergencyNotification.getInnMo());

            rowIndex++;
        }

        closeTemplateFileEM();
    }

    /**
     * Метод создает копию (ФИОВрача+UUID) шаблона и открывает его для внесения данных
     *
     * @param emDocFio метод принимает ФИО врача
     */
    private void openTemplateFileEM(String emDocFio) {
        try {
            File original = xlsxTemplateEm.getFile();
            File tmp = new File(XLSX_TEMP_DIRECTORY + emDocFio +
                    "_" + UUID.randomUUID() + ".xlsx");
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
}
