package mainPackage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainFrame extends JFrame {


    /**
     * Выделяем память для элементов интерфейса(кнопки, панель с узображением, шрифт)
     */
    private JButton buttonOpen;
    private JButton buttonExit;
    private Font font;
    private ImagePanel panel;
    private ArrayList listButtons;
    Dimension sSize;
    File file;

    public MainFrame() {

        /**
         * Стандартные настройки формы:
         * отключение авторасположения элементов,
         * установление размеров формы,
         * операцию при закрытии форм,
         * установление заголовка
         * */
        setLayout(null);
        setExtendedState(Frame.MAXIMIZED_BOTH);
        //setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Course Work");

        sSize = Toolkit.getDefaultToolkit().getScreenSize();
        font = new Font("Verdana", Font.BOLD, 12);
        panel = new ImagePanel();
        buttonOpen = new JButton("Открыть");
        buttonExit = new JButton("Закрыть");
        listButtons = new ArrayList();

        for (int i = 0; i < 8; i++) {
            listButtons.add(new ButtonIcon());
            settingComponent((JComponent) listButtons.get(i), sSize.width * i / 8, (int) (sSize.height / 1.3) + sSize.height / 16, sSize.width / 8, sSize.height / 9, font);
            ((JButton)listButtons.get(i)).setVisible(false);
            ((JButton)listButtons.get(i)).addActionListener(new ButtonListener(this));
        }

        settingComponent(panel, 0, 0, sSize.width, (int) (sSize.height / 1.3), font);
        settingComponent(buttonOpen, sSize.width / 4, (int) (sSize.height / 1.3), sSize.width / 4, sSize.height / 16, font);
        settingComponent(buttonExit, sSize.width / 2, (int) (sSize.height / 1.3), sSize.width / 4, sSize.height / 16, font);

        panel.setVisible(true);
        buttonOpen.setVisible(true);
        buttonExit.setVisible(true);

        buttonExit.addActionListener(new ButtonListener(this));
        buttonOpen.addActionListener(new ButtonListener(this));
        setVisible(true);
    }

    public void open() {
        file = null;
        JFileChooser fileopen = new JFileChooser();
        int ret = fileopen.showDialog(this, "Открыть файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            file = fileopen.getSelectedFile();
        }

        try {
            if (file != null) {
                panel.setImage(ImageIO.read(file));
                changeButtons();
            }
        } catch (IOException e) {
            System.out.println("IOException");
        }

        panel.repaint();
        panel.revalidate();
    }

    public void openClosedImage(JButton button) {
        panel.setImage(((Image)button.getIcon()));
        panel.repaint();
        panel.revalidate();
    }

    public void settingComponent(JComponent component, int x, int y, int width, int height, Font font) {
        component.setBounds(x, y, width, height);
        component.setFont(font);
        add(component);
    }

    public JButton getButtonOpen() {
        return buttonOpen;
    }

    public JButton getButtonExit() {
        return buttonExit;
    }

    public void changeButtons() {
        if (file != null) {
            listButtons.remove(0);
            listButtons.add(new ButtonIcon());
            for (int i = 0; i < 8; i++) {
                settingComponent((JComponent) listButtons.get(i), sSize.width * i / 8, (int) (sSize.height / 1.3) + sSize.height / 16, sSize.width / 8, sSize.height / 9, font);
            }
            ((ButtonIcon)listButtons.get(listButtons.size()-1)).setPicture(new ImageIcon(file.getPath()));
            ((ButtonIcon) listButtons.get(listButtons.size()-1)).addActionListener(new ButtonListener(this));
            ((JComponent)listButtons.get(listButtons.size()-1)).setVisible(true);
        }
    }
}
