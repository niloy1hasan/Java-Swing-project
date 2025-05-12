package res.Components;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class TablePanel extends JTable {
    public TablePanel(String[][] data, String[] columns){
        super(data, columns);
        setRowHeight(30);
        setFont(new Font("Arial", Font.PLAIN, 12));
        setGridColor(Color.gray);
        setShowVerticalLines(false);
        setShowHorizontalLines(true);

        DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < getColumnCount(); i++){
            getColumnModel().getColumn(i).setCellRenderer(center);
        }

        JTableHeader header = getTableHeader();
        header.setFont(new Font("SansSerif", Font.BOLD, 13));
        header.setBackground(new Color(180, 180, 255));
        header.setForeground(Color.BLACK);
    }
}
