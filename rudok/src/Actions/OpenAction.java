package Actions;

import Cvorovi.Projekat;
import gui.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class OpenAction extends  AbstractMyAction{
    public OpenAction() {

        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("slike/new.png"));
        putValue(NAME, "Open project");
        putValue(SHORT_DESCRIPTION, "Open project");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new MyFileFilter());

        if (jfc.showOpenDialog(MainWindow.getInstance()) == JFileChooser.APPROVE_OPTION) {
            try {
                ObjectInputStream os = new ObjectInputStream(new FileInputStream(jfc.getSelectedFile()));

                Projekat p = null;
                try {
                    p = (Projekat) os.readObject();
                } catch (ClassNotFoundException ee) {
                    // TODO Auto-generated catch block
                    ee.printStackTrace();
                }


                MainWindow.getInstance().getWorkspaceTree().addProject(p);

//                for (int i=0;i<p.getDiagramCount();i++){
//                    DiagramView view=new DiagramView();
//                    p.getDiagram(i).getModel().addUpdateListener(p);
//                    view.setDiagram(p.getDiagram(i));
//
//                    AppCore.getInstance().getDesktop().add(view);
//                }
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }
    }
}
