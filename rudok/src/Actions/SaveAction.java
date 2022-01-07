package Actions;

import Cvorovi.Projekat;
import gui.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.*;

public class SaveAction extends AbstractMyAction{
    public SaveAction() {

        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("slike/new.png"));
        putValue(NAME, "Save project");
        putValue(SHORT_DESCRIPTION, "Save project");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new MyFileFilter());
        Object p = MainWindow.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
        if (p instanceof Projekat) {

            //Projekat project = MainWindow.getInstance().getWorkspaceTree().getCurrentProject();


            Projekat project = (Projekat) p;
            File projectFile = project.getProjekatFile();


            if (!project.isChanged()) {
                System.out.println("Projekat je ne promenjen");
                return;
            }

            if (project.getProjekatFile() == null) {
                if (jfc.showSaveDialog(MainWindow.getInstance()) == JFileChooser.APPROVE_OPTION) {
                    projectFile = jfc.getSelectedFile();


                } else {
                    return;
                }

            }


            ObjectOutputStream os;
            try {
                os = new ObjectOutputStream(new FileOutputStream(projectFile));
                os.writeObject(project);
                project.setProjekatFile(projectFile);
                project.setChanged(false);
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }
        else{
            System.out.println("Kliknite na projekat koji zelite da sacuvate");
        }
    }
}
