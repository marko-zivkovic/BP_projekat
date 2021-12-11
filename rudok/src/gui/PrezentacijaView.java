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
    private JPanel centar;

    public PrezentacijaView(Prezentacija prezentacija) {

        prezentacija.addSubscriber(this);
        this.setLayout(new BorderLayout());
        // panel za toolbar
        this.topPanel = new JPanel();
        topPanel.add(new JLabel(prezentacija.getName()));
        this.add(topPanel, BorderLayout.NORTH);

        autor.setText("Autor: " + prezentacija.getAutor());
        this.add(autor, BorderLayout.SOUTH);
        autor.setHorizontalAlignment(SwingConstants.CENTER);

        centar = new JPanel();
        centar.setLayout(new BoxLayout(centar, BoxLayout.Y_AXIS));
        //SCROLLPANE kao poseban Pane
        JScrollPane jsp = new JScrollPane(centar, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        centar.setBackground(Color.black);
        this.add(jsp, BorderLayout.CENTER);

        this.setBackground(Color.green);
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

    public void addSlajdView(SlajdView slideView) {
        this.centar.add(slideView);
        this.centar.add(Box.createVerticalStrut(10));
        revalidate();
    }
}
