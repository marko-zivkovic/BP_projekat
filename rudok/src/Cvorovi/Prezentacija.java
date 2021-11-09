package Cvorovi;

import Observer.ISubscriber;
import Observer.IPublisher;

import sun.reflect.generics.tree.Tree;

import javax.swing.*;
import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class Prezentacija implements TreeNode, IPublisher {
    private ArrayList<Slajd> slajdovi = new ArrayList<Slajd>();
    private String name;
    private String autor;
    private String slikatema;
    List<ISubscriber> subscribers;


    public Prezentacija(String projectName) {
        this.name=projectName;
        slikatema= new String("slika.jpg");
        this.autor = "Marko Zivkovic";



    }

    public ArrayList<Slajd> getSlajdovi() {
        return slajdovi;
    }

    public void setSlajdovi(ArrayList<Slajd> slajdovi) {
        this.slajdovi = slajdovi;
        ///
    }

    public String getName() {
        return name;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
        this.notifySubscribers(this);
    }

    public String getSlikatema() {
        return slikatema;
    }

    public void setSlikatema(String slikatema) {
        this.slikatema = slikatema;
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
    @Override
    public void addSubscriber(ISubscriber sub) {
        // TODO Auto-generated method stub
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
        // TODO Auto-generated method stub
        if(sub == null || this.subscribers == null || !this.subscribers.contains(sub))
            return;
        this.subscribers.remove(sub);
    }

    @Override
    public void notifySubscribers(Object notification) {
        // TODO Auto-generated method stub
        if (notification == null || this.subscribers == null || this.subscribers.isEmpty())
            return;
        for(ISubscriber listener : subscribers){
            listener.update(notification);
        }
    }

}
