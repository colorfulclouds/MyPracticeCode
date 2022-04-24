package curriculum_design_manager;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class booktype_operate extends JPanel{

	private String id;//保留管理员的账号 操作属于自己的那一部分数据
	private String psd;//保留管理员的密码  操作属于自己的那一部分数据
	
	String [] mode = new String[]{"查看","修改","增加","删除"};
	
	String sql;//sql语句
	Statement stm;
	ResultSet rs ;//接收结果元组
	
	DefaultTableModel dtl = new DefaultTableModel();
	JTable table;//存放信息的表格
	JScrollPane jsp_booktype ;//让信息能够显示完
	
	JPanel btn_jpl = new JPanel();
	ButtonGroup bg = new ButtonGroup();//按钮群组   按钮只有一个有效果
	JRadioButton []jrb = new JRadioButton[4] ;//增、删、改、查按钮
	
	//确定、 取消按钮
	JPanel yes_no = new JPanel();//承载确定、取消按钮的panel组件
	JButton yes = new JButton("确定");
	JButton no = new JButton("取消");
	private int flag = 0;//标记选择的哪个功能 提供给确定、取消按钮使用
						 //修改 flag = 1
						 //增加flag = 2
						 //删除flag = 3
	
	JLabel prompt = new JLabel(new ImageIcon("booktype.png"));//提示新的图书类型
	JPanel add_panel = new JPanel();//在添加图书类型时候 使用的组件容器
	Vector <JTextField>vec_add_jta_booktype = new Vector();//添加图书类型信息的文本框
	Vector vec_add_jll_booktype = new Vector();//增加图书类型信息的标签
	
	Vector <Integer>vec_delete = new Vector();//删除功能使用//=====
	int port ;//记录指定的行 为了给删除使用//=========
	
	String[] title = {"类型编号","类型描述","可借天数"};

	public booktype_operate(String id, String psd) {
		
		//放置添加的图书类型信息的容器
		add_panel.setLayout(new GridLayout(2,3,5,15));//编号不用添加
		
		//提示新的图书类型的位置设置
		prompt.setBounds(25, 80, 60, 60);
		add(prompt);
		
		//添加提示3个标签
		for(int i = 0;i<3;i++){
			
			vec_add_jll_booktype.add(new JLabel(title[i]));//增加标签到容器中
			vec_add_jta_booktype.add(new JTextField());//增加需要增加的文本框到容器中
			
		}
		
		//添加标签  从容器中取出来后放置
		for(int i = 0;i<3;i++)			
			add_panel.add((Component) vec_add_jll_booktype.get(i));
		
		//添加文本框  从容器中取出来后
		for(int i = 0;i<3;i++)
			add_panel.add((Component) vec_add_jta_booktype.get(i));
			
		add_panel.setBounds(95, 70, 865, 80);//添加图书类型信息的设置位置
		add(add_panel);
		prompt.setVisible(false);//提示标签的可见性（只有在添加图书类型信息的时候  可见）
		add_panel.setVisible(false);//添加各种图书类型信息的可见性（只有在添加图书类型信息的时候  可见）
		
		
		table = new JTable(dtl){
			@Override
			//第一列的图书类型编号不能够修改
			public boolean isCellEditable(int rowindex,int colindex){
			    if (colindex == 0 || colindex == 3) return false; 
			    return true;
			 } 
		};//存放信息的表格
		table.getTableHeader().setReorderingAllowed(false);   //不可整列移动   
//		table.getTableHeader().setResizingAllowed(false);   //不可拉动表格宽度不可以变化
		table.setRowHeight(20);//设置表格的行高
		
		//表格监听  当删除的时候使用//=======
				table.addMouseListener(new MouseAdapter() {
					
					public void mousePressed(MouseEvent e) {

						if(flag == 3){//在删除功能的时候  才有效果
							port = table.rowAtPoint(e.getPoint());
							System.out.println(port);
							
							if(dtl.getValueAt(port, 3) != "√"){
								dtl.setValueAt("√",port , 3);
								vec_delete.add(port);//将准备删除的记录下来
							}
								
							//说明已经点击过了 再点击就要去除删除了
							else{
								vec_delete.remove(new Integer(port));//删除这个已经选择的  说明不删除了
								dtl.setValueAt("",port , 3);
							}
								
						}
						
					}
				});
				//=========
		
		
		jsp_booktype = new JScrollPane(table);//让信息能够显示完
		table.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);//表格失去焦点的时候 可以即使保存数据

		
		//确定、取消 按钮的位置设置
		yes_no.setLayout(new GridLayout(1, 2));//刚好放置两个按钮
		//按钮透明效果
		yes.setOpaque(false);
		yes.setBackground(Color.pink);
		//按钮透明效果
		no.setOpaque(false);
		no.setBackground(Color.pink);
		yes_no.add(yes);
		yes_no.add(no);
		yes_no.setBounds(25, 580, 935, 50);
		add(yes_no);
		yes_no.setVisible(false);//除了查看之外的所有情况下  均出现这组按钮
		
		//增加到表格中
		for(int i = 0;i<3;i++)
			dtl.addColumn(title[i]);
		table.setEnabled(false);//让表格不可编辑
		table.setRowHeight(20);//设置表格的行高
		jsp_booktype.setBounds(25, 165, 935, 400);
		add(jsp_booktype);
		
		this.id = id;
		this.psd = psd;
		stm = new LMS_connect().getStatement();//获取数据库
		setLayout(null);//清空布局管理
		
		
		
		//设置放置单选按钮的panel的布局管理
		btn_jpl.setLayout(new GridLayout(1, 4));
		btn_jpl.setBounds(150, 20, 700, 50);
		
		//初始化按钮
		for(int i = 0;i<4;i++){
			
			jrb[i] = new JRadioButton(mode[i]);
			jrb[i].setFont(new Font("隶书", 10, 30));
			bg.add(jrb[i]);//加到按钮群组中 保证只有一个按钮有效果
			btn_jpl.add(jrb[i]);//放置在按钮panel中
			
		}
		
		//一开始 显示出来
		{
			//每次的查询都清空原来的表格
			for(int i = dtl.getRowCount()-1;i>=0;i--)
				dtl.removeRow(i);
			
			sql = "select * from LMS_booktype ";//查询语句
			try {
				rs = stm.executeQuery(sql);
				while(rs.next()){
					Vector v = new Vector();
					v.add(rs.getString("LMS_typeid"));
					v.add(rs.getString("LMS_typename"));
					v.add(rs.getString("LMS_typedays"));
					dtl.addRow(v);
				}
			} 
			catch (SQLException e1) {
				e1.printStackTrace();
				System.out.println("sql error");
			}
		}
		
		//查看按钮的监听
		jrb[0].addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				//各种可见性,以及不可见性
				yes_no.setVisible(false);//除了查看之外的所有情况下  均出现这组按钮
				table.setEnabled(false);//继续关闭可编辑性
				prompt.setVisible(false);//提示标签的可见性（只有在添加图书信息的时候  可见）
				add_panel.setVisible(false);//添加各种信息的可见性（只有在添加图书信息的时候  可见）
				
				
				//每次的查询都清空原来的表格
				for(int i = dtl.getRowCount()-1;i>=0;i--)
					dtl.removeRow(i);
				
				sql = "select * from LMS_booktype";//查询语句
				try {
					rs = stm.executeQuery(sql);
					while(rs.next()){
						Vector v = new Vector();
						v.add(rs.getString("LMS_typeid"));
						v.add(rs.getString("LMS_typename"));
						v.add(rs.getString("LMS_typedays"));
						dtl.addRow(v);
					}
				} 
				catch (SQLException e1) {
					e1.printStackTrace();
					System.out.println("sql error");
				}
				
			}
		});
		
		//修改按钮的监听
		jrb[1].addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				//每次修改前 都需要打印数据库所有的数据
				for(int i = dtl.getRowCount()-1;i>=0;i--)
					dtl.removeRow(i);
				
				sql = "select * from LMS_booktype";//查询语句
				try {
					rs = stm.executeQuery(sql);
					while(rs.next()){
						Vector v = new Vector();
						v.add(rs.getString("LMS_typeid"));
						v.add(rs.getString("LMS_typename"));
						v.add(rs.getString("LMS_typedays"));
						dtl.addRow(v);
					}
				} 
				catch (SQLException e1) {
					e1.printStackTrace();
					System.out.println("sql error");
				}
				
				
				flag = 1;
				yes_no.setVisible(true);//除了查看之外的所有情况下  均出现这组按钮
				table.setEnabled(true);//让表格可以编辑
				prompt.setVisible(false);//提示标签的可见性（只有在添加图书信息的时候  可见）
				add_panel.setVisible(false);//添加各种信息的可见性（只有在添加图书信息的时候  可见）

			}
		});
		
		//增加按钮的监听
		jrb[2].addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
		
				//每次增加钱 都查看数据中所有的图书类型信息
				for(int i = dtl.getRowCount()-1;i>=0;i--)
					dtl.removeRow(i);
				
				sql = "select * from LMS_booktype";//查询语句
				try {
					rs = stm.executeQuery(sql);
					while(rs.next()){
						Vector v = new Vector();
						v.add(rs.getString("LMS_typeid"));
						v.add(rs.getString("LMS_typename"));
						v.add(rs.getString("LMS_typedays"));
						dtl.addRow(v);
					}
				} 
				catch (SQLException e1) {
					e1.printStackTrace();
					System.out.println("sql error");
				}
				
				flag = 2;
				yes_no.setVisible(true);
				table.setEnabled(false);//让表格不可编辑
				prompt.setVisible(true);//提示标签的可见性（只有在添加图书信息的时候  可见）
				add_panel.setVisible(true);//添加各种信息的可见性（只有在添加图书信息的时候  可见）
			}
		});
		
		//删除按钮的监听
		jrb[3].addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				//每次删除前 都查看数据中所有的图书类型信息
				for(int i = dtl.getRowCount()-1;i>=0;i--)
					dtl.removeRow(i);
				
				sql = "select * from LMS_booktype";//查询语句
				try {
					rs = stm.executeQuery(sql);
					while(rs.next()){
						Vector v = new Vector();
						v.add(rs.getString("LMS_typeid"));
						v.add(rs.getString("LMS_typename"));
						v.add(rs.getString("LMS_typedays"));
						dtl.addRow(v);
					}
				} 
				catch (SQLException e1) {
					e1.printStackTrace();
					System.out.println("sql error");
				}
				
				//====================
				
				if(dtl.getColumnCount() <= 3)//在超过范围后就不在出现了//====
					dtl.addColumn("已选中");//======
				//恢复点走的时候的状态
				if(dtl.getColumnCount() > 3){
					for(int i = 0;i<vec_delete.size();i++)
						table.setValueAt("√", vec_delete.get(i), 3);
				}
				//====================
				
				flag = 3;
				yes_no.setVisible(true);
				table.setEnabled(false);//让表格不可编辑
				prompt.setVisible(false);//提示标签的可见性（只有在添加图书信息的时候  可见）
				add_panel.setVisible(false);//添加各种信息的可见性（只有在添加图书信息的时候  可见）
				
			}
		});
		
		//确定按钮
		yes.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				//执行的是监听修改的功能 将修改后的内容提交给数据库
				if(flag == 1){
					for(int i = 0 ;i<dtl.getRowCount();i++){
						
						Vector v = new Vector();//存储每一行的内容
						for(int j = 1;j<3;j++)
							v.add(table.getValueAt(i, j));
						/*
						 * "类型编号","类型描述","可借天数"
						 */
						sql = "update LMS_booktype set "+
							" LMS_typename = '"+v.get(0)+"', LMS_typedays = '"+v.get(1)+"' where LMS_typeid = '"+table.getValueAt(i, 0)+"'";
						try {
							stm.executeUpdate(sql);
							
						}
						catch (SQLException e1) {
							e1.printStackTrace();
							System.out.println("sql error");
						}
					}
					JOptionPane.showConfirmDialog(null, "修改成功!", "恭喜", JOptionPane.DEFAULT_OPTION);
				}
				
				//执行的是监听增加的功能  将增加的新图书类型的内容提交给数据库
				if(flag == 2){
				
					sql = "insert into LMS_booktype values('"+vec_add_jta_booktype.get(0).getText()+"','"+vec_add_jta_booktype.get(1).getText()+"' , "+
						" '"+vec_add_jta_booktype.get(2).getText()+"')";
					
					try {
						stm.executeUpdate(sql);
						
						for(int i = 0;i<3;i++)//增加完一个后 清空图书类型信息文本框
							vec_add_jta_booktype.get(i).setText("");
						
					} 
					catch (SQLException e1) {
					
						e1.printStackTrace();
//						JOptionPane.showMessageDialog(null, "已经存在!", "错误!", JOptionPane.ERROR_MESSAGE);
						System.out.println("sql error");
					}
				}
				
				//执行监听删除的功能
				if(flag == 3){
					int ii = 0;
					//开始删除
					for(int i = 0;i<vec_delete.size();i++){
						
						sql = "delete from LMS_booktype where LMS_typeid  = '"+table.getValueAt(vec_delete.get(i), 0)+"' ";
						
						try {
							ii = stm.executeUpdate(sql);
						} 
						catch (SQLException e1) {
//							e1.printStackTrace();
							System.out.println("sql error");
						}
					}
					
					
					if(vec_delete.size() != 0)//不为0  说明有过删除过东西
						if(ii != 0)//要删除的图书类型 正在借出去 那就不能删除 
							JOptionPane.showMessageDialog(null, "删除成功!", "恭喜!", JOptionPane.DEFAULT_OPTION);
					
					vec_delete.removeAllElements();//完了之后 还要进行删除
					//确定之后 更新显示删除表格的显示
					for(int i = dtl.getRowCount()-1;i>=0;i--)
						dtl.removeRow(i);
					
					sql = "select * from LMS_booktype ";//查询语句
					try {
						rs = stm.executeQuery(sql);
						while(rs.next()){
							Vector v = new Vector();
							v.add(rs.getString("LMS_typeid"));
							v.add(rs.getString("LMS_typename"));
							v.add(rs.getString("LMS_typedays"));
							dtl.addRow(v);
						}
					} 
					catch (SQLException e1) {
						e1.printStackTrace();
						System.out.println("sql error");
					}
				}
			}
		});
		
		//取消按钮
		no.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//修改的取消功能
				if(flag == 1){
					for(int i = dtl.getRowCount()-1;i>=0;i--)
						dtl.removeRow(i);
					
					sql = "select * from LMS_booktype";//查询语句
					try {
						rs = stm.executeQuery(sql);
						while(rs.next()){
							Vector v = new Vector();
							v.add(rs.getString("LMS_typeid"));
							v.add(rs.getString("LMS_typename"));
							v.add(rs.getString("LMS_typedays"));
							dtl.addRow(v);
						}
					} 
					catch (SQLException e1) {
//						e1.printStackTrace();
						System.out.println("sql error");
					}
				}
				
				//增加的取消功能
				if(flag == 2){
					
					for(int i = 0;i<12;i++)
						vec_add_jta_booktype.get(i).setText("");
				}
				
				//删除的取消功能
				if(flag == 3){
					
					vec_delete.removeAllElements();//取消那就清空所有的信息
					for(int i = dtl.getRowCount()-1;i>=0;i--)//把标记全部全部去除
						dtl.setValueAt("", i, 3);
				}
				
			}
		});
		
		add(btn_jpl);
		
	}
	
}
