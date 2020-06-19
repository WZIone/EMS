package dao;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

public class ExportToPDF {

	
	public void jpgToPdf(String imagePath,String pdfPath) throws IOException, DocumentException
	{
			
		BufferedImage img = ImageIO.read(new File(imagePath));			
		FileOutputStream fos = new FileOutputStream(pdfPath);			
		Document doc = new Document(null, 0, 0, 0, 0);			
		doc.setPageSize(new Rectangle(img.getWidth(), img.getHeight()));			
		Image image = Image.getInstance(imagePath);			
		PdfWriter.getInstance(doc, fos);			
		doc.open();			
		doc.add(image);			
		doc.close();
	}
}
