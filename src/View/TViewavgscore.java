package View;

import java.sql.*;

import java.awt.*;

import javax.swing.*;

import javax.swing.table.*;

import Util.DBUtil;

//各科平均分显示表
public class TViewavgscore extends JFrame{
	private JTable table;
	public   TViewavgscore(){
		
	}
	public  TViewavgscore(ResultSet rs){
		super("显示查询结果");
		String [] columnNames= {"课程号","课程名","平均分"};
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Administrator\\Pictures\\\u5DE5\u4F5C\\1.jpg"));
		Object[][] rowData = new Object[100000][5]; // 表格数据
		Connection con=DBUtil.getConnection();
		try {
			int count = 0;

			while (rs.next()) {// 遍历查询结果

				rowData[count][0] = rs.getString("cid"); // 初始化数组内容

				rowData[count][1] = rs.getString("cname");

				rowData[count][2] = rs.getString("Classavg");

				count++;

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Container container = getContentPane(); // 获取窗口容器

		table = new JTable(rowData, columnNames); // 实例化表格
		
		container.add(new JScrollPane(table), BorderLayout.EAST); // 增加组件

		setSize(500, 358); // 设置窗口尺寸
		setLocationRelativeTo(null);
		setVisible(true); // 设置窗口可视
		table.setBackground(new Color(250, 235, 215));

	}

	public  void init(ResultSet rs) {
		new  TViewavgscore(rs);
	}

}