package Cvorovi;

import Observer.IPublisher;
import Observer.ISubscriber;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class Slajd implements TreeNode, IPublisher {
    private String name;
    private Integer br;
    private ArrayList<Slot> slotovi = new ArrayList<Slot>();
    List<ISubscriber> subscribers;



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
        notifySubscribers(s);
    }

    public ArrayList<Slot> getSlotovi() {
        return slotovi;
    }

    @Override
    public void addSubscriber(ISubscriber sub) {
        if(sub == null)
            return;
        if(this.subscribers ==null)
            this.subscribers = new ArrayList<>();
        if(this.subscribers.contains(sub))
            return;
        this.subscribers.add(sub);
    }

    @Override
    public void removeSubscriber(ISubscriber sub) {
        if(sub == null || this.subscribers == null || !this.subscribers.contains(sub))
            return;
        this.subscribers.remove(sub);
    }

    @Override
    public void notifySubscribers(Object notification) {
        if (notification == null || this.subscribers == null || this.subscribers.isEmpty())
            return;
        for(ISubscriber listener : subscribers){
            listener.update(notification);

    }
}}
