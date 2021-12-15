package Actions;

import gui.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class SlideShowActuin extends AbstractMyAction{
    public SlideShowActuin (){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("color.png"));
        putValue(SHORT_DESCRIPTION, "Slide Show");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MainWindow.getInstance().getStateManager().setSlideShowState();
    }
}
