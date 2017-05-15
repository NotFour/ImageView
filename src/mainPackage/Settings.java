package mainPackage;

import javax.swing.*;
import java.awt.*;

//Класс с настройками(внутри встроенный класс для хранения ширины и высоты картинки) и метод для изменения
//размеров картинки
class Settings {

    //структура для хранения параметров картинки(ширина, высота)
    static class ImageSize {
        static int imageWidth;
        static int imageHeight;
    }

    //метод для изменения размеров картинки
    static void imageSettings(Image image, JComponent component) {

        //сохраняем в переменные ширину, высоту картинки
        int imageWidth = image.getWidth(null);
        int imageHeight = image.getHeight(null);

        //выделили место под переменную(коеффициент)
        double coeff;

        //если ширина картинки больше чем ширина компонента, то меняем коеффициент и согласно ему меняем
        //ширину и высоту картинки
        if (imageWidth > component.getWidth()) {
            coeff = (double) imageWidth / component.getWidth();
            imageWidth = (int) ((double) imageWidth / coeff);
            imageHeight = (int) ((double) imageHeight / coeff);
        }
        //если высота картинки больше чем высота компонента, то меняем коеффициент и согласно ему меняем
        //ширину и высоту картинки
        if (imageHeight > component.getHeight()) {
            coeff = (double) imageHeight / component.getHeight();
            imageWidth = (int) ((double) imageWidth / coeff);
            imageHeight = (int) ((double) imageHeight / coeff);
        }

        //сохраняем полученную высоту и ширину картинки в нашей структуре
        ImageSize.imageWidth = imageWidth;
        ImageSize.imageHeight = imageHeight;
    }
}