package JTreeWorkspace;

import Cvorovi.Projekat;
import Cvorovi.Slajd;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.net.URL;

public class WorkspaceTreeCellRendered extends DefaultTreeCellRenderer {
    public WorkspaceTreeCellRendered() {

        // TODO Auto-generated constructor stub
    }

    public Component getTreeCellRendererComponent(
            JTree tree,
            Object value,
            boolean sel,
            boolean expanded,
            boolean leaf,
            int row,
            boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel,expanded, leaf, row,hasFocus);


        if (value instanceof Slajd) {
            URL imageURL = getClass().getResource("images/tdiagram.gif");
            Icon icon = null;
            if (imageURL != null)
                icon = new ImageIcon(imageURL);
            setIcon(icon);

        } else if (value instanceof Projekat) {
            URL imageURL = getClass().getResource("images/tproject.gif");
            Icon icon = null;
            if (imageURL != null)
                icon = new ImageIcon(imageURL);
            setIcon(icon);

        }



        return this;
    }

}
