/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.Arquidalgos.usuario.logic.ejb;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author JoseMiguel
 */
public class GeneradorQR {
    private static final String FORMATO_IMAGEN = "JPG";
    private static final int ancho = 500;
    private static final int alto = 500;
    
    public static void generarCodigoQR ( String datos, File file )
    {
        try {
            BitMatrix bm;
            Writer writer = new QRCodeWriter(); 

            bm = writer.encode(datos, BarcodeFormat.QR_CODE, ancho, alto);
            BufferedImage image = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);
            for (int y = 0; y < ancho; y++) {
                for (int x = 0; x < alto; x++) {
                    int grayValue = (bm.get(x, y) ? 0 : 1) & 0xff;
                    image.setRGB(x, y, (grayValue == 0 ? 0 : 0xFFFFFF));
                }
            }
            FileOutputStream qrCode = new FileOutputStream(file);
            ImageIO.write(image, FORMATO_IMAGEN, qrCode); 
            
            qrCode.close(); 
            
            //Desktop d = Desktop.getDesktop();
            //d.open(file); 
            
        } catch (WriterException ex) {
            Logger.getLogger(GeneradorQR.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GeneradorQR.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GeneradorQR.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
