package gui;

import Actions.ActionManager;
import Cvorovi.WorkspaceModel;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private static MainWindow instance = null;
    private ActionManager actionManager = new ActionManager();
    private WorkspaceTree workspaceTree;
    private MojTabbedPane mojTabbedPane;

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
        setSize(sirina/2,visina/2);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setVisible(true);
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
        jToolBar.add(actionManager.getRenameAutorAction());
        jToolBar.add(actionManager.getInfoAction());
        jToolBar.add(actionManager.getNovaSlikaAction());
        this.getContentPane().add(jToolBar,BorderLayout.NORTH);

        workspaceTree = new WorkspaceTree();
        WorkspaceModel workspaceModel = new WorkspaceModel();
        workspaceTree.setModel(workspaceModel);

        mojTabbedPane = new MojTabbedPane();
        JSplitPane jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,new JScrollPane(workspaceTree), mojTabbedPane);
        this.getContentPane().add(jSplitPane,BorderLayout.CENTER);
        jSplitPane.setDividerLocation(250);



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
}
