package dao;

import java.io.File;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

public class CreatBarCode {

	public void encode(String imgPath) {     
        int codeWidth = 3 + // start guard     
                (7 * 6) + // left bars     
                5 + // middle guard     
                (7 * 6) + // right bars     
                3; // end guard     
        codeWidth = Math.max(codeWidth, 105);  
        try {     
            BitMatrix bitMatrix = new MultiFormatWriter().encode("8754963215841",     
                    BarcodeFormat.EAN_13, codeWidth, 50, null);     
            MatrixToImageWriter     
                    .writeToFile(bitMatrix, "png", new File(imgPath));     
    
        } catch (Exception e) {     
            e.printStackTrace();     
        }     
    }     
}
