package gui;

import Actions.ActionManager;
import Cvorovi.WorkspaceModel;
import Observer.ISubscriber;
import factory.FactoryError;
import factory.MyError;
import state.StateManager;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame implements ISubscriber {

    private static MainWindow instance = null;
    private ActionManager actionManager = new ActionManager();
    private StateManager stateManager = new StateManager();
    private WorkspaceTree workspaceTree;
    private MojTabbedPane mojTabbedPane;
    JToolBar jjToolBar = new JToolBar();
    private JPanel desni = new JPanel();
    private FactoryError ferror;

    private MainWindow()
    {
        initialiseGui();
    }

    public static MainWindow getInstance(){
        if(instance == null){
            instance = new MainWindow();

        }
        return instance;
    }
    private void initialiseGui (){
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenD = tk.getScreenSize();
        int visina = screenD.height;
        int sirina = screenD.width;
        setSize((sirina/2)+350,(visina/2)+250);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        ferror = FactoryError.getInstance();
        ferror.addSubscriber(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar jMenuBar = new JMenuBar();
        JMenu file = new JMenu("file");
        JMenu help = new JMenu("help");
        JMenuItem edit = new JMenuItem("edit");
        JMenuItem novi = new JMenuItem("new");
        jMenuBar.add(file);
        jMenuBar.add(help);
        //file.add(novi);
        file.add(actionManager.getNewAction());
        file.add(actionManager.getInfoAction());
        help.add(edit);
        this.setJMenuBar(jMenuBar);

        JToolBar jToolBar = new JToolBar();
        jToolBar.add(actionManager.getNewAction());
        jToolBar.add(actionManager.getDodajCvorAkcija());
        jToolBar.add(actionManager.getDodajCvorAkcijaFactory());
        jToolBar.add(actionManager.getBrisanjeCvoraAction());
        jToolBar.add(actionManager.getRenameAutorAction());
        jToolBar.add(actionManager.getNovaSlikaAction());
        jToolBar.add(actionManager.getInfoAction());

        this.getContentPane().add(jToolBar,BorderLayout.NORTH);

        workspaceTree = new WorkspaceTree();
        WorkspaceModel workspaceModel = new WorkspaceModel();
        workspaceTree.setModel(workspaceModel);

        mojTabbedPane = new MojTabbedPane();

        desni.setLayout(new BorderLayout());
        desni.add(mojTabbedPane, BorderLayout.CENTER);

        jjToolBar.add(actionManager.getEditSlotAction());
        jjToolBar.add(actionManager.getSlideShowActuin());

        desni.add(jjToolBar,BorderLayout.NORTH);

        JSplitPane jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,new JScrollPane(workspaceTree), desni);
        this.getContentPane().add(jSplitPane,BorderLayout.CENTER);
        jSplitPane.setDividerLocation(220);

        setVisible(true);


    }

    public WorkspaceTree getWorkspaceTree() {
        return workspaceTree;
    }

    public void setWorkspaceTree(WorkspaceTree workspaceTree) {
        this.workspaceTree = workspaceTree;
    }

    public ActionManager getActionManager() {
        return actionManager;
    }

    public MojTabbedPane getMojTabbedPane() {
        return mojTabbedPane;
    }

    public void setActionManager(ActionManager actionManager) {
        this.actionManager = actionManager;
    }

    public StateManager getStateManager() {
        return stateManager;
    }

    public JPanel getDesni() {
        return desni;
    }

    public JToolBar getJjToolBar() {
        return jjToolBar;
    }

    @Override
    public void update(Object notification) {
        if(notification instanceof MyError){
            ((MyError) notification).IspisiPoruku();
        }
    }
}
