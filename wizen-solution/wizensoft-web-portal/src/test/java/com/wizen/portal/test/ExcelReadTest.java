package com.wizen.portal.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ooxml.POIXMLDocument;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;

@SpringBootTest
public class ExcelReadTest {

	@Test @Ignore
	void xlsReadTest() throws JsonProcessingException{
		String cwd = System.getProperty("user.dir");
        System.out.println("Current working directory : " + cwd);
        String filePath = cwd + "/files/sample_excelfiles/sample1.xls";
        
        FileInputStream fis = null;
        HSSFWorkbook workbook = null;
        try {
        	fis= new FileInputStream(filePath);
            // HSSFWorkbook은 엑셀파일 전체 내용을 담고 있는 객체
            workbook = new HSSFWorkbook(fis);
            //탐색에 사용할 Sheet, Row, Cell 객체
            HSSFSheet curSheet;
            HSSFRow   curRow;
            HSSFCell  curCell;
            for(int sheetIndex = 0 ; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
            	// 현재 Sheet 반환
                curSheet = workbook.getSheetAt(sheetIndex);
                // row 탐색 for문
                System.out.println("curSheet.getPhysicalNumberOfRows() : " + curSheet.getPhysicalNumberOfRows());
                for(int rowIndex=0; rowIndex < curSheet.getPhysicalNumberOfRows(); rowIndex++) {
                	
                	// 현재 row 반환
                    curRow = curSheet.getRow(rowIndex);
                    
                    String value;
                    //아래와 같이 특정 row index를 기준으로 헤더 또는 데이터 영역처리 가능
                	if(rowIndex == 0) {
                		//row 0 헤더
                		// cell 탐색 for 문
                	} else {
                		// row 1부터 데이터
                		// cell 탐색 for 문
                        
                	}
                	
                	System.out.print("rowIndex="+rowIndex);
                	// 모든 row 데이터 읽기
                	for(int cellIndex=0;cellIndex<curRow.getPhysicalNumberOfCells(); cellIndex++) {
                    	curCell = curRow.getCell(cellIndex);
                    	value = "";
                        // cell 스타일이 다르더라도 String으로 반환 받음
                        switch (curCell.getCellType()){
                        case FORMULA : //HSSFCell.CELL_TYPE_FORMULA:
                            value = curCell.getCellFormula() +" FORMULA_KKK";
                            break;
                        case NUMERIC://HSSFCell.CELL_TYPE_NUMERIC:
                            value = curCell.getNumericCellValue()+" NUMERIC_KKK";
                            break;
                        case STRING: //HSSFCell.CELL_TYPE_STRING:
                            value = curCell.getStringCellValue()+" STRING_KKK";
                            break;
                        case BLANK : //HSSFCell.CELL_TYPE_BLANK:
                            value = curCell.getBooleanCellValue()+" BLANK_KKK";
                            break;
                        case ERROR : //HSSFCell.CELL_TYPE_ERROR:
                            value = curCell.getErrorCellValue()+" ERROR_KKK";
                            break;
                        default:
                            value = new String() +" default_kkk";
                            break;
                        }
                        System.out.print(", cellIndex="+cellIndex + " value="+ value);
                    }
                	System.out.println( "");
                }
            }
            
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        } finally {
            try {
                // 사용한 자원은 finally에서 해제
                if( workbook!= null) workbook.close();
                if( fis!= null) fis.close();
                
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
	}

	@Test
	@Ignore
	void xlsxReadTest() throws JsonProcessingException{
		System.out.println("xlsxReadTest === " );
		String cwd = System.getProperty("user.dir");
        String filePath = cwd + "/files/sample_excelfiles/sample1.xlsx";
        
        System.out.println("filePath : " + filePath );
        
        FileInputStream fis = null;
        XSSFWorkbook workbook = null;
        try {
        	fis= new FileInputStream(filePath);
        	
        	//POIXMLDocument.hasOOXMLHeader(fis)
        	
            // HSSFWorkbook은 엑셀파일 전체 내용을 담고 있는 객체
            workbook = new XSSFWorkbook(fis);
            //탐색에 사용할 Sheet, Row, Cell 객체
            XSSFSheet curSheet;
            XSSFRow   curRow;
            XSSFCell  curCell;
            for(int sheetIndex = 0 ; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
            	// 현재 Sheet 반환
                curSheet = workbook.getSheetAt(sheetIndex);
                // row 탐색 for문
                System.out.println("curSheet.getPhysicalNumberOfRows() : " + curSheet.getPhysicalNumberOfRows());
                for(int rowIndex=0; rowIndex < curSheet.getPhysicalNumberOfRows(); rowIndex++) {
                	
                	// 현재 row 반환
                    curRow = curSheet.getRow(rowIndex);
                    
                    String value;
                    //아래와 같이 특정 row index를 기준으로 헤더 또는 데이터 영역처리 가능
                	if(rowIndex == 0) {
                		//row 0 헤더
                		// cell 탐색 for 문
                	} else {
                		// row 1부터 데이터
                		// cell 탐색 for 문
                        
                	}
                	
                	System.out.print("rowIndex="+rowIndex);
                	// 모든 row 데이터 읽기
                	for(int cellIndex=0;cellIndex<curRow.getPhysicalNumberOfCells(); cellIndex++) {
                    	curCell = curRow.getCell(cellIndex);
                    	value = "";
                        // cell 스타일이 다르더라도 String으로 반환 받음
                        switch (curCell.getCellType()){
                        case FORMULA : //XSSFCell.CELL_TYPE_FORMULA:
                            value = curCell.getCellFormula() +" FORMULA_KKK";
                            break;
                        case NUMERIC://XSSFCell.CELL_TYPE_NUMERIC:
                            value = curCell.getNumericCellValue()+" NUMERIC_KKK";
                            break;
                        case STRING: //XSSFCell.CELL_TYPE_STRING:
                            value = curCell.getStringCellValue()+" STRING_KKK";
                            break;
                        case BLANK : //XSSFCell.CELL_TYPE_BLANK:
                            value = curCell.getBooleanCellValue()+" BLANK_KKK";
                            break;
                        case ERROR : //XSSFCell.CELL_TYPE_ERROR:
                            value = curCell.getErrorCellValue()+" ERROR_KKK";
                            break;
                        default:
                            value = new String() +" default_kkk";
                            break;
                        }
                        System.out.print(", cellIndex="+cellIndex + " value="+ value);
                    }
                	System.out.println( "");
                }
            }
            
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        } finally {
            try {
                // 사용한 자원은 finally에서 해제
                if( workbook!= null) workbook.close();
                if( fis!= null) fis.close();
                
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
	}

	@Test
	void excelFileDetectTest () {
		System.out.println("excelFileDetectTest === " );
		String cwd = System.getProperty("user.dir");
        String filePath = cwd + "/files/sample_excelfiles/sample1.xls";
        System.out.println("filePath =" + filePath);
        try {
        	//Workbook wb = WorkbookFactory.create(myExcelFile);
            Workbook wb = WorkbookFactory.create(new File(filePath));
            if (wb instanceof HSSFWorkbook) {
                // do whatever
            	System.out.println( " HSSFWorkbook file");
            } else if (wb instanceof SXSSFWorkbook) {
                // do whatever// 대용량 쓰기 전용의 데이터라서 무의미
            	System.out.println( " SXSSFWorkbook file");
            } else if (wb instanceof XSSFWorkbook) {
                // do whatever
            	System.out.println( " XSSFWorkbook file");
            }
            //String ext = FilenameUtils.getExtension("path to the file");
            wb.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
        	
        }
		
	}
}
