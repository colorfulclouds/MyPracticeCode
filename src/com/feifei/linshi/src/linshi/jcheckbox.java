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
  String[] tableHeads = new String[]{"����","����","�Ƿ�ͨ��"};
        DefaultTableModel dtm = (DefaultTableModel)table.getModel();
  dtm.setColumnIdentifiers(tableHeads);

/*******��ӵ�һЩ���ݣ�Ҳ���Դ����ݿ�����ȡ����*************/
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

/*****����table����ģ��****/
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
  jframe.setTitle("����");
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
