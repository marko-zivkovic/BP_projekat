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

        prezentacija.addSubscriber(this);

        // panel za toolbar
        this.topPanel = new JPanel();
        topPanel.add(new JLabel(prezentacija.getName()));
        this.add(topPanel, BorderLayout.NORTH);
        autor.setText("Autor: " + prezentacija.getAutor());
        this.add(autor, BorderLayout.SOUTH);
        autor.setHorizontalAlignment(SwingConstants.CENTER);

        centar.setLayout(new BoxLayout(centar, BoxLayout.Y_AXIS));
      //  centar.setAlignmentX(Component.CENTER_ALIGNMENT);


        centar.setPreferredSize(new Dimension(100,250));
        centar.setMaximumSize(new Dimension(100,250));
        JScrollPane jsp = new JScrollPane(centar);
        jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(jsp, BorderLayout.CENTER);
  //      jsp.setPreferredSize(new Dimension(100, 500));
  //      jsp.setMaximumSize(new Dimension(100, 500));
   //     jsp.setSize(100, 500);
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
}
