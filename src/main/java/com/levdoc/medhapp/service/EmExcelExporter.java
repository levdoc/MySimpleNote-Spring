package com.levdoc.medhapp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class EmExcelExporter {
    @Value("classpath:file/tmp/xlsxTemplateEm.xlsx")
    private Resource xlsxTemplateEm;

    public void testMethod() {
        System.out.println(xlsxTemplateEm.isFile());
    }

}
