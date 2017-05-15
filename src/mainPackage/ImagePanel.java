package mainPackage;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

//класс для панели с изображением
public class ImagePanel extends JPanel {

    //выделили память под изображение
    private Image image;

    //конструктор, в котором задаем цвет фона, границы и видимость
    ImagePanel() {

        //метод для отключения авторасположения элементов на панели
        setLayout(null);

        setBackground(Color.LIGHT_GRAY);
        setBorder(new LineBorder(Color.BLACK, 5));
        setVisible(true);
    }

    //переопределили метод painComponent для того чтобы отрисовывать изображение на панельке
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {

            //В классе Settings вызываем метод для изменения размеров изображения(чтоб вы выходило за границы формы
            Settings.imageSettings(image, this);

            //отрисовка изображения
            g.drawImage(image, getWidth() / 2 - Settings.ImageSize.imageWidth / 2, 0, Settings.ImageSize.imageWidth, Settings.ImageSize.imageHeight, null);
        }
    }

    //метод для инициализации изображения на панельке(сеттер)
    void setImage(Image image) {
        this.image = image;
    }
}
