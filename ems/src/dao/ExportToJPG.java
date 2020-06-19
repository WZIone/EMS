package dao;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

import com.itextpdf.text.DocumentException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import jxl.read.biff.BiffException;
import vo.Logistics;

public class ExportToJPG {
	int width=700;//图片宽度
	int height=300;//图片高度

    // 创建JPG文件到指定路径下
    public void createJpg(String path,BufferedImage image) {
        try{
            FileOutputStream fos = new FileOutputStream(path);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(bos);
            encoder.encode(image);
            bos.close();
            fos.close();

        }catch(FileNotFoundException fnfe){
            System.out.println(fnfe);
        }catch(IOException ioe){
            System.out.println(ioe);
        }
    }
    
    public void graphicsGeneration(Logistics log) throws FileNotFoundException, IOException
    {
    	BufferedImage image1 = ImageIO.read(new FileInputStream("D:\\Java\\eclipse-workspace\\Eclipse\\ems\\条形码.png"));
    	int imageWidth = 1000;// 图片宽度  
        int imageHeight = 800;// 图片高度  
        BufferedImage image = new BufferedImage(imageWidth, imageHeight,  BufferedImage.TYPE_INT_RGB); 
        Graphics g = image.getGraphics();  
        g.setColor(Color.white);  
        g.fillRect(0, 0, imageWidth, imageHeight); //填充背景颜色 
        g.setColor(Color.black);
        //画出长为800，宽为400的矩形框
        g.drawRect(100,100,800,400); 
        g.drawLine(100,200,900,200);
        g.drawLine(100,300,900,300);
        g.drawLine(100,400,900,400);
        g.drawLine(500,300,500,400);
        g.setFont(new Font("宋体", Font.BOLD, 60));   
        g.drawString("EMS物流", 180, 95);
        g.setFont(new Font("宋体", Font.BOLD, 25));  
        g.drawString("订单号：", 480, 95);
        g.drawString(log.getTaskNO(), 580, 95);
        g.drawString("寄件人姓名：", 120, 130);
        g.drawString(log.getSender(), 280, 130);
        g.drawString("   电话：", 380, 130);
        g.drawString(log.getSenPhone(), 500, 130);
        g.drawString("地址：", 120, 160);
        g.drawString(log.getSenAdd(), 180, 160);
        g.drawString("邮编：", 120, 190);
        g.drawString(log.getSenPost(), 200, 190);
        g.drawString("收件人姓名：", 120, 230);
        g.drawString(log.getRecipient(),280, 230);
        g.drawString("   电话：", 380, 230);
        g.drawString(log.getRecPhone(),500, 230);
        g.drawString("地址：", 120, 260);
        g.drawString(log.getRecAdd(), 180, 260);
        g.drawString("邮编：", 120, 290);
        g.drawString(log.getRecPoSt(), 200, 290);
        g.setFont(new Font("宋体", Font.BOLD, 22)); 
        g.drawString("收件人/代收件人：", 520, 330);
        g.drawString("签收时间：        年   月   日", 520, 380);
        g.drawString("内件品名：", 120, 330);
        g.drawString(log.getProduct(), 230, 330);
        g.drawString("数量：", 350, 330);
        g.drawString(log.getRemarks(), 420, 330);
        g.drawString("重量：", 140, 380);
        g.drawString(log.getAmount(), 210, 380);
        g.setFont(new Font("宋体", Font.BOLD, 40)); 
        g.drawString("订单号：", 120, 470);
        g.drawString(log.getTaskNO(), 270, 470);
        g.drawImage(image1,570, 15, 350, 60, null); 
        createJpg(".//物流面单.jpg", image);


    }
	public static void main(String[] args) throws BiffException, IOException, DocumentException {
		// TODO Auto-generated method stub
		String imgPath = "./条形码.png";     
		File file=new File("./订单文件.xls");
		String imagePath = "./物流面单.jpg";			
		String pdfPath = "./物流面单.pdf";
		Logistics logistics=new ReadExcel().readFromExcel(file);           
        new CreatBarCode().encode(imgPath);
		new ExportToJPG().graphicsGeneration(logistics);
		new ExportToPDF().jpgToPdf(imagePath, pdfPath);
		System.out.println("图片和PDF生成成功！");
	}

}
