import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserInterface {

    Random rnd = new Random();

    private Dimension dimensionFrame;
    private Dimension dimensionContent;
    private Dimension dimensionTable;

    public UserInterface(Dimension dimensionFrame, Dimension dimensionContent, Dimension dimensionTable) {
        this.dimensionFrame = dimensionFrame;
        this.dimensionContent = dimensionContent;
        this.dimensionTable = dimensionTable;
    }

    public void createUI(){

        MigLayout layout = new MigLayout();

        JFrame frame = new JFrame("Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(new Dimension(dimensionFrame));
        frame.setMinimumSize(new Dimension(dimensionFrame));
        frame.setMaximumSize(new Dimension(dimensionFrame));
        frame.setPreferredSize(new Dimension(dimensionFrame));
        frame.setLayout(new MigLayout());

        List<Staff> listStaff = new ArrayList<>();
        for (int i = 0; i < listStaff.size(); i++) {
            listStaff.add(new Staff(i,
                    "Имя " + i,
                    "Фамилия " + i,
                    "Менеджер " + i,
                    String.valueOf(rnd.nextInt(9)) + String.valueOf(rnd.nextInt(9)) + String.valueOf(rnd.nextInt(9)) + "-"
                            + String.valueOf(rnd.nextInt(9)) + String.valueOf(rnd.nextInt(9)) + "-"
                            + String.valueOf(rnd.nextInt(9)) + String.valueOf(rnd.nextInt(9)),
                    rnd.nextInt(20) + 30));
        }

        TableModel tableModel = new TableModel(listStaff);
        JTable table = new JTable(tableModel);
        table.setSize(new Dimension(dimensionContent));
        table.setMinimumSize(new Dimension(dimensionContent));
        table.setMaximumSize(new Dimension(dimensionContent));
        table.setPreferredSize(new Dimension(dimensionContent));


        JPanel content = new JPanel();
        content.setSize(new Dimension(dimensionTable));
        content.setMinimumSize(new Dimension(dimensionTable));
        content.setMaximumSize(new Dimension(dimensionTable));
        content.setPreferredSize(new Dimension(dimensionTable));






        content.add(table);
        frame.add(content);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
