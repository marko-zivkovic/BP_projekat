package Cvorovi;

import Observer.ISubscriber;
import gui.MainWindow;

import javax.swing.*;
import javax.swing.tree.TreeNode;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;

public class Projekat implements TreeNode, ISubscriber, Serializable {
    private ArrayList<Prezentacija> prezentacije = new ArrayList<Prezentacija>();
    private String name;
    private transient boolean promena;
    private File projekatFile;
    private boolean kliknut = false;

    public Projekat(String projectName) {
        this.name=projectName;
        this.promena = false;
        this.projekatFile = null;

    }


    public void addPrezentacija(Prezentacija prezentacija){
        prezentacija.addSubscriber(this);
        prezentacije.add(prezentacija);
        prezentacija.setName("Prezentacija "+String.valueOf(prezentacije.size()));
        setChanged(true);

    }

    public String toString(){return ((promena?"* ":"")+ name);}
    public Prezentacija getPrezentacija(int index) {
        return prezentacije.get(index);
    }

    public int getPrezentacijaIndex(Prezentacija prezentacija) {
        return prezentacije.indexOf(prezentacija);
    }

    public int getPrezentacijaCount() {
        return prezentacije.size();
    }
    public boolean isLeaf() {
        return false;
    }

    public void setName(String name){
        this.name=name;
    }


    public TreeNode getChildAt(int arg0) {
        return getPrezentacija(arg0);
    }

    public ArrayList<Prezentacija> getPrezentacije() {
        return prezentacije;
    }

    public int getChildCount() {
        return getPrezentacijaCount();
    }


    public TreeNode getParent() {
        // TODO Auto-generated method stub
        return null;
    }


    public int getIndex(TreeNode arg0) {
        return getPrezentacijaIndex((Prezentacija)arg0);
    }


    public boolean getAllowsChildren() {
        // TODO Auto-generated method stub
        return false;
    }

    public String getName() {
        return name;
    }
    public void brisanje (Prezentacija prezentacija){
        prezentacije.remove(prezentacija);
        prezentacija.notifySubscribers("odstupi");

    }

    public Enumeration children() {
        // TODO Auto-generated method stub
        return (Enumeration) prezentacije;
    }
    public boolean isChanged(){return promena;}
    public void setChanged(boolean changed) {
        if (this.promena!=changed){
            this.promena=changed;
            SwingUtilities.updateComponentTreeUI(MainWindow.getInstance().getWorkspaceTree());
        }
    }

    @Override
    public void update(Object notification) {
        if(notification instanceof String && notification.equals("promenapro"))
        {setChanged(true);}
    }

    public File getProjekatFile() {
        return projekatFile;
    }

    public void setProjekatFile(File projekatFile) {
        this.projekatFile = projekatFile;
    }

    public boolean isKliknut() {
        return kliknut;
    }
    public void setKliknut(boolean kliknut) {
        this.kliknut = kliknut;
    }
}
