package mainPackage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

    private MainFrame frame;

    public ButtonListener(MainFrame frame) {
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(frame.getButtonExit())) {
            System.exit(0);
        }
        if(e.getSource().equals(frame.getButtonOpen())) {
            frame.open();
        } else {
            frame.openClosedImage((JButton)e.getSource());
        }
    }
}
