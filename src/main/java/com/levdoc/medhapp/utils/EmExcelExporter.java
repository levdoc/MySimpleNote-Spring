package com.levdoc.medhapp.utils;

import com.levdoc.medhapp.model.notification.EmergencyNotification;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class EmExcelExporter {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private EmergencyNotification em;

    public EmExcelExporter(EmergencyNotification em) {
        workbook = new XSSFWorkbook();
        this.em = em;
    }



}
