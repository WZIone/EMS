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
	int width=700;//ͼƬ���
	int height=300;//ͼƬ�߶�

    // ����JPG�ļ���ָ��·����
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
    	BufferedImage image1 = ImageIO.read(new FileInputStream("D:\\Java\\eclipse-workspace\\Eclipse\\ems\\������.png"));
    	int imageWidth = 1000;// ͼƬ���  
        int imageHeight = 800;// ͼƬ�߶�  
        BufferedImage image = new BufferedImage(imageWidth, imageHeight,  BufferedImage.TYPE_INT_RGB); 
        Graphics g = image.getGraphics();  
        g.setColor(Color.white);  
        g.fillRect(0, 0, imageWidth, imageHeight); //��䱳����ɫ 
        g.setColor(Color.black);
        //������Ϊ800����Ϊ400�ľ��ο�
        g.drawRect(100,100,800,400); 
        g.drawLine(100,200,900,200);
        g.drawLine(100,300,900,300);
        g.drawLine(100,400,900,400);
        g.drawLine(500,300,500,400);
        g.setFont(new Font("����", Font.BOLD, 60));   
        g.drawString("EMS����", 180, 95);
        g.setFont(new Font("����", Font.BOLD, 25));  
        g.drawString("�����ţ�", 480, 95);
        g.drawString(log.getTaskNO(), 580, 95);
        g.drawString("�ļ���������", 120, 130);
        g.drawString(log.getSender(), 280, 130);
        g.drawString("   �绰��", 380, 130);
        g.drawString(log.getSenPhone(), 500, 130);
        g.drawString("��ַ��", 120, 160);
        g.drawString(log.getSenAdd(), 180, 160);
        g.drawString("�ʱࣺ", 120, 190);
        g.drawString(log.getSenPost(), 200, 190);
        g.drawString("�ռ���������", 120, 230);
        g.drawString(log.getRecipient(),280, 230);
        g.drawString("   �绰��", 380, 230);
        g.drawString(log.getRecPhone(),500, 230);
        g.drawString("��ַ��", 120, 260);
        g.drawString(log.getRecAdd(), 180, 260);
        g.drawString("�ʱࣺ", 120, 290);
        g.drawString(log.getRecPoSt(), 200, 290);
        g.setFont(new Font("����", Font.BOLD, 22)); 
        g.drawString("�ռ���/���ռ��ˣ�", 520, 330);
        g.drawString("ǩ��ʱ�䣺        ��   ��   ��", 520, 380);
        g.drawString("�ڼ�Ʒ����", 120, 330);
        g.drawString(log.getProduct(), 230, 330);
        g.drawString("������", 350, 330);
        g.drawString(log.getRemarks(), 420, 330);
        g.drawString("������", 140, 380);
        g.drawString(log.getAmount(), 210, 380);
        g.setFont(new Font("����", Font.BOLD, 40)); 
        g.drawString("�����ţ�", 120, 470);
        g.drawString(log.getTaskNO(), 270, 470);
        g.drawImage(image1,570, 15, 350, 60, null); 
        createJpg(".//�����浥.jpg", image);


    }
	public static void main(String[] args) throws BiffException, IOException, DocumentException {
		// TODO Auto-generated method stub
		String imgPath = "./������.png";     
		File file=new File("./�����ļ�.xls");
		String imagePath = "./�����浥.jpg";			
		String pdfPath = "./�����浥.pdf";
		Logistics logistics=new ReadExcel().readFromExcel(file);           
        new CreatBarCode().encode(imgPath);
		new ExportToJPG().graphicsGeneration(logistics);
		new ExportToPDF().jpgToPdf(imagePath, pdfPath);
		System.out.println("ͼƬ��PDF���ɳɹ���");
	}

}
