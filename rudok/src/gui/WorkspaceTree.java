package gui;

import Cvorovi.Projekat;
import Cvorovi.WorkspaceModel;
import JTreeWorkspace.WorkspaceTreeCellRendered;
import JTreeWorkspace.WorkspaceTreeController;
import JTreeWorkspace.WorkspaceTreeEditor;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;

public class WorkspaceTree extends JTree{

    public WorkspaceTree() {

        addTreeSelectionListener(new WorkspaceTreeController());
        setCellEditor(new WorkspaceTreeEditor(this,new DefaultTreeCellRenderer()));
        setCellRenderer(new WorkspaceTreeCellRendered());
        setEditable(true);
    }


    /**
     * Metoda za dodavanje novog projekta u workspace
     * @param project
     */
    public void addProject(Projekat project){
        ((WorkspaceModel)getModel()).addProject(project);
        SwingUtilities.updateComponentTreeUI(this);
    }
}