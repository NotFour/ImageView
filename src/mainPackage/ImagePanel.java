package mainPackage;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ImagePanel extends JPanel {

    private Image image;

    public ImagePanel() {
        setLayout(null);

        /**
         * Цвет фона и границы для обозначения области просмотра изображений
         * */
        setBackground(Color.LIGHT_GRAY);
        setBorder(new LineBorder(Color.BLACK, 5));

        setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            Settings.imageSettings(image, this);
            g.drawImage(image, getWidth() / 2 - Settings.ImageSize.imageWidth / 2, 0, Settings.ImageSize.imageWidth, Settings.ImageSize.imageHeight, null);
        }
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
    }



}
