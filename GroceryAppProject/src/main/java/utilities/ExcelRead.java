package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	static FileInputStream f;
	static XSSFWorkbook w;
	static XSSFSheet s;

	public static String readStringData(int i, int j) throws IOException {
		f = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\ExcelRead\\userData.xlsx");
		w = new XSSFWorkbook(f);
		s = w.getSheet("Sheet1");
		Row r = s.getRow(i);
		Cell c = r.getCell(j);
		return c.getStringCellValue();
	}

	public static String readIntegerData(int i, int j) throws IOException {
		f = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\ExcelRead\\userData.xlsx");
		w = new XSSFWorkbook(f);
		s = w.getSheet("Sheet1");
		Row r = s.getRow(i);
		Cell c = r.getCell(j);
		int v = (int) c.getNumericCellValue();
		return String.valueOf(v);
	}

}
