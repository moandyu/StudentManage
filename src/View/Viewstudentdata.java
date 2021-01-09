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
//��ʾѧ����Ϣ��
public class Viewstudentdata extends JFrame {
	
	JTable table;
	public Viewstudentdata() {

	}
	public Viewstudentdata(ResultSet rs) {
		String[] columnNames = {"ѧ��","����","�Ա�","����","�绰����","רҵ"};// ��������
		Object [][] rowData = new Object[1000][6];
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Administrator\\Pictures\\\u5DE5\u4F5C\\1.jpg"));
		try{
			Connection conn = DBUtil.getConnection();
			int count = 0;
			while (rs.next()) {
					rowData[count][0] = rs.getString("id");
					rowData[count][1] = rs.getString("name");
					rowData[count][2] = rs.getString("sex");
					rowData[count][3] = rs.getString("age");
					rowData[count][4] = rs.getString("phone");
					rowData[count][5] = rs.getString("major");
					count++;
				}
			}catch(
				SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		Container container = getContentPane();// ��ȡ��������
		table=new JTable(rowData,columnNames);// ʵ�������
		container.add(new JScrollPane(table),BorderLayout.CENTER);// �������
		setVisible(true);
		setSize(720, 521);
		setLocationRelativeTo(null);
		table.setBackground(new Color(250, 235, 215));
	}
	public  void init(ResultSet rs) {
		new Viewstudentdata(rs);
	}
}

