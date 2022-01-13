package Actions;

import gui.MyImagePanel;
import gui.SlajdView;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class EditovanjeSlotaSlikaAkcija extends AbstractMyAction{
    public EditovanjeSlotaSlikaAkcija (){

        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("slike/color.png"));
        putValue(SHORT_DESCRIPTION, "Edit slota Slika");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame prozor = new JFrame();
        prozor.setSize(500,300);
        prozor.setLayout(new BorderLayout());
        prozor.setLocationRelativeTo(null);
        prozor.setVisible(true);
        prozor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        JButton save = new JButton("Save");
        JButton open = new JButton("Open");
        JToolBar dugmici = new JToolBar("open,save", JToolBar.VERTICAL);
        dugmici.add(open);
        dugmici.add(save);
        MyImagePanel slika = null;
        prozor.getContentPane().add(dugmici,BorderLayout.EAST);

        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                int r = j.showOpenDialog(null);
                if (r == JFileChooser.APPROVE_OPTION){
                    String putanjaSlike = j.getSelectedFile().getAbsolutePath();
                    slika.setSlika(putanjaSlike);
                    prozor.getContentPane().add(slika,BorderLayout.CENTER);
                    prozor.repaint();
                }
            }
        });


    }
}
