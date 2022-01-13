package gui;

import javax.swing.*;
import java.awt.*;

public class MyImagePanel extends JPanel {
    private String slika;
    private Image img;

    public MyImagePanel() {

       // this.img = new ImageIcon(getClass().getResource(imag)).getImage();
    }

    public void setSlika(String slika) {
        this.slika = slika;
        this.img = new ImageIcon(getClass().getResource(slika)).getImage();
        this.repaint();
    }

    public void paintComponent(Graphics g) {
        g.drawImage(img, (int) (this.getSize().getWidth() - img.getWidth(null)) / 2,
                (int) (this.getSize().getHeight() - img.getHeight(null)) / 2, null);
    }
}
