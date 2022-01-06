package Actions;

import Cvorovi.Prezentacija;
import Cvorovi.Projekat;
import Cvorovi.Slajd;
import Cvorovi.Workspace;
import commands.AddDeviceCommand;
import factory.FactorySlot;
import gui.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class DodajCvorAkcijaFactory extends AbstractMyAction{
    public DodajCvorAkcijaFactory(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("slike/plus.png"));
        putValue(SHORT_DESCRIPTION, "dodaj cvor Factory");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object p = MainWindow.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
        FactorySlot fs = new FactorySlot();

        if (p  instanceof Workspace) {
            //Projekat pp = (Projekat) fs.Napravi("projekat");
            AddDeviceCommand addDeviceCommand = new AddDeviceCommand("projekat",p);
            MainWindow.getInstance().getCommandManager().addCommand(addDeviceCommand);
            //((Workspace)p).addProject(pp);
            //SwingUtilities.updateComponentTreeUI(MainWindow.getInstance().getWorkspaceTree());


        }else if(p instanceof Projekat){
//            Prezentacija p1 = (Prezentacija) fs.Napravi("prezentacija");
//            ((Projekat)p).addPrezentacija(p1);
//            SwingUtilities.updateComponentTreeUI(MainWindow.getInstance().getWorkspaceTree());
            AddDeviceCommand addDeviceCommand = new AddDeviceCommand("prezentacija",p);
            MainWindow.getInstance().getCommandManager().addCommand(addDeviceCommand);

        }
        else if(p instanceof Prezentacija){
//            Slajd p2 = (Slajd) fs.Napravi("slajd");
//            ((Prezentacija)p).addSlajd(p2);
//            SwingUtilities.updateComponentTreeUI(MainWindow.getInstance().getWorkspaceTree());
            //((Prezentacija) p).notifySubscribers(p2);
            AddDeviceCommand addDeviceCommand = new AddDeviceCommand("slajd",p);
            MainWindow.getInstance().getCommandManager().addCommand(addDeviceCommand);

        }

    }
}
