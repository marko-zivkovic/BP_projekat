package gui;

import Actions.ActionManager;
import Cvorovi.Prezentacija;
import Cvorovi.Slajd;
import Observer.ISubscriber;
import state.State;
import state.StateManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PrezentacijaView extends JPanel implements ISubscriber {

    private static final long serialVersionUID = 7445755320045782268L;
    public String novaslika;
    private Prezentacija pr;
    private StateManager stateManager;

    private JPanel topPanel;
    private JPanel statePanel;
    private JLabel autor = new JLabel("Marko Zivkovic");
    private JPanel centar;
    private ActionManager actionManager = new ActionManager();
    private ArrayList<SlajdView> slajdViews = new ArrayList<>();
    private Prezentacija p;
    private JPanel levo;
    JToolBar jToolBar = new JToolBar("slot", JToolBar.VERTICAL);
    JToolBar jj = new JToolBar("state", JToolBar.HORIZONTAL);

    public PrezentacijaView(Prezentacija prezentacija) {

        prezentacija.addSubscriber(this);
        p = prezentacija;
        this.pr = prezentacija;
        this.setLayout(new BorderLayout());
        this.stateManager = new StateManager();
        // panel za toolbar
        this.topPanel = new JPanel();
        this.statePanel = new JPanel();
        this.add(topPanel, BorderLayout.EAST);
        this.add(statePanel, BorderLayout.NORTH);

        autor.setText("Autor: " + prezentacija.getAutor());
        this.add(autor, BorderLayout.SOUTH);
        autor.setHorizontalAlignment(SwingConstants.CENTER);
        levo = new JPanel();
        levo.setLayout(new BoxLayout(levo, BoxLayout.Y_AXIS));

        centar = new JPanel();
        centar.setLayout(new BoxLayout(centar, BoxLayout.Y_AXIS));
        //SCROLLPANE kao poseban Pane
        JScrollPane jsp = new JScrollPane(centar, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JScrollPane jsp2 = new JScrollPane(levo, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jsp2.setPreferredSize(new Dimension(170,300));

        centar.setBackground(Color.black);
        this.add(jsp, BorderLayout.CENTER);
        this.add(jsp2, BorderLayout.WEST);

        this.setBackground(Color.green);

        jToolBar.add(actionManager.getPravougaonikA());
        jToolBar.add(actionManager.getBojaA());
        jToolBar.add(actionManager.getVelicinaStrokeA());
        topPanel.add(jToolBar);
        jj.add(actionManager.getSlideShowActuin());
        jj.add(actionManager.getEditSlajdAction());
        jj.add(actionManager.getStartState());
        statePanel.add(jj);



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
//        else if (notification instanceof Slajd){
//            this.centar.repaint();
//            revalidate();
//        }
//        else if (notification instanceof Slajd){
//            int broj = ((Slajd) notification).getBr();
//            SlajdView ssv = null;
//            for(SlajdView sv: slajdViews){
//                if(sv.getSlajd().getBr() == broj)
//                       {ssv=sv;}
//            }
//            this.slajdViews.remove(ssv);
//            this.centar.remove(ssv);
//            centar.repaint();
//            revalidate();
//        }
//        else if (notification instanceof Slajd){
//            Slajd s = ((Slajd) notification);
//            SlajdView sv = new SlajdView(s,this.pr);
//            this.centar.add(sv);
//            this.centar.add(Box.createVerticalStrut(10));
//            this.slajdViews.add(sv);
//            this.revalidate();
//            this.repaint();
//        }
    }

    public JPanel getCentar() {
        return centar;
    }
    public JPanel getLevo(){return levo;}

    public void addSlajdView(SlajdView slideView) {
        SlajdView sv = new SlajdView(slideView.getSlajd(),pr);
        sv.setMaximumSize(new Dimension(130,70));
        sv.setMinimumSize(new Dimension(130,70));
        sv.setPreferredSize(new Dimension(130,70));

        this.centar.add(slideView);
        this.centar.add(Box.createVerticalStrut(10));

        this.slajdViews.add(slideView);

        this.levo.add(sv);
        this.levo.add(Box.createVerticalStrut(20));

        revalidate();
    }

    public ArrayList<SlajdView> getSlajdViews() {
        return slajdViews;
    }

    public void startSlideShow(){this.stateManager.setSlideShow();}
    public void endSlideShow(){this.stateManager.setSlideEditorState();}
    public void Start(){
        this.stateManager.getCurrentState().setSlideShowState(this);
    }

    public Prezentacija getPr() {
        return pr;
    }
}
