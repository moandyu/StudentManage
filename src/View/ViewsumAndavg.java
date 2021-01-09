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
//显示学生总成绩和平均分表
public class ViewsumAndavg extends JFrame {
	private JTable table;

	public ViewsumAndavg() {
		
	}

	public ViewsumAndavg(ResultSet rs, ResultSet rs_1) {
		super("显示查询结果");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Administrator\\Pictures\\\u5DE5\u4F5C\\1.jpg"));
		String[] columnNames = { "总成绩", "平均成绩" };
		Object[][] rowData = new Object[1][2]; // 表格数据
		Connection con = DBUtil.getConnection();
		try {
			int count = 0;

			while (rs.next()) {
				rowData[count][0] = rs.getString("sum"); // 初始化数组内容
			}
			while (rs_1.next()) {
				rowData[count][1] = rs_1.getString("average");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Container container = getContentPane(); // 获取窗口容器

		table = new JTable(rowData, columnNames); // 实例化表格

		container.add(new JScrollPane(table), BorderLayout.EAST); // 增加组件

		setSize(500, 100); // 设置窗口尺寸
		setLocationRelativeTo(null);
		setVisible(true); // 设置窗口可视
		table.setBackground(new Color(250, 235, 215));
	}

	public void init(ResultSet rs, ResultSet rs_1) {
		new ViewsumAndavg(rs, rs_1);
	}

}