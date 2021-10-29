package gui;

import javax.swing.*;
import java.awt.*;

public class AboutInfo extends JFrame {
    JLabel jLabel = new JLabel();

    public AboutInfo(){
        jLabel.setText("Marko Zivkovic RN86");
        ImageIcon slika = new ImageIcon(getClass().getResource("profil.jpg"));
        JLabel jslika = new JLabel(slika);

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenD = tk.getScreenSize();
        int visina = screenD.height;
        int sirina = screenD.width;
        setSize(sirina/3,visina/3);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.getContentPane().add(jLabel,BorderLayout.NORTH);
        this.getContentPane().add(jslika,BorderLayout.CENTER);
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);


    }


}
