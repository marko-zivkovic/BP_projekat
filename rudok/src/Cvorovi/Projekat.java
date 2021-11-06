package Cvorovi;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Enumeration;

public class Projekat implements TreeNode{
    private ArrayList<Prezentacija> prezentacije = new ArrayList<Prezentacija>();
    private String name;

    public Projekat(String projectName) {
        this.name=projectName;

    }


    public void addPrezentacija(Prezentacija prezentacija){
        prezentacije.add(prezentacija);
        prezentacija.setName( this.name+" - Prezentacija  - Grafički editor: "+String.valueOf(prezentacije.size()));

    }

    public String toString(){
        return name;
    }
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


    public Enumeration children() {
        // TODO Auto-generated method stub
        return (Enumeration) prezentacije;
    }
}
