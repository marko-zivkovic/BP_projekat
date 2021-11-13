package Actions;

import Cvorovi.Prezentacija;
import gui.AboutInfo;
import gui.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class RenameAutorAction extends AbstractMyAction{
    public RenameAutorAction (){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("pen.png"));
        putValue(SHORT_DESCRIPTION, "nazovi");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       JFrame prozor = new JFrame();
       JLabel poruka = new JLabel("Unesite novo ime autora");
        prozor.setSize(300,150);
        prozor.setLayout(new BorderLayout());
        prozor.setLocationRelativeTo(null);
        prozor.setVisible(true);
        prozor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField text = new JTextField();
        JButton dugme = new JButton("Promeni");
        prozor.getContentPane().add(poruka,BorderLayout.NORTH);
        prozor.getContentPane().add(text,BorderLayout.CENTER);
        prozor.getContentPane().add(dugme,BorderLayout.SOUTH);
        poruka.setHorizontalAlignment(SwingConstants.CENTER);
        text.setHorizontalAlignment(SwingConstants.CENTER);

        dugme.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                Object p = MainWindow.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
                if( p instanceof Prezentacija) {
                    System.out.println(((Prezentacija) p).getAutor());
                    ((Prezentacija) p).setAutor(text.getText());
                    System.out.println(((Prezentacija) p).getAutor());

                }
            }
        });


    }
}
