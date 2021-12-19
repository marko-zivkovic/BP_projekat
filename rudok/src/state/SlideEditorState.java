package state;


import gui.MainWindow;
import gui.MojTabbedPane;

import java.awt.*;

public class SlideEditorState implements State {

    @Override
    public void setSlideShowState(MojTabbedPane mtp) {
        MainWindow.getInstance().getDesni().removeAll();
        MainWindow.getInstance().getDesni().add(mtp, BorderLayout.CENTER);
        MainWindow.getInstance().getDesni().add(MainWindow.getInstance().getJjToolBar(), BorderLayout.NORTH);
        MainWindow.getInstance().getDesni().revalidate();
        MainWindow.getInstance().getDesni().repaint();

    }
}
