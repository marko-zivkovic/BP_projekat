package Actions;

import factory.FactoryError;
import gui.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class SlideShowActuin extends AbstractMyAction{
    public SlideShowActuin (){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("slike/ss.jpg"));
        putValue(SHORT_DESCRIPTION, "Slide Show");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            MainWindow.getInstance().getStateManager().setSlideShowState();
        }
        catch(Exception ex) {
            FactoryError.getInstance().generateError("slideshow");
        }
    }
}
