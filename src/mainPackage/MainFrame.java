package mainPackage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

//форма, на которой распологаются все элементы интерфейса
class MainFrame extends JFrame {

    //выделили память под элементы интерфейса, файл, шрифт
    private JButton buttonOpen;
    private JButton buttonExit;
    private Font font;
    private ImagePanel panel;
    private ArrayList listButtons;
    private Dimension sSize;
    private File file;


    //конструктор, в котором происходит инициализация элементов формы, присвоение нужных параметров, таких как
    //расположение, шрифт, размер, видимость, так же добавляем кнопкам обработчики событий
    MainFrame() {

        //метод для отключения авторасположения элементов на панели
        setLayout(null);


        //растягиваем форму на максимум
        setExtendedState(Frame.MAXIMIZED_BOTH);

        //метод для завершения программы при закрытии формы
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //заголовок формы
        setTitle("Course Work");

        //инициализация элементов формы, шрифта, списка с кнопками(у которых иконки)
        sSize = Toolkit.getDefaultToolkit().getScreenSize();
        font = new Font("Verdana", Font.BOLD, 12);
        panel = new ImagePanel();
        buttonOpen = new JButton("Открыть");
        buttonExit = new JButton("Закрыть");
        listButtons = new ArrayList();

        //добавление свойств элементам интерфейса
        for (int i = 0; i < 8; i++) {
            listButtons.add(new ButtonIcon());
            settingComponent((JComponent) listButtons.get(i), sSize.width * i / 8, (int) (sSize.height / 1.3) + sSize.height / 16, sSize.width / 8, sSize.height / 9, font);
            ((ButtonIcon)listButtons.get(i)).setVisible(false);
            ((ButtonIcon)listButtons.get(i)).addActionListener(new ButtonListener(this));
        }
        settingComponent(panel, 0, 0, sSize.width, (int) (sSize.height / 1.3), font);
        settingComponent(buttonOpen, sSize.width / 4, (int) (sSize.height / 1.3), sSize.width / 4, sSize.height / 16, font);
        settingComponent(buttonExit, sSize.width / 2, (int) (sSize.height / 1.3), sSize.width / 4, sSize.height / 16, font);

        //делаем панельку, кнопку выход и открыть видимыми
        panel.setVisible(true);
        buttonOpen.setVisible(true);
        buttonExit.setVisible(true);

        //добавляем обработчики событий для кнопок
        buttonExit.addActionListener(new ButtonListener(this));
        buttonOpen.addActionListener(new ButtonListener(this));

        //делаем видимой форму
        setVisible(true);

        //форму нельзя ресайзить(изменять размеры)
        setResizable(false);
    }

    //метод для задания свойств, таких как шрифт, расположение, размер для элементов формы
    private void settingComponent(JComponent component, int x, int y, int width, int height, Font font) {
        component.setBounds(x, y, width, height);
        component.setFont(font);
        add(component);
    }

    //метод, который срабатывает при нажатии на кнопку Открыть
    void open() {

        file = null;

        //чтобы выбрать файл создаем JFileChooser
        JFileChooser fileopen = new JFileChooser();
        int ret = fileopen.showDialog(this, "Открыть файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            file = fileopen.getSelectedFile();
        }
        try {
            //если файл не пустой и имеет нужное расширение, задаем панельке изображение, добавляем изображение в кнопку с иконкой,
            //перерисовываем панельку
            if ((file != null)&&(validFile())) {
                panel.setImage(ImageIO.read(file));
                changeButtons();
                panel.repaint();
                panel.revalidate();
            }
        } catch (IOException e) {//отлавливаем ошибку inputoutput и выводим в консоль сообщение
            System.out.println("IOException");
        }
    }

    //метод для проверки файла на валидность(нам нужны файлы с форматом изображения)
    private boolean validFile() {

        String filePath = file.getPath();
        return filePath.contains(".bmp") || filePath.contains(".gif") || filePath.contains(".jpeg") || filePath.contains(".png") || filePath.contains(".jpg");
    }

    //метод в котором происходит смена кнопок(с иконками) в списке при открытии нового файла с изображением
    private void changeButtons() throws IOException {

        if (file != null) {

            //удаляем первый элемент списка
            listButtons.remove(0);

            //добавляем в конец списка новую кнопку
            listButtons.add(new ButtonIcon());

            //переприсваиваем всем кнопкам стили(в данном случае важно расположение)
            for (int i = 0; i < 8; i++) {
                settingComponent((JComponent) listButtons.get(i), sSize.width * i / 8, (int) (sSize.height / 1.3) + sSize.height / 16, sSize.width / 8, sSize.height / 9, font);
            }

            //добавляем в последнюю в списке кнопку иконку, обработчик события и делаем видимой
            ((ButtonIcon)listButtons.get(listButtons.size()-1)).setPicture(file);
            ((ButtonIcon) listButtons.get(listButtons.size()-1)).addActionListener(new ButtonListener(this));
            ((JComponent)listButtons.get(listButtons.size()-1)).setVisible(true);
        }
    }

    //метод, который срабатываем при нажатии на кнопку с иконкой(открывается картинка)
    void openClosedImage(ButtonIcon button) throws IOException {

        //присваиваем панельке изображение файла из кнопки
        panel.setImage(ImageIO.read(button.getFile()));

        //перерисовываем панельку
        panel.repaint();
        panel.revalidate();
    }

    //два геттера(методы для получения кнопок
    JButton getButtonOpen() {
        return buttonOpen;
    }

    JButton getButtonExit() {
        return buttonExit;
    }
}
