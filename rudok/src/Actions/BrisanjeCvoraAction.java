package Actions;

import Cvorovi.Prezentacija;
import Cvorovi.Projekat;
import Cvorovi.Slajd;
import Cvorovi.Workspace;
import gui.MainWindow;
import gui.PrezentacijaView;
import gui.WorkspaceTree;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class BrisanjeCvoraAction extends AbstractMyAction{

    public BrisanjeCvoraAction (){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("slike/brisi.png"));
        putValue(SHORT_DESCRIPTION, "ukloni");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object p = MainWindow.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
         if(p instanceof Projekat){
             WorkspaceTree wst = MainWindow.getInstance().getWorkspaceTree();
             Workspace workspace = (Workspace) wst.getModel().getRoot();
             workspace.brisanje((Projekat) p);
             SwingUtilities.updateComponentTreeUI(MainWindow.getInstance().getWorkspaceTree());

         }
         if(p instanceof Prezentacija){
             WorkspaceTree wst = MainWindow.getInstance().getWorkspaceTree();
             Workspace workspace = (Workspace) wst.getModel().getRoot();
             for(Projekat pp: workspace.getProjects()){
                 if(pp.getPrezentacije().contains(p)){
                     pp.brisanje((Prezentacija) p);
                 }
             }
             SwingUtilities.updateComponentTreeUI(MainWindow.getInstance().getWorkspaceTree());
         }
        if(p instanceof Slajd){
            WorkspaceTree wst = MainWindow.getInstance().getWorkspaceTree();
            Workspace workspace = (Workspace) wst.getModel().getRoot();
            for(Projekat pp: workspace.getProjects()){
               for(Prezentacija ss: pp.getPrezentacije()){
                   if(ss.getSlajdovi().contains(p)){
                       ss.brisanje((Slajd) p);
                   }
               }
            }
            SwingUtilities.updateComponentTreeUI(MainWindow.getInstance().getWorkspaceTree());
        }
    }
}
