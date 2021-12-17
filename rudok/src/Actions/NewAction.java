package Actions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class NewAction extends AbstractMyAction{

    public NewAction (){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("slike\\new.png"));
        putValue(SHORT_DESCRIPTION, "new");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("usao");

    }
}
