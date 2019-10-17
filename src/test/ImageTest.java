package test;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
class ImageTest {
    @Test
     void test(){
        try {
            BufferedImage image = ImageIO.read(new File("E:\\ideaWork\\tank\\src\\images\\bulletD.gif"));
            assertNotNull(image);

            BufferedImage image1 = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
            assertNotNull(image1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // fail("1111");
     }
}