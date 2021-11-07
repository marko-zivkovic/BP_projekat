package Controller;


    // Java program to create open or
// save dialog using JFileChooser
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.filechooser.*;
   public class FileChooser extends JFrame implements ActionListener {

        // Jlabel to show the files user selects
        static JLabel l;

        // a default constructor
        public FileChooser()
        {
        }

        public void actionPerformed(ActionEvent evt)
        {
            // if the user presses the save button show the save dialog
            String com = evt.getActionCommand();

            if (com.equals("save")) {
                // create an object of JFileChooser class
                JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

                // invoke the showsSaveDialog function to show the save dialog
                int r = j.showSaveDialog(null);

                // if the user selects a file
                if (r == JFileChooser.APPROVE_OPTION)

                {
                    // set the label to the path of the selected file
                    l.setText(j.getSelectedFile().getAbsolutePath());
                }
                // if the user cancelled the operation
                else
                    l.setText("the user cancelled the operation");
            }

            // if the user presses the open dialog show the open dialog
            else {
                // create an object of JFileChooser class
                JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

                // invoke the showsOpenDialog function to show the save dialog
                int r = j.showOpenDialog(null);

                // if the user selects a file
                if (r == JFileChooser.APPROVE_OPTION)

                {
                    // set the label to the path of the selected file
                    l.setText(j.getSelectedFile().getAbsolutePath());
                }
                // if the user cancelled the operation
                else
                    l.setText("the user cancelled the operation");
            }
        }
    }


