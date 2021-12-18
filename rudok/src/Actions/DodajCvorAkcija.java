package Actions;

import Cvorovi.Prezentacija;
import Cvorovi.Projekat;
import Cvorovi.Slajd;
import Cvorovi.Workspace;
import gui.AboutInfo;
import gui.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;

public class DodajCvorAkcija extends AbstractMyAction{

    public DodajCvorAkcija(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("slike/plus.png"));
        putValue(SHORT_DESCRIPTION, "dodaj cvor 1");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object p = MainWindow.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
        if (p  instanceof Workspace) {
            Projekat pp = new Projekat("New pro");
            ((Workspace)p).addProject(pp);
            SwingUtilities.updateComponentTreeUI(MainWindow.getInstance().getWorkspaceTree());


        }else if(p instanceof Projekat){
            Prezentacija p1 = new Prezentacija("new prez");
            ((Projekat)p).addPrezentacija(p1);
            SwingUtilities.updateComponentTreeUI(MainWindow.getInstance().getWorkspaceTree());

        }
        else if(p instanceof Prezentacija){
            Slajd p2 = new Slajd("new slajd");
            ((Prezentacija)p).addSlajd(p2);
            SwingUtilities.updateComponentTreeUI(MainWindow.getInstance().getWorkspaceTree());
            //((Prezentacija) p).notifySubscribers(p2);

        }

    }
}
