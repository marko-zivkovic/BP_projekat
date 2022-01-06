package Actions;

import gui.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class UndoAction extends AbstractMyAction{
    UndoAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        putValue(MNEMONIC_KEY, KeyEvent.VK_U);
        putValue(SMALL_ICON, loadIcon("slike/undo.png"));
        putValue(NAME, "Undo");
        putValue(SHORT_DESCRIPTION, "Undo");
    }

    public void actionPerformed(ActionEvent e) {
        MainWindow.getInstance().getCommandManager().undoCommand();

    }
}
