package JTreeWorkspace;

import Cvorovi.Projekat;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

public class WorkspaceTreeController implements TreeSelectionListener {

    public void valueChanged(TreeSelectionEvent e) {
        // TODO Auto-generated method stub





        TreePath path = e.getPath();
        for(int i=0; i<path.getPathCount(); i++){
            if(path.getPathComponent(i) instanceof Projekat){
                Projekat d=(Projekat)path.getPathComponent(i);
                System.out.println("Selektovan cvor:");
                System.out.println("getPath: "+e.getPath());
                System.out.println("getPath: "+e.getNewLeadSelectionPath()+"\n");
                break;
            }
        }
    }
}
