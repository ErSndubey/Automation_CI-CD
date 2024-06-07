import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {
    public static void main(String[] args) {
        try {
            // Provide the path to your Excel file
            String excelFilePath = "C:\\Users\\sndub\\OneDrive\\Documents\\TestSheet1.xlsx";

            // Open the Excel file
            FileInputStream inputStream = new FileInputStream(excelFilePath);
            Workbook workbook = new XSSFWorkbook(inputStream);

            // Get the first sheet (assuming your data is in the first sheet)
            Sheet sheet = workbook.getSheetAt(0);

            // Iterate through rows and cells
            DataFormatter dataFormatter = new DataFormatter();
            for (Row row : sheet) {
                for (Cell cell : row) {
                    String cellValue = dataFormatter.formatCellValue(cell);
                    System.out.print(cellValue + "\t");
                }
                System.out.println(); // Move to the next line after each row
            }

            // Close resources
            workbook.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
