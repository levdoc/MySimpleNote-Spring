package com.levdoc.medhapp.service;

import com.levdoc.medhapp.dto.EmergencyNotificationDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class EmExcelExporter {
    @Value("classpath:file/tmp/xlsxTemplateEm.xlsx")
    private Resource xlsxTemplateEm;
    private XSSFWorkbook workbook;
    private Sheet sheet;

    public void createXlsxFromEmDto (EmergencyNotificationDTO emergencyNotification) {
        openTemplateFileEM();
        openSheetTemplate();

        System.out.println(workbook.getNumberOfSheets());
        System.out.println(sheet.isSelected());

    }

    private void openTemplateFileEM() {
        try {
            workbook = new XSSFWorkbook(xlsxTemplateEm.getFile());
        } catch (IOException | InvalidFormatException e) {
            System.out.println(e.getLocalizedMessage());
            log.warn("ОШИБКА ->>> " + e.getLocalizedMessage());
            throw new RuntimeException(e);
        }
    }

    private void openSheetTemplate () {
        sheet = workbook.getSheetAt(0);
    }

}
