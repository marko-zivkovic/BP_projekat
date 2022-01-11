package state;

import gui.MainWindow;
import gui.MojTabbedPane;
import gui.PrezentacijaView;
import gui.SlajdView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StateManager {

    private State currentState;
    private SlideShowState slideShowState;
    private SlideEditorState slideEditorState;
    private SlotState slotState;

    public StateManager() {
        slideShowState = new SlideShowState();
        slotState = new SlotState();
        slideEditorState = new SlideEditorState();
        currentState = slideShowState;
    }


    public State getCurrentState() {
        return currentState;
    }

    public void setSlideEditorState() {
        this.currentState = slideEditorState;
    }
    public void setSlideShow() {
        this.currentState = slideShowState;
    }
    public SlotState getSlotState() {
        return slotState;
    }

}
