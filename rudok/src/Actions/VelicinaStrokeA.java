package Actions;

import Cvorovi.Prezentacija;
import factory.FactoryError;
import gui.MainWindow;
import gui.PrezentacijaView;
import gui.SlajdView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class VelicinaStrokeA extends AbstractMyAction{
    public VelicinaStrokeA (){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("slike/color.png"));
        putValue(SHORT_DESCRIPTION, "Debljina okvira");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame prozor = new JFrame();
        JLabel poruka = new JLabel("Ukucajte velicinu ");
        prozor.setSize(200,100);
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

                try {
                    for (SlajdView s:((PrezentacijaView) MainWindow.getInstance().getMojTabbedPane().getSelectedComponent()).getSlajdViews()){
                        s.setBs(Integer.valueOf(text.getText()));
                    }
                }
                catch(Exception ex) {
                    FactoryError.getInstance().generateError("slovo");
                }


            }
        });
    }
}
