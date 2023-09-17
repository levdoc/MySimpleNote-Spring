package com.levdoc.medhapp.service;

import com.levdoc.medhapp.dto.EmergencyNotificationDTO;
import com.levdoc.medhapp.dto.PatientDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Date;
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
        openTemplateFileEM(emergencyNotification);
        openSheetTemplate();

        int rowIndex = 4; // Начальная строка заполнения таблицы
        Row row = sheet.getRow(rowIndex);
        Cell cell = row.createCell(3);
        System.out.println(emergencyNotification.getInnMo());
        cell.setCellValue(emergencyNotification.getInnMo().toString());

        try {
            workbook.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(workbook.getNumberOfSheets());
        System.out.println(sheet.isSelected());

    }

    private void openTemplateFileEM(EmergencyNotificationDTO emergencyNotification) {
        try {
            File original = xlsxTemplateEm.getFile();
            File tmp = new File(XLSX_TEMP_DIRECTORY + emergencyNotification.getDocFio() +
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

    private void openSheetTemplate() {
        sheet = workbook.getSheetAt(0);
    }

}
