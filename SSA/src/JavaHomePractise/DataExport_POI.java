package JavaHomePractise;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class DataExport_POI {
	@Test
	public void dataExport() throws Exception
	{
		FileOutputStream fos=new FileOutputStream("F:\\DataExportPOI.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook();
		XSSFSheet s=wb.createSheet("Results");
		Row r=s.createRow(0);
		r.createCell(0).setCellValue("Selenium");
		r.createCell(1).setCellValue("Appium");
		wb.write(fos);
		wb.close();
		fos.close();
	}

}
