package Cvorovi;

import gui.MainWindow;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Enumeration;

public class Workspace implements TreeNode{

        //kolekcija projekata
        private ArrayList<Projekat> projects = new ArrayList<Projekat>();


        public Workspace() {
            super();
            // TODO Auto-generated constructor stub
        }

        public String toString(){
            return "Workspace";
        }


        public TreeNode getChildAt(int arg0) {
            return getProject(arg0);

        }

        public int getChildCount() {
            return getProjectsCount();
        }

        public TreeNode getParent() {
            // TODO Auto-generated method stub
            return null;
        }

        public int getIndex(TreeNode arg0) {
            return getProjectIndex((Projekat) arg0);
        }

        public boolean getAllowsChildren() {
            // TODO Auto-generated method stub
            return true;
        }

        public boolean isLeaf() {
            // TODO Auto-generated method stub
            return false;
        }

        public Enumeration<Projekat> children() {
            // TODO Auto-generated method stub
            return (Enumeration<Projekat>) projects;
        }
        public void brisanje (Projekat pro){
            projects.remove(pro);
            MainWindow.getInstance().getMojTabbedPane().removeAll();
        }

        public void addProject(Projekat project){
            projects.add(project);
            project.setName("Project "+projects.size());
        }

    public ArrayList<Projekat> getProjects() {
        return projects;
    }

    public Projekat getProject(int index) {
            return projects.get(index);
        }
        public int getProjectIndex(Projekat project) {
            return projects.indexOf(project);
        }
        public int getProjectsCount() {
            return projects.size();
        }


}
