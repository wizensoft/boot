package com.wizen.web.portal.init;

import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.wizen.web.portal.model.StatRow;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Component("downloadXlsView")
public class DownloadXlsView extends AbstractXlsView {
    @Override
    protected void buildExcelDocument(
            Map<String, Object> model,
            Workbook workbook,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        response.setHeader("Content-Disposition", "attachment; filename=\"stat.xls\"");

        List<StatRow> stats = (List<StatRow>) model.get("rows");

        CellStyle numberCellStyle = workbook.createCellStyle();
        DataFormat numberDataFormat = workbook.createDataFormat();
        numberCellStyle.setDataFormat(numberDataFormat.getFormat("#,##0"));

        Sheet sheet = workbook.createSheet("mobilestat");
        
        sheet.setFitToPage(true);
        
        int rowCount = 0;
        
        Row header = sheet.createRow(rowCount++);
        header.createCell(0).setCellValue("Currency Pair");
        header.createCell(1).setCellValue("Bid Price");
        header.createCell(2).setCellValue("Ask Price");
        header.createCell(3).setCellValue("Date");
        
        for (int i = 0 ; i < stats.size() ; i++) {
            StatRow stat = stats.get(i);
            //Row row = sheet.createRow(i);
            Row row = sheet.createRow(rowCount++);

            Cell cell0 = row.createCell(0);
            cell0.setCellValue(stat.getName());

            Cell cell1 = row.createCell(1);
            cell1.setCellType(CellType.NUMERIC);
            cell1.setCellValue(stat.getValue1());
            cell1.setCellStyle(numberCellStyle);

            Cell cell2 = row.createCell(2);
            cell2.setCellType(CellType.NUMERIC);
            cell2.setCellValue(stat.getValue2());
            cell2.setCellStyle(numberCellStyle);
        }
    }
}
