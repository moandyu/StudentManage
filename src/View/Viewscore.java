package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Util.DBUtil;
//显示学生成绩查询结果表
public class Viewscore extends JFrame{
	
	JTable table;//表
	public  Viewscore () {
		
	}
	public  Viewscore (ResultSet rs) {
		String [] columnNames= {"学号","姓名","课程号","课程名","成绩"};// 定义列名
		Object [][] rowData = new Object[50][6];
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Administrator\\Pictures\\\u5DE5\u4F5C\\1.jpg"));
		try{
			Connection conn = DBUtil.getConnection();
			int count = 0;
			while (rs.next()) {
					rowData[count][0] = rs.getString("sid");
					rowData[count][1] = rs.getString("sname");
					rowData[count][2] = rs.getString("cid");
					rowData[count][3] = rs.getString("cname");
					rowData[count][4] = rs.getString("grade");
					count++;
				}
			}catch(
				SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		Container container = getContentPane();// 获取窗口容器
		table=new JTable(rowData,columnNames);// 实例化表格
		container.add(new JScrollPane(table),BorderLayout.CENTER);// 增加组件
		setVisible(true);
		setSize(720, 521);
		setLocationRelativeTo(null);
		table.setBackground(new Color(250, 235, 215));
	}
	
	public  void init(ResultSet rs) {
		new Viewscore(rs);
	}
	
}