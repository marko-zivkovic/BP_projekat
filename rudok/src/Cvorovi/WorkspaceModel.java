package Cvorovi;

import javax.swing.tree.DefaultTreeModel;

public class WorkspaceModel extends DefaultTreeModel {
    public WorkspaceModel() {
        super(new Workspace());

    }

    public void addProject(Projekat project){
        ((Workspace)getRoot()).addProject(project);
    }

}
