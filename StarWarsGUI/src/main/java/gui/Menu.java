package gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;


public class Menu {
    public void startMenu(String[][] list){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder( BorderFactory.createEtchedBorder(), "Star Wars Characters Info", TitledBorder.CENTER, TitledBorder.TOP));
        String[] header = { "Name", "Height", "Birth Year " };
        JTable table = new JTable(list, header);
        panel.add(new JScrollPane(table));
        frame.add(panel);
        frame.setSize(550, 400);
        frame.setVisible(true);
    }
}
