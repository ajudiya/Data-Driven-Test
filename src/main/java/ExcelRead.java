import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelRead {
    public static void main(String[] args) throws IOException {
        String excelFilePath = "/home/ganesha/Selenium/DDT/dataFiles/AutomationExerciseCredentials.xlsx";
        FileInputStream fileInputStream = new FileInputStream(excelFilePath);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet xssfSheet = xssfWorkbook.getSheet("Sheet1");

        int rows = xssfSheet.getLastRowNum();
        int cols = xssfSheet.getRow(1).getLastCellNum();

        for (int r = 0; r <= rows; r++) {
            XSSFRow row = xssfSheet.getRow(r);
            for (int c = 0; c < cols; c++) {
                XSSFCell cell = row.getCell(c);
                switch (cell.getCellType()) {
                    case STRING:
                        System.out.print(cell.getStringCellValue());
                        break;
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue());
                        break;
                    case BOOLEAN:
                        System.out.print(cell.getBooleanCellValue());
                        break;
                }
                System.out.print(" | ");
            }
            System.out.println();
        }
    }
}