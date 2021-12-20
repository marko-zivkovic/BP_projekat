package Actions;

import gui.MainWindow;
import gui.MojTabbedPane;
import gui.PrezentacijaView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class EditSlajdAction extends AbstractMyAction{
        public EditSlajdAction(){
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                    KeyEvent.VK_O, ActionEvent.CTRL_MASK));
            putValue(SMALL_ICON, loadIcon("slike/ss.jpg"));
            putValue(SHORT_DESCRIPTION, "Prekid Slide Show");
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            PrezentacijaView pv = (PrezentacijaView) MainWindow.getInstance().getMojTabbedPane().getSelectedComponent();
            pv.endSlideShow();
        }
}
