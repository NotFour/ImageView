package mainPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

//Класс для обработки события нажатия на кнопки
public class ButtonListener implements ActionListener {

    //выделили память под форму
    private MainFrame frame;

    //в конструкторе инициализируем форму
    ButtonListener(MainFrame frame) {
        this.frame = frame;
    }

    //метод, в котором осуществляются действия при нажатии на кнопки
    public void actionPerformed(ActionEvent e) {

        //если нажали на кнопку выход
        if (e.getSource().equals(frame.getButtonExit())) {
            System.exit(0);
        }

        //если нажали на кнопку открыть
        if(e.getSource().equals(frame.getButtonOpen())) {
            frame.open();
        } else {//если нажали на кнопки с иконками
            try {
                frame.openClosedImage((ButtonIcon)e.getSource());
            } catch (IOException e1) {
                System.out.println("IOException");
            }
        }
    }
}
