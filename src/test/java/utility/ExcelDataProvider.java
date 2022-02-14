package utility;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class ExcelDataProvider {

    XSSFWorkbook workbook;

    public ExcelDataProvider() throws IOException {
        File src = new File("TestData/Data.xlsx");
        FileInputStream fileInputStream = new FileInputStream(src);
        workbook = new XSSFWorkbook(fileInputStream);
    }

    public String getStringData(String sheetName, int row, int column) {
      return workbook.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
    }

    public double getNumericData(String sheetName, int row, int column) {
        return workbook.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
    }
}
