package mainPackage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

//класс для кнопки с иконкой
class ButtonIcon extends JButton {

    private File file;

    //метод для вставки изображения
    void setPicture(File file) throws IOException {
        this.file = file;

        Image image = ImageIO.read(file);
        Settings.imageSettings(image, this);
        BufferedImage bufferedImage = (BufferedImage) image;
        BufferedImage resizedImage = resizeImage(bufferedImage, Settings.ImageSize.imageWidth, Settings.ImageSize.imageHeight);
        setIcon(new ImageIcon(resizedImage));
    }

    //метод для изменения размера изображения
    private static BufferedImage resizeImage(BufferedImage image, int width, int height) {
        ColorModel cm = image.getColorModel();
        WritableRaster raster = cm.createCompatibleWritableRaster(width, height);
        boolean isRasterPremultiplied = cm.isAlphaPremultiplied();
        BufferedImage target = new BufferedImage(cm, raster, isRasterPremultiplied, null);
        Graphics2D g2 = target.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        double scalex = (double) target.getWidth() / image.getWidth();
        double scaley = (double) target.getHeight() / image.getHeight();
        AffineTransform xform = AffineTransform.getScaleInstance(scalex, scaley);
        g2.drawRenderedImage(image, xform);
        g2.dispose();
        return target;
    }

    //метод для получения файла(геттер)
    File getFile() {
        return file;
    }

}