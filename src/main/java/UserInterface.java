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
    private Dimension dimensionTable;
    private Dimension dimensionScrollTable;

    public UserInterface(Dimension dimensionFrame, Dimension dimensionTable, Dimension dimensionScrollTable) {
        this.dimensionFrame = dimensionFrame;
        this.dimensionTable = dimensionTable;
        this.dimensionScrollTable = dimensionScrollTable;
    }

    public void createUI(){

        JFrame frame = new JFrame("Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(new Dimension(dimensionFrame));
        frame.setMinimumSize(new Dimension(dimensionFrame));
        frame.setMaximumSize(new Dimension(dimensionFrame));
        frame.setPreferredSize(new Dimension(dimensionFrame));
        frame.setLayout(new FlowLayout((FlowLayout.CENTER)));

        List<Staff> listStaff = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
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
        table.setSize(new Dimension(dimensionTable));
        table.setMinimumSize(new Dimension(dimensionTable));
        table.setMaximumSize(new Dimension(dimensionTable));
        table.setRowHeight(25);


        JScrollPane jscrlp = new JScrollPane(table);
        jscrlp.setViewportView(table);
        table.setPreferredScrollableViewportSize(new Dimension(dimensionScrollTable));

        frame.add(jscrlp);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
