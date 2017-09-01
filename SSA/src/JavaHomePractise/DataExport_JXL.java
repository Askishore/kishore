package JavaHomePractise;

import org.testng.annotations.Test;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.io.FileOutputStream;

public class DataExport_JXL {
  	
  @Test
  public void dataExport() throws Exception
	{
		FileOutputStream fos=new FileOutputStream("F:\\DataExport.xls");
		WritableWorkbook wwb=Workbook.createWorkbook(fos);
		WritableSheet ws1=wwb.createSheet("Ravi",0);
		//WritableSheet ws2=wwb.createSheet("Result2",1);
		Label l1=new Label(0,0,"Selenium");
		ws1.addCell(l1);
		Label l2=new Label(1,0,"QTP");
		ws1.addCell(l2);
		Label l3=new Label(2,0,"Appium");
		ws1.addCell(l3);
		wwb.write();
		wwb.close();
	}

}
