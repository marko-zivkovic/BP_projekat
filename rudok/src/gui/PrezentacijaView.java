package gui;

import Cvorovi.Prezentacija;
import Observer.ISubscriber;

import javax.swing.*;
import java.awt.*;

public class PrezentacijaView extends JPanel implements ISubscriber {

    private static final long serialVersionUID = 7445755320045782268L;

    private JPanel topPanel;
    private JLabel autor = new JLabel("Marko Zivkovic");
    public PrezentacijaView(Prezentacija prezentacija){
        this.setLayout(new BorderLayout());;
        prezentacija.addSubscriber(this);

        // panel za toolbar
        this.topPanel = new JPanel();
        topPanel.add(new JLabel("Prezentacija " + prezentacija.getName()));
        this.add(topPanel, BorderLayout.NORTH);
        autor.setText(prezentacija.getAutor());
        this.add(autor, BorderLayout.EAST);
    }

    @Override
    public void update(Object notification) {
        autor.setText(((Prezentacija) notification).getAutor());
    }
}
