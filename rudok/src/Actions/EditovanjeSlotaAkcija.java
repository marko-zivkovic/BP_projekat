package Actions;

import gui.MainWindow;
import javafx.scene.layout.HBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class EditovanjeSlotaAkcija extends AbstractMyAction{
    public EditovanjeSlotaAkcija (){

        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("slike/color.png"));
        putValue(SHORT_DESCRIPTION, "Edit slota Text");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame prozor = new JFrame();
        prozor.setSize(500,300);
        prozor.setLayout(new BorderLayout());
        prozor.setLocationRelativeTo(null);
        prozor.setVisible(true);
        prozor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextPane text = new JTextPane();
        JButton bulian = new JButton("B");
        JButton italik = new JButton("i");
        JButton underline = new JButton("U");
        JButton save1 = new JButton("save");
        JToolBar dugmici = new JToolBar();
        dugmici.add(bulian);
        dugmici.add(italik);
        dugmici.add(underline);
        dugmici.add(save1);
        prozor.getContentPane().add(text,BorderLayout.CENTER);
        prozor.getContentPane().add(dugmici,BorderLayout.NORTH);

        save1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tekst = text.getText();
                MainWindow.getInstance().getSlotComponent().setText(tekst);
            }
        });


    }
}
