package linshi;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.Component;
import java.awt.Color;

class MyTableModel extends AbstractTableModel {
    //实始化table数据
   //列名
   String[] columnNames  = {"Name", "Age", "Sex"};
    
    String[][] columnData = { {"Bob", "23" , "M"},  
                              {"Claire", "99", "F"}, 
                              {"Spot", "7", "F"},
                              {"Phil", "69", "M"}
                             };
    
    //实现必须方法
   public Object getValueAt(int row, int col) {
       return columnData[row][col];
    }
    public String getColumnName(int col) { return columnNames[col];}
    public int getColumnCount() { return columnNames.length;}
    public int getRowCount() { return columnData.length; }
}

class MyCellRenderer extends DefaultTableCellRenderer {

    public Component getTableCellRendererComponent
        (JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {

        // Obtains default cell settings
        Component cell = super.getTableCellRendererComponent 
               ( table, value,isSelected, hasFocus, row, column);
        
        //指定行的颜色
       if (row % 2 == 0) cell.setBackground(Color.red);
        else cell.setBackground(Color.gray);

        //if (column % 2 == 0) cell.setBackground(Color.green);
        //列数的颜色
       if(column==1) cell.setBackground(Color.orange);
        return cell;
    }
    
}

class table_color extends JFrame {

	table_color() {

        final MyCellRenderer mcr = new MyCellRenderer();

        JTable myTable = new JTable(new MyTableModel()) {
            public TableCellRenderer getCellRenderer
              (int row, int column) {
                return mcr;
            }
        };

        getContentPane().add(new JScrollPane(myTable));
        setSize(640, 480);
        show();
    }
    public static void main(String args[]) {
        new table_color();
    }
}

