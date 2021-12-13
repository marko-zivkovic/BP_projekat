package Cvorovi;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Enumeration;

public class Slajd implements TreeNode {
    private String name;
    private Integer br;
    private ArrayList<Slot> slotovi = new ArrayList<Slot>();



    public Slajd (String Name) {
        name=Name;

    }


    public String toString(){
        return name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public TreeNode getChildAt(int arg0) {
        return null;
    }
    public int getChildCount() {
        return 0;
    }
    public TreeNode getParent() {
        return null;
    }
    public int getIndex(TreeNode arg0) {
        return -1;
    }
    public boolean getAllowsChildren() {
        return false;
    }
    public boolean isLeaf() {
        return true;
    }
    public Enumeration children() {
        return null;
    }
    public Integer getBr() {
        return br;
    }
    public void setBr(Integer br) {
        this.br = br;
    }

    public void addSlot (Slot s){
        slotovi.add(s);
    }

    public ArrayList<Slot> getSlotovi() {
        return slotovi;
    }
}
