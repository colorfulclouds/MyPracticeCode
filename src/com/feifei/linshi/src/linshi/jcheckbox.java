package linshi;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

@SuppressWarnings("serial")
public class jcheckbox extends JPanel {
 
 public jcheckbox(){
  init(
		  );
  
 }

 private void init() {
  setLayout(new BorderLayout());
  JScrollPane scrollPane = new JScrollPane(createTable()); 
  add(scrollPane);
 }
 
 private JTable createTable() {
  JTable table = new JTable();
  String[] tableHeads = new String[]{"姓名","年龄","是否通过"};
        DefaultTableModel dtm = (DefaultTableModel)table.getModel();
  dtm.setColumnIdentifiers(tableHeads);

/*******添加的一些数据，也可以从数据库中提取数据*************/
  dtm.addRow(new Object[]{"aa","12",new Boolean(true)});
  dtm.addRow(new Object[]{"bb","34",new Boolean(false)});
  dtm.addRow(new Object[]{"aa","12",new Boolean(false)});
  dtm.addRow(new Object[]{"bb","34",new Boolean(false)});
  dtm.addRow(new Object[]{"aa","12",new Boolean(false)});
  dtm.addRow(new Object[]{"bb","34",new Boolean(false)});
  dtm.addRow(new Object[]{"aa","12",new Boolean(false)});
  dtm.addRow(new Object[]{"bb","34",new Boolean(false)});
  dtm.addRow(new Object[]{"aa","12",new Boolean(false)});
  dtm.addRow(new Object[]{"bb","34",new Boolean(false)});
  dtm.addRow(new Object[]{"aa","12",new Boolean(false)});
  dtm.addRow(new Object[]{"bb","34",new Boolean(false)});
  dtm.addRow(new Object[]{"aa","12",new Boolean(false)});
  dtm.addRow(new Object[]{"bb","34",new Boolean(false)});

/*****设置table的列模型****/
  TableColumnModel tcm = table.getColumnModel();
  tcm.getColumn(2).setCellEditor(new DefaultCellEditor(new JCheckBox()));    
        tcm.getColumn(2).setCellRenderer(new TestTableCellRenderer());     
        tcm.getColumn(2).setPreferredWidth(80);    
        tcm.getColumn(2).setWidth(80);    
        tcm.getColumn(2).setMaxWidth(80);    

return table;
 }

 public static void main(String[] args) {
  JFrame jframe = new JFrame();
  jframe.setBounds(300,100,300,200);
  jframe.setTitle("测试");
  jframe.add(new jcheckbox());
  jframe.setVisible(true);
 }

class TestTableCellRenderer extends JCheckBox implements TableCellRenderer{

  @Override
  public Component getTableCellRendererComponent(JTable table,
    Object value, boolean isSelected, boolean hasFocus, int row,
    int column) {
    Boolean b = (Boolean) value;    
             this.setSelected(b.booleanValue());    
             return this;    

  }
  
 }
}
