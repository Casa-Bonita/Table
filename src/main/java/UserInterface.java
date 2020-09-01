import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.awt.event.*;

public class UserInterface {

    private Dimension dimensionFrame;

    public UserInterface(Dimension dimensionFrame) {
        this.dimensionFrame = dimensionFrame;
    }

    public void createUI(){

        MigLayout layout = new MigLayout();

        JFrame frame = new JFrame("Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(dimensionFrame));
        frame.setMinimumSize(new Dimension(dimensionFrame));
        frame.setMaximumSize(new Dimension(dimensionFrame));
        frame.setPreferredSize(new Dimension(dimensionFrame));
        frame.setLayout(new MigLayout());

        JPanel panel = new JPanel();
        panel.setLayout(layout);
        frame.add(panel);

        frame.setResizable(false);
        frame.setVisible(true);
    }
}
