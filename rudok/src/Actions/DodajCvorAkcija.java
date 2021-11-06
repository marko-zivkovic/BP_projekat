package Actions;

import Cvorovi.Prezentacija;
import Cvorovi.Projekat;
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
        putValue(SMALL_ICON, loadIcon("iinfo.png"));
        putValue(SHORT_DESCRIPTION, "info");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object p = MainWindow.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
        if (p  instanceof Workspace) {
            Projekat pp = new Projekat("New pro");
            ((Workspace)p).addProject(pp);
            SwingUtilities.updateComponentTreeUI(MainWindow.getInstance().getWorkspaceTree());


        }else if(p instanceof Projekat){
            Prezentacija pp = new Prezentacija("Prez1");
            ((Projekat)p).addPrezentacija(pp);
            SwingUtilities.updateComponentTreeUI(MainWindow.getInstance().getWorkspaceTree());

        }

    }
}
