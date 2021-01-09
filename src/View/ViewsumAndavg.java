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
//��ʾѧ���ܳɼ���ƽ���ֱ�
public class ViewsumAndavg extends JFrame {
	private JTable table;

	public ViewsumAndavg() {
		
	}

	public ViewsumAndavg(ResultSet rs, ResultSet rs_1) {
		super("��ʾ��ѯ���");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Administrator\\Pictures\\\u5DE5\u4F5C\\1.jpg"));
		String[] columnNames = { "�ܳɼ�", "ƽ���ɼ�" };
		Object[][] rowData = new Object[1][2]; // �������
		Connection con = DBUtil.getConnection();
		try {
			int count = 0;

			while (rs.next()) {
				rowData[count][0] = rs.getString("sum"); // ��ʼ����������
			}
			while (rs_1.next()) {
				rowData[count][1] = rs_1.getString("average");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Container container = getContentPane(); // ��ȡ��������

		table = new JTable(rowData, columnNames); // ʵ�������

		container.add(new JScrollPane(table), BorderLayout.EAST); // �������

		setSize(500, 100); // ���ô��ڳߴ�
		setLocationRelativeTo(null);
		setVisible(true); // ���ô��ڿ���
		table.setBackground(new Color(250, 235, 215));
	}

	public void init(ResultSet rs, ResultSet rs_1) {
		new ViewsumAndavg(rs, rs_1);
	}

}