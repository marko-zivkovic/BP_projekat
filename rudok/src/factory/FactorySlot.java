package factory;

import Cvorovi.Prezentacija;
import Cvorovi.Projekat;
import Cvorovi.Slajd;

import javax.swing.tree.TreeNode;

public class FactorySlot {

    public FactorySlot(){}

    public TreeNode Napravi (String s){
        TreeNode slot = null;
        if(s.equals("projekat")) slot = new Projekat("new Pro");
        else if(s.equals("prezentacija")) slot = new Prezentacija("new Prez");
        else if(s.equals("slajd")) slot = new Slajd("new slajd");
        return slot;

    }
}
