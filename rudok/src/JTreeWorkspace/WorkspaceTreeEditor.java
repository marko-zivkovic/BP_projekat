package JTreeWorkspace;

import Cvorovi.Prezentacija;
import Cvorovi.Projekat;
import Cvorovi.Slajd;
import Cvorovi.Workspace;
import gui.MainWindow;
import gui.MojTabbedPane;
import gui.PrezentacijaView;
import gui.SlajdView;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

public class WorkspaceTreeEditor extends DefaultTreeCellEditor implements ActionListener {
    private Object stavka=null;
    private JTextField edit=null;

    public WorkspaceTreeEditor(JTree arg0, DefaultTreeCellRenderer arg1) {
        super(arg0, arg1);
    }

    public Component getTreeCellEditorComponent(JTree arg0, Object arg1, boolean arg2, boolean arg3, boolean arg4, int arg5) {

        //super.getTreeCellEditorComponent(arg0,arg1,arg2,arg3,arg4,arg5);
        stavka=arg1;

        edit=new JTextField(arg1.toString());
        edit.addActionListener(this);
        return edit;
    }



    public boolean isCellEditable(EventObject arg0) {
        if (arg0 instanceof MouseEvent){
            if (((MouseEvent)arg0).getClickCount()==3){
                return true;
            }
            if (((MouseEvent)arg0).getClickCount()==2){
                Object p = MainWindow.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
                if(p instanceof Projekat){
                    MojTabbedPane mtp = MainWindow.getInstance().getMojTabbedPane();
                    for(Prezentacija pr : ((Projekat) p).getPrezentacije()){

                        PrezentacijaView pv = new PrezentacijaView(pr);
                        addMyTabToTabbedPane(pr.getName(), pv,mtp);

                        for(Slajd s:pr.getSlajdovi()){
                            pv.addSlajdView(new SlajdView(s,pr));
                        }

                    }
                }
            }
        }

        return false;
    }
    private void addMyTabToTabbedPane(String nazivTaba, PrezentacijaView p, MojTabbedPane mtp) {

       mtp.add(nazivTaba,p);

    }



    public void actionPerformed(ActionEvent e){
        if (stavka instanceof Projekat){
            ((Projekat)stavka).setName(e.getActionCommand());
        }else{
             //((Workspace)stavka).setName(e.getActionCommand());
        }

        //posle promene imena ili dijagrama treba obezbediti i promenu imena u GEDView-u



    }
}
