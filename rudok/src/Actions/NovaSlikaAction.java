package Actions;

import Controller.FileChooser;
import Cvorovi.Prezentacija;
import gui.MainWindow;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class NovaSlikaAction extends AbstractMyAction{
    public NovaSlikaAction (){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("slka.png"));
        putValue(SHORT_DESCRIPTION, "promeni sliku");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        // invoke the showsOpenDialog function to show the save dialog
        int r = j.showOpenDialog(null);

        // if the user selects a file
        if (r == JFileChooser.APPROVE_OPTION)

        {
            Object p = MainWindow.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
            if( p instanceof Prezentacija) {
                System.out.println("usaoooooooo " + j.getSelectedFile().getAbsolutePath());

                ((Prezentacija) p).setSlikatema(j.getSelectedFile().getAbsolutePath());
                System.out.println(((Prezentacija) p).getSlikatema() + " ----");

            }

        }

    }

}
