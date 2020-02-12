package com.JsonParserProject.firstProject;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;

public class DecodingBase64 {
   private BufferedImage resultImage;

    public BufferedImage getResultImage() {
        return resultImage;
    }

    public BufferedImage decoding(String value){
        byte[] decoded = Base64.getDecoder().decode(value);

        // считываем полученный массив в объект BufferedImage
        try {
            resultImage = ImageIO.read(new ByteArrayInputStream(decoded));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  resultImage;
    }
}
