package Actions;

import gui.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class RedoAction extends AbstractMyAction{
    RedoAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        putValue(MNEMONIC_KEY, KeyEvent.VK_U);
        putValue(SMALL_ICON, loadIcon("slike/redo.png"));
        putValue(NAME, "redo");
        putValue(SHORT_DESCRIPTION, "redo");
    }

    public void actionPerformed(ActionEvent e) {
        MainWindow.getInstance().getCommandManager().doCommand();

    }
}
