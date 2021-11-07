package gui;

import Cvorovi.Prezentacija;

import javax.swing.*;
import java.awt.*;

public class PrezentacijaView extends JPanel {

    private static final long serialVersionUID = 7445755320045782268L;

    private JPanel topPanel;

    public PrezentacijaView(Prezentacija prezentacija){
        this.setLayout(new BorderLayout());;

        // panel za toolbar
        this.topPanel = new JPanel();
        topPanel.add(new JLabel("Prezentacija " + prezentacija.getName()));
        this.add(topPanel, BorderLayout.NORTH);

    }
}
