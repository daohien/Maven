package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	public static int cart_col_image = 0;
	public static int cart_col_title = 1;
	public static int cart_col_price = 2;
	public static int cart_col_delete = 3;
	public static int cart_row_start = 1;
	public String ReadDataAtCell(String filename, String sheetname, int irow, int icol) {
		// load file can xu ly
		File fi = new File(filename);
		FileInputStream fis;
		String output_data="";
		try {
			fis = new FileInputStream(fi);
			// create a workbook from file input stream
			
			Workbook wb = new XSSFWorkbook(fis);

			Sheet sh = wb.getSheet(sheetname); // by name

			Row rw = sh.getRow(irow);
			if(rw!=null) {
				Cell cell = rw.getCell(icol);
				if(cell!=null) {
					int style = cell.getCellType(); // get ve format cot
					if (style == 0) {
						output_data = "" + cell.getNumericCellValue(); // get dang number va ep kieu qua chuoi
					} else if (style == 1) {
						output_data = ""+ cell.getRichStringCellValue();
					}
					
				}
			}

			wb.close();
			fis.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output_data;
	}

}
