package com.jpetstore.util;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.IOException;
import java.util.Arrays;

public class ExcelDataReader {

    /**
     * Reads an Excel file and returns an XSSFWorkbook instance.
     *
     * @param fileName The path to the Excel file to be read.
     * @return XSSFWorkbook representing the Excel file.
     * @throws RuntimeException If an IOException occurs while reading the file.
     */
    private static XSSFWorkbook readExcelFile(String fileName) {

        try {
            return new XSSFWorkbook(fileName);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Reads test data from an Excel sheet and returns it as a 2D Object array.
     *
     * @param fileName  The path to the Excel file.
     * @param sheetName The name of the sheet containing the test data.
     * @return A 2D Object array where each row represents a row in the Excel sheet,
     *         and each column represents a cell in that row.
     */
    public static Object[][] getData(String fileName, String sheetName) {

        XSSFSheet sheet;
        XSSFRow singleRow;

        // Get sheet
        sheet = readExcelFile(fileName).getSheet(sheetName);

        // Needed to get cell count
        singleRow = sheet.getRow(0);

        // Initialize a 2D array object
        Object[][] testData = new Object[sheet.getLastRowNum()][singleRow.getLastCellNum()];

        for (int rowCount = 1; rowCount <= sheet.getLastRowNum(); rowCount++) {

            singleRow = sheet.getRow(rowCount);

            for (int cell = 0; cell < singleRow.getLastCellNum(); cell++) {
                testData[rowCount - 1][cell] = singleRow.getCell(cell).toString();
            }
        }
        return testData;
    }


    public static void main(String[] args) {

        System.out.println(Arrays.deepToString(getData("src/test/resources/data/LoginDDTest.xlsx",
                "doLogin")));
    }
}
