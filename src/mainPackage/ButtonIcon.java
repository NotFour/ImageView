package mainPackage;

import sun.awt.image.ToolkitImage;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;

public class ButtonIcon extends JButton {

    public void setPicture(ImageIcon icon) {
        Image image = icon.getImage();
        Settings.imageSettings(image, this);
        ToolkitImage toolkitImage = (ToolkitImage) image;
        BufferedImage bufferedImage = toolkitImage.getBufferedImage();
        BufferedImage resizedImage = resizeImage(bufferedImage, Settings.ImageSize.imageWidth, Settings.ImageSize.imageHeight);
        setIcon(new ImageIcon(resizedImage));
    }


    public static BufferedImage resizeImage(BufferedImage image, int width, int height) {

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
}