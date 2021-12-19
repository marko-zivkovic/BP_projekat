package Actions;

import factory.FactoryError;
import gui.MainWindow;
import gui.MojTabbedPane;
import state.SlideEditorState;
import state.SlideShowState;
import state.SlotState;

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
        MojTabbedPane mtp = MainWindow.getInstance().getMojTabbedPane();
        try {
            MainWindow.getInstance().getStateManager().getSlideShowState().setSlideShowState(mtp);
        }
        catch(Exception ex) {
            FactoryError.getInstance().generateError("slideshow");
        }
    }
}
