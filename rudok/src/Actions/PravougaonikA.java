package Actions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.geom.GeneralPath;

public class PravougaonikA extends AbstractMyAction{

    public PravougaonikA (){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("slike\\p.jpg"));
        putValue(SHORT_DESCRIPTION, "pravougaonik");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("pravougaonik");
    }


}
