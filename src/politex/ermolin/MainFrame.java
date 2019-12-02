package politex.ermolin;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainFrame extends JFrame {
    JMenuItem enableResizeItem;
    JMenuItem disableResizeItem;

    private ButtonGroup buttongroup;

    public MainFrame() {
        super("Friday, 13");

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Friday, 13");
        menuBar.add(menu);

        JMenuItem mi = menu.add("Chose background...");
        mi.addActionListener(this::changeBackgroundColor);

        menu.addSeparator();


        enableResizeItem = menu.add("Enable resize");
        enableResizeItem.addActionListener(this::onEnableRsize);
        //enableRsizeItem.addActionListener(e-> { enableResize(true);});
        // enableResizeItem.setEnabled(false);

        disableResizeItem = menu.add("Disable resize");
        disableResizeItem.addActionListener(this::onDisableResize);

        menu.addSeparator();

        mi = menu.add("Exit");
        mi.addActionListener(e -> {
            dispose();
            System.exit(0);
        });

        setJMenuBar(menuBar);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void changeBackgroundColor(ActionEvent e) {

        Color c = JColorChooser.showDialog(this, "Choose a color", getContentPane().getBackground());
        if (c != null)
            getContentPane().setBackground(c);
    }

    private void onEnableRsize(ActionEvent e) {
        setResizable(true);
        enableResizeItem.setEnabled(false);
        disableResizeItem.setEnabled(true);
    }

    private void onDisableResize(ActionEvent e) {
        setResizable(false);
        enableResizeItem.setEnabled(true);
        disableResizeItem.setEnabled(false);
    }
}