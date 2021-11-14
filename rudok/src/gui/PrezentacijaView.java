package gui;

import Cvorovi.Prezentacija;
import Cvorovi.Slajd;
import Observer.ISubscriber;

import javax.swing.*;
import java.awt.*;

public class PrezentacijaView extends JPanel implements ISubscriber {

    private static final long serialVersionUID = 7445755320045782268L;
    public String novaslika;

    private JPanel topPanel;
    private JLabel autor = new JLabel("Marko Zivkovic");
    private JPanel centar = new JPanel();

    public PrezentacijaView(Prezentacija prezentacija) {
        this.setLayout(new BorderLayout());
        ;
        prezentacija.addSubscriber(this);

        // panel za toolbar
        this.topPanel = new JPanel();
        topPanel.add(new JLabel(prezentacija.getName()));
        this.add(topPanel, BorderLayout.NORTH);
        autor.setText("Autor: " + prezentacija.getAutor());
        this.add(autor, BorderLayout.SOUTH);
        autor.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(centar, BorderLayout.CENTER);
    }

    @Override
    public void update(Object notification) {
        if (notification instanceof String && notification.equals("odstupi")) {
            this.removeAll();

            MainWindow.getInstance().getMojTabbedPane().removeAll();
        } else if(!(notification instanceof String) && !(notification instanceof Slajd)) {
            autor.setText(((Prezentacija) notification).getAutor());
            novaslika = ((Prezentacija) notification).getSlikatema();

        }
    }

    public JPanel getCentar() {
        return centar;
    }
}
