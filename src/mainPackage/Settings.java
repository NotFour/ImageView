package mainPackage;

import javax.swing.*;
import java.awt.*;

public class Settings {

    static class ImageSize {

        static int imageWidth;
        static int imageHeight;
    }

    public static void imageSettings(Image image, JComponent component) {
        int imageWidth = image.getWidth(null);
        int imageHeight = image.getHeight(null);
        double coeff;
        if (imageWidth > component.getWidth()) {
            coeff = (double) imageWidth / component.getWidth();
            imageWidth = (int) ((double) imageWidth / coeff);
            imageHeight = (int) ((double) imageHeight / coeff);
        }
        ;
        if (imageHeight > component.getHeight()) {
            coeff = (double) imageHeight / component.getHeight();
            imageWidth = (int) ((double) imageWidth / coeff);
            imageHeight = (int) ((double) imageHeight / coeff);
        }
        ImageSize.imageWidth = imageWidth;
        ImageSize.imageHeight = imageHeight;
        //меняем изображение
    }
}