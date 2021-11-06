package Cvorovi;

import sun.reflect.generics.tree.Tree;

import javax.swing.*;
import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Enumeration;

public class Prezentacija implements TreeNode {
    private ArrayList<Slajd> slajdovi = new ArrayList<Slajd>();
    private String name;
    private String autor;
    private String slikatema;

    public Prezentacija(String projectName) {
        this.name=projectName;
        slikatema= new String("slika.jpg");



    }


    public void addSlajd(Slajd slajd){
        slajdovi.add(slajd);
        slajd.setName( this.name+" - Slajd  - Grafički editor: "+String.valueOf(slajdovi.size()));

    }

    public String toString(){
        return name;
    }
    public Slajd getSlajd(int index) {
        return slajdovi.get(index);
    }

    public int getSlajdIndex(Slajd slajd) {
        return slajdovi.indexOf(slajd);
    }

    public int getSlajdCount() {
        return slajdovi.size();
    }
    public boolean isLeaf() {
        return false;
    }

    public void setName(String name){
        this.name=name;
    }


    public TreeNode getChildAt(int arg0) {
        return getSlajd(arg0);
    }


    public int getChildCount() {
        return getSlajdCount();
    }


    public TreeNode getParent() {
        // TODO Auto-generated method stub
        return null;
    }


    public int getIndex(TreeNode arg0) {
        return getSlajdIndex((Slajd)arg0);
    }


    public boolean getAllowsChildren() {
        // TODO Auto-generated method stub
        return false;
    }


    public Enumeration children() {
        // TODO Auto-generated method stub
        return (Enumeration) slajdovi;
    }
}
