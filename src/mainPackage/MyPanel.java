/*package mainPackage;

import javax.swing.*;
import java.io.File;

public class MyPanel extends JPanel {*/
    /*private static final long serialVersionUID = 1L;
    private BufferedImage originalImage = null;
    private Image image = null;
    public float suSize;

    public MyPanel() {
        initComponents();
    }

    private void initComponents() {
        setLayout(null);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        try {
            image = ImageIO.read(new File("../images/image1.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void formComponentResized(java.awt.event.ComponentEvent evt) {
        int w = this.getWidth();
        int h = this.getHeight();
        if ((originalImage != null) && (w > 0) && (h > 0)) {
            image = originalImage.getScaledInstance(w, h, Image.SCALE_DEFAULT);
            this.repaint();
        }
    }

    public void paint(Graphics g) {

        if (image != null) {
            g.drawImage(image, 0, 0, null);
        }
        super.paintChildren(g);
        super.paintBorder(g);
    }


    public BufferedImage getImage() {
        return originalImage;
    }

    public void setImage(BufferedImage image) {
        this.originalImage = image;
        suSize = (float) (image.getWidth()) / (float) (image.getHeight());
        formComponentResized(null);
    }


    public void setImageFile(File iF) {
        if (iF == null) originalImage = null;
        else {
            try {
                BufferedImage bi;
                bi = ImageIO.read(iF);
                originalImage = bi;
            } catch (IOException ex) {
                System.err.println("Неудалось загрузить картинку!");
                ex.printStackTrace();
            }
            formComponentResized(null);
            suSize = (float) (originalImage.getWidth()) / (float) (originalImage.getHeight());
            repaint();
        }
    }*/
  /*  JLabel label;

    public MyPanel() {
        setLayout(null);
        label = new JLabel();
        label.setBounds(0,0,500,500);
        label.setVisible(true);
        add(label);
        File file = null;
        JFileChooser fileopen = new JFileChooser();
        int ret = fileopen.showDialog(this, "Открыть файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            file = fileopen.getSelectedFile();
        }
        label.setIcon(new ImageIcon(file.getPath()));*/

        //label.getIcon().paintIcon(new ImageIcon(file.getPath()) );
        //jLabel1.setIcon(new ImageIcon(getClass().getResource("image1.jpg")));

       /* addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                labelComponentResized(evt);
            }
        });*/
    /*}*/

   /* private void labelComponentResized(java.awt.event.ComponentEvent evt) {
        int w = this.getWidth();
        int h = this.getHeight();
            label.getIcon().getScaledInstance(w, h, Image.SCALE_DEFAULT);
            this.repaint();
    }*/
/*
}
*/
