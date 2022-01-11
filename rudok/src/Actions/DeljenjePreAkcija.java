package Actions;

import Cvorovi.Prezentacija;
import Cvorovi.Projekat;
import Cvorovi.Workspace;
import commands.AddDeviceCommand;
import factory.FactoryError;
import gui.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class DeljenjePreAkcija extends AbstractMyAction{
    public DeljenjePreAkcija (){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("slike/deli.png"));
        putValue(SHORT_DESCRIPTION, "Deljenje prezentacije");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object p = MainWindow.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
        if(p instanceof Prezentacija){
            Prezentacija prez = (Prezentacija)p;
            JFrame prozor = new JFrame();
            JLabel poruka = new JLabel("Deljenje: " + prez.getName());
            prozor.setSize(300,160);
            prozor.setLayout(new BorderLayout());
            prozor.setLocationRelativeTo(null);
            prozor.setVisible(true);
            prozor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

           Workspace w = (Workspace) MainWindow.getInstance().getWorkspaceTree().getModel().getRoot();
           JComboBox combo = new JComboBox();
           for(int i=1; i<=w.getProjectsCount(); i++){
               combo.addItem("Project " + i);
           }
            JButton dugme = new JButton("Dodaj");

            prozor.getContentPane().add(poruka,BorderLayout.NORTH);
            prozor.getContentPane().add(dugme,BorderLayout.SOUTH);
            prozor.getContentPane().add(combo,BorderLayout.CENTER);
            poruka.setHorizontalAlignment(SwingConstants.CENTER);

            dugme.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                 String ime = (String)combo.getSelectedItem();
                 for(Projekat p : w.getProjects()){
                     if(p.getName().equals(ime))
                       {//p.addPrezentacija(prez);
                           AddDeviceCommand addDeviceCommand = new AddDeviceCommand(p,prez);
                           MainWindow.getInstance().getCommandManager().addCommand(addDeviceCommand);
                       }
                 }
                    SwingUtilities.updateComponentTreeUI(MainWindow.getInstance().getWorkspaceTree());
                }
            });

        }
        else{
            System.out.println("Selektujte prezentaciju koju zelite da delite");
        }
    }
}
