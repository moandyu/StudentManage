package View;

import java.sql.*;

import java.awt.*;

import javax.swing.*;

import javax.swing.table.*;

import Util.DBUtil;

//����ƽ������ʾ��
public class TViewavgscore extends JFrame{
	private JTable table;
	public   TViewavgscore(){
		
	}
	public  TViewavgscore(ResultSet rs){
		super("��ʾ��ѯ���");
		String [] columnNames= {"�γ̺�","�γ���","ƽ����"};
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Administrator\\Pictures\\\u5DE5\u4F5C\\1.jpg"));
		Object[][] rowData = new Object[100000][5]; // �������
		Connection con=DBUtil.getConnection();
		try {
			int count = 0;

			while (rs.next()) {// ������ѯ���

				rowData[count][0] = rs.getString("cid"); // ��ʼ����������

				rowData[count][1] = rs.getString("cname");

				rowData[count][2] = rs.getString("Classavg");

				count++;

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Container container = getContentPane(); // ��ȡ��������

		table = new JTable(rowData, columnNames); // ʵ�������
		
		container.add(new JScrollPane(table), BorderLayout.EAST); // �������

		setSize(500, 358); // ���ô��ڳߴ�
		setLocationRelativeTo(null);
		setVisible(true); // ���ô��ڿ���
		table.setBackground(new Color(250, 235, 215));

	}

	public  void init(ResultSet rs) {
		new  TViewavgscore(rs);
	}

}