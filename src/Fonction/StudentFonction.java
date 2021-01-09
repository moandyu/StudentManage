package Fonction;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Util.DBUtil;
import View.Viewscore;
import View.Viewstudentdata;
import View.ViewsumAndavg;

public class StudentFonction {
	// 查询个人信息
	public void getStudent(String Id) throws IOException, SQLException {
		// 获取连接
		Connection conn = DBUtil.getConnection();
		// sql
		String sql = "select * from studentdata where Id=?";
		// 预编译
		PreparedStatement ptmt = conn.prepareStatement(sql);

		try {
			// 传参
			ptmt.setString(1, Id);
			// 执行
			ResultSet rs = ptmt.executeQuery();
			//学生信息查询结果表
			new Viewstudentdata().init(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 查询成绩
	public void getScore(String sId) throws IOException, SQLException {
		// 获取连接
		Connection conn = DBUtil.getConnection();
		// sql
		String sql = "select * from score where sId=?";
		// 预编译
		PreparedStatement ptmt = conn.prepareStatement(sql);
		// 传参
		try {
			ptmt.setString(1, sId);
			// ִ执行
			ResultSet rs = ptmt.executeQuery();
			//成绩查询结果显示表
			new Viewscore().init(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	// 计算总成绩
	public void getsumAndavg(String sId) throws IOException, SQLException {
		// 获取连接
		Connection conn = DBUtil.getConnection();
		// sql语句计算总分与平均分
		String sql = "select SUM(grade) as sum from score where sId=?";
		String sql_1 = "select avg(grade) as average from score where sId=?";
		// 预编译
		PreparedStatement ptmt = conn.prepareStatement(sql);
		PreparedStatement ptmt_1 = conn.prepareStatement(sql_1);

		// 传参
		try {
			ptmt.setString(1, sId);
			ptmt_1.setString(1, sId);
			// 执行
			ResultSet rs = ptmt.executeQuery();
			ResultSet rs_1 = ptmt_1.executeQuery();
			//总分与平均分显示图
			new ViewsumAndavg().init(rs,rs_1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
