package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutils {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;
	
	static String path;
	
	public Excelutils(String path) {
		
		this.path=path;
	}

	public static int getrowcount(String sheetname) throws IOException
	{
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(sheetname);
		int rowcount=ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount ;
	}
	
	public static int getcellcount(String sheetname,int rownum) throws IOException {
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(sheetname);
		row=ws.getRow(rownum);
		int cellcount= row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount ;
	}



	public String getCellData(String sheetname, int rownum, int celnum) throws IOException {
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(sheetname);
		row=ws.getRow(rownum);
		cell=row.getCell(celnum);
		String data;
		
		try {
			DataFormatter formatter= new DataFormatter();
			data=formatter.formatCellValue(cell);
		}
		
		catch(Exception e) {
			data="";
		}
		wb.close();
		fi.close();
		return data;
	}
	
	
	

}
