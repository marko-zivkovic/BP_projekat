package Actions;

import gui.AboutInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class BojaA extends  AbstractMyAction{
    public BojaA (){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("slike/color.png"));
        putValue(SHORT_DESCRIPTION, "izaberi boju");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JColorChooser c = new JColorChooser();
        Color color = JColorChooser.showDialog(null,"Izaberi boju", Color.black);
    }
}
