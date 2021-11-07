package Actions;

import gui.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class BrisanjeCvoraAction extends AbstractMyAction{

    public BrisanjeCvoraAction (){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("brisi.png"));
        putValue(SHORT_DESCRIPTION, "ukloni");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object p = MainWindow.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
    }
}
