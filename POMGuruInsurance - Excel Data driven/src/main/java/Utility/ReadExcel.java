package Utility;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

public class ReadExcel {
    public static String readExcel(int row,String columName, String fileName,String sheetName) throws IOException, InvalidFormatException {



        File file =    new File(fileName);
        FileInputStream inputStream = new FileInputStream(file);



        org.apache.poi.ss.usermodel.Workbook workbook = WorkbookFactory.create(inputStream);
        org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheet(sheetName);

        int i=0;
        int col = 0;
        for (Iterator<Cell> it = sheet.getRow(0).iterator(); it.hasNext(); i++) {
            Cell cell = it.next();
            if (columName.equals(cell.getStringCellValue())){
                col=i;
            }
            System.out.println(i + ": " + cell);
        }
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(sheet.getRow(row).getCell(col));



    }
}
