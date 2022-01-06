package commands;

import Cvorovi.Prezentacija;
import Cvorovi.Projekat;
import Cvorovi.Slajd;
import Cvorovi.Workspace;
import factory.FactorySlot;
import gui.MainWindow;

import javax.swing.*;
import javax.swing.tree.TreeNode;

public class AddDeviceCommand extends AbstractCommand{
    String ime;
    Object o;
    TreeNode slot = null;
    FactorySlot fs = new FactorySlot();

    public AddDeviceCommand (String slot,Object ob){
        this.ime = slot;
        this.o = ob;

    }
    @Override
    public void doCommand() {
        if(slot == null){
            slot = fs.Napravi(ime);
        }

        if(ime.equals("projekat")){((Workspace)o).addProject((Projekat) slot);}
        else if(ime.equals("prezentacija")){((Projekat)o).addPrezentacija((Prezentacija)slot);}
        else if(ime.equals(("slajd"))){((Prezentacija)o).addSlajd((Slajd) slot);}
        SwingUtilities.updateComponentTreeUI(MainWindow.getInstance().getWorkspaceTree());

    }

    @Override
    public void undoCommand() {
        if(ime.equals("projekat")){((Workspace)o).brisanje((Projekat) slot);}
        else if(ime.equals("prezentacija")){((Projekat)o).brisanje((Prezentacija)slot);}
        else if(ime.equals(("slajd"))){((Prezentacija)o).brisanje((Slajd) slot);}
        SwingUtilities.updateComponentTreeUI(MainWindow.getInstance().getWorkspaceTree());

    }
}
