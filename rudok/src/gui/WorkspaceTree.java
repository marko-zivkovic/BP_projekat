package gui;

import Cvorovi.Projekat;
import Cvorovi.WorkspaceModel;
import JTreeWorkspace.WorkspaceTreeCellRendered;
import JTreeWorkspace.WorkspaceTreeController;
import JTreeWorkspace.WorkspaceTreeEditor;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreePath;

public class WorkspaceTree extends JTree{

    public WorkspaceTree() {

        addTreeSelectionListener(new WorkspaceTreeController());
        setCellEditor(new WorkspaceTreeEditor(this,new DefaultTreeCellRenderer()));
        setCellRenderer(new WorkspaceTreeCellRendered());
        setEditable(true);
    }

    public void addProject(Projekat project){
        ((WorkspaceModel)getModel()).addProject(project);
        SwingUtilities.updateComponentTreeUI(this);
    }
    public Projekat getCurrentProject() {
        TreePath path = getSelectionPath();
        for(int i=0; i<path.getPathCount(); i++){
            if(path.getPathComponent(i) instanceof Projekat){
                return (Projekat)path.getPathComponent(i);
            }
        }
        return null;
    }
}
