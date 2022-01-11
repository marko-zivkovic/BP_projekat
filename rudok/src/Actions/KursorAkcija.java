package Actions;

import gui.MainWindow;
import gui.PrezentacijaView;
import gui.SlajdView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class KursorAkcija extends AbstractMyAction
{
    public KursorAkcija (){
    putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
            KeyEvent.VK_O, ActionEvent.CTRL_MASK));
    putValue(SMALL_ICON, loadIcon("slike/kursor.png"));
    putValue(SHORT_DESCRIPTION, "kursor");
}
    @Override
    public void actionPerformed(ActionEvent e) {
        PrezentacijaView pv = (PrezentacijaView) MainWindow.getInstance().getMojTabbedPane().getSelectedComponent();
        for(SlajdView sv: pv.getSlajdViews()){
            sv.setFlag(false);
        }
    }

}
