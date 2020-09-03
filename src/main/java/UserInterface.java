import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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
    private DefaultTableModel defaultTableModel;

    public UserInterface(Dimension dimensionFrame, Dimension dimensionTable, Dimension dimensionScrollTable) {
        this.dimensionFrame = dimensionFrame;
        this.dimensionTable = dimensionTable;
        this.dimensionScrollTable = dimensionScrollTable;
    }

    public void createUI(){

        MigLayout layout = new MigLayout(
                "", // Layout Constraints
                "[center]20[center]20[center]20[center]", // Column constraints
                "[center]"); // Row constraints
        Font font = new Font("Calibri", Font.BOLD, 20);

        JFrame frame = new JFrame("Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(new Dimension(dimensionFrame));
        frame.setMinimumSize(new Dimension(dimensionFrame));
        frame.setMaximumSize(new Dimension(dimensionFrame));
        frame.setPreferredSize(new Dimension(dimensionFrame));
        frame.setLayout(layout);

        JPanel panel = new JPanel();
        panel.setLayout(layout);

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

        JButton button1 = new JButton("CREATE");
        button1.setFont(font);
        button1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent){
                int index = table.getSelectedRow();
                defaultTableModel = (DefaultTableModel) table.getModel();
                // Вставка новой строки после выделенной
                defaultTableModel.insertRow(index + 1, new String[] {
                        "Товар №" + String.valueOf(table.getRowCount()),
                        "кг", "Цена"});
            }
        });

        JButton button2 = new JButton("READ BY INDEX");
        button2.setFont(font);
        button2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent){
                button2.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String input = JOptionPane.showInputDialog(
                                UserInterface.this,
                                "Введите ID для поиска");
                        int inputId = Integer.parseInt(input);
                        for (int i = 0; i < listStaff.size(); i++) {
                            if (inputId == listStaff.get(i).getId()){
                                JOptionPane.showInputDialog(null,
                                        "Вы ввели ID", input);
                            }
                            else{
                                JOptionPane.showMessageDialog(null,
                                        "Некорректный ввод");
                                return;
                            }
                        }
                    }
                });
            }
        });

        JButton button3 = new JButton("UPDATE");
        button3.setFont(font);
        button3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent){
//                if(textField.getText().equals("ERROR")){
//                    clearAll();
//                }
//                textField.setText(textField.getText() + 1);
//                listData.add(textField.getText());
            }
        });

        JButton button4 = new JButton("DELETE");
        button4.setFont(font);
        button4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent){
                int index = table.getSelectedRow();
                System.out.println(index);
                defaultTableModel = (DefaultTableModel) table.getModel();
                defaultTableModel.removeRow(index);
                listStaff.remove(index);
            }
        });

        panel.add(button1, "cell 0 1, w 180!, h 40!");
        panel.add(button2, "cell 1 1, w 180!, h 40!");
        panel.add(button3, "cell 2 1, w 180!, h 40!");
        panel.add(button4, "cell 3 1, w 180!, h 40!");

        frame.add(jscrlp, "wrap");
        frame.add(panel);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
