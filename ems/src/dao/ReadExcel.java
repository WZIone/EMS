package dao;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import vo.Logistics;

public class ReadExcel {
	
	public Logistics readFromExcel(File file) throws BiffException, IOException
	{
		Logistics log=new Logistics();
		//1:创建workbook
        Workbook workbook=Workbook.getWorkbook(file); 
        //2:获取第一个工作表sheet
        Sheet sheet=workbook.getSheet(0);
        log.setSender(sheet.getCell(0,1).getContents());
        log.setSenPhone(sheet.getCell(1,1).getContents());
        log.setSenAdd(sheet.getCell(2,1).getContents());
        log.setSenPost(sheet.getCell(3,1).getContents());
        log.setRecipient(sheet.getCell(4,1).getContents());
        log.setRecPhone(sheet.getCell(5,1).getContents());
        log.setRecAdd(sheet.getCell(6,1).getContents());
        log.setRecPoSt(sheet.getCell(7,1).getContents());
        log.setRemarks(sheet.getCell(8,1).getContents());
        log.setAmount(sheet.getCell(9,1).getContents());
        log.setProduct(sheet.getCell(10,1).getContents());     
		int i=(int)(Math.random()*900)+100; 
		SimpleDateFormat df = new SimpleDateFormat("yyyy MMdd hhmmss SSS");
		String data=df.format(new java.util.Date())+i;
		log.setTaskNO(data);
        //最后一步：关闭资源
        workbook.close();
        return log;
	}
}
