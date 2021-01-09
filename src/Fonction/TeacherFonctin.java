package Fonction;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Util.DBUtil;
import View.TViewavgscore;
import View.TViewstudentSumscore;
import View.Viewstudentdata;

public class TeacherFonctin {
	
	//将教师用户输入JTextField框的信息作为参数 ，增加学员成绩
	public void addscore(JTextField textFieldId, JTextField textFieldName, JTextField textFieldCid,JTextField textFieldCname, JTextField textFieldGrade)  {
		// 获取连接
		Connection conn = DBUtil.getConnection();
		
		String sid = textFieldId.getText();
		String sname = textFieldName.getText();
		String cid = textFieldCid.getText();
		String cname = textFieldCname.getText();
		int grade = new Integer(textFieldGrade.getText());
		// sql
		String sql = "insert into score(sId,sname,cId,cname,grade)" + "values(" + "?,?,?,?,?)";
		// 预编译
		PreparedStatement ptmt;
		try {
			ptmt = conn.prepareStatement(sql);
			// 传参
			ptmt.setString(1, sid);
			ptmt.setString(2, sname);
			ptmt.setString(3,cid);
			ptmt.setString(4,cname);
			ptmt.setInt(5, grade);
			// 执行
			ptmt.execute();
			JOptionPane.showMessageDialog(null, "数据添加成功！", "提示", JOptionPane.WARNING_MESSAGE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "录入数据错误", "提示", JOptionPane.WARNING_MESSAGE);
		}
		
	}
	
	// 删除学号为id的学生某一门成绩（textField：学号，textField_1:课程号）
	public void delsId(JTextField textField,JTextField textField_1) {
		// 获取连接
		Connection conn = DBUtil.getConnection();
		String sql = "delete from score where sid=? and cid=?";
		String sql_1 = "select * from score where sid=? and cid=?";
		
		// 预编译
		PreparedStatement ptmt,ptmt_1;
		String id = textField.getText();
		String cid = textField_1.getText();
		try {
			ptmt_1 = conn.prepareStatement(sql_1);
			ptmt_1.setString(1, id);
			ptmt_1.setString(2, cid);
			ResultSet rs = ptmt_1.executeQuery();
			if(!rs.next()||rs.getString(1).equals("0")) {
				JOptionPane.showMessageDialog(null, "不存在此信息！", "提示", JOptionPane.WARNING_MESSAGE);
			}
			else {
			ptmt = conn.prepareStatement(sql);
			// 传参
			ptmt.setString(1, id);
			ptmt.setString(2, cid);
			// 执行
			ptmt.execute();
			JOptionPane.showMessageDialog(null, "删除成功！", "提示", JOptionPane.WARNING_MESSAGE);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "不存在此信息！", "提示", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	// 删除学号为id的学生的信息和成绩（textField：学号）
	public void delId(JTextField textField)  {
		// 获取连接
		Connection conn = DBUtil.getConnection();
		String sql1 = "delete from studentdata where id=?";
		String sql2 = "delete from score where sid=?";
		String id = textField.getText();
		PreparedStatement ptmt1, ptmt2;
		try {
			// 预编译
			ptmt1 = conn.prepareStatement(sql1);
			ptmt2 = conn.prepareStatement(sql2);
			// 传参
			ptmt1.setString(1, id);
			ptmt2.setString(1, id);
			// ִ执行
			ptmt1.execute();
			ptmt2.execute();
			JOptionPane.showMessageDialog(null, "删除该学生信息和成绩完成！", "提示", JOptionPane.WARNING_MESSAGE);
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "要删除的学生数据已不存在", "提示", JOptionPane.WARNING_MESSAGE);
		}
		
	}
	
	//查看所有学生信息
	public void getAllstudent() throws IOException, SQLException{
	     //获取连接
	     Connection conn = DBUtil.getConnection();
	     //sql
	     String sql = "select * from studentdata";
	     //预编译
	     PreparedStatement ptmt = conn.prepareStatement(sql);
	     //ִ执行
	     ResultSet rs = ptmt.executeQuery();
	     new Viewstudentdata(rs);//显示学生信息的表
	
	 }
	
	//获取各科的平均分
	public void getClassavgscore() throws IOException, SQLException{
	     //获取连接
	     Connection conn = DBUtil.getConnection();
	     //sql
	     String sql = "select cid,cname,avg(grade) as Classavg from score  group by cid order by Classavg DESC";
	     //预编译
	     PreparedStatement ptmt = conn.prepareStatement(sql);
	     //ִ执行
	     ResultSet rs = ptmt.executeQuery();
		new TViewavgscore().init(rs);//显示各科平均分的表
	 }
	
	
	//获取各学生总分并从大到小排序
	public void getStudentsumscore() throws IOException, SQLException{
	     //获取连接
	     Connection conn = DBUtil.getConnection();
	     //sql
	     String sql = "select sid,sname,sum(grade) as Studentsum from score  group by sid order by Studentsum DESC";
	     //预编译
	     PreparedStatement ptmt = conn.prepareStatement(sql);
	     //ִ执行
	     ResultSet rs = ptmt.executeQuery();
	     new TViewstudentSumscore().init(rs);//显示所有学生总分的表
	 }
	
	//录入学生信息
	public void addstudentdata(JTextField textFieldId, JTextField textFieldName, JTextField textFieldsex,JTextField textFieldage, JTextField textFieldphone,JTextField textFieldmajor)  {
		// 获取连接
		Connection conn = DBUtil.getConnection();
		
		String id = textFieldId.getText();
		String name = textFieldName.getText();
		String sex = textFieldsex.getText();
		int age = new Integer(textFieldage.getText());
		String phone = textFieldphone.getText();
		String major = textFieldmajor.getText();
		// sql
		String sql = "insert into studentdata(id,name,sex,age,phone,major)" + "values(" + "?,?,?,?,?,?)";
		// 预编译
		PreparedStatement ptmt;
		try {
			ptmt = conn.prepareStatement(sql);
			// 传参
			ptmt.setString(1, id);
			ptmt.setString(2, name);
			ptmt.setString(3,sex);
			ptmt.setInt(4, age);
			ptmt.setString(5,phone);
			ptmt.setString(6,major);
			// 执行
			ptmt.execute();
			JOptionPane.showMessageDialog(null, "数据添加成功！", "提示", JOptionPane.WARNING_MESSAGE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "数据已存在！", "提示", JOptionPane.WARNING_MESSAGE);
		}
	}
		
	
		//修改学生信息（利用id查询后，将用户输入的新的信息更新到数据库中）
		public void Alterstudentdata(JTextField textFieldId, JTextField textFieldName, JTextField textFieldsex,JTextField textFieldage, JTextField textFieldphone,JTextField textFieldmajor)  {
			// 获取连接
			Connection conn = DBUtil.getConnection();
			
			String tid = textFieldId.getText();
			String name = textFieldName.getText();
			String sex = textFieldsex.getText();
			int age =Integer.parseInt(textFieldage.getText());
			String phone = textFieldphone.getText();
			String major = textFieldmajor.getText();
			// sql
			String sql = "update studentdata set name=?,sex=?,age=?,phone=?,major=? where id=?";
			// 预编译
			PreparedStatement ptmt;
			try {
				ptmt = conn.prepareStatement(sql);
				// 传参
				ptmt.setString(1, name);
				ptmt.setString(2,sex);
				ptmt.setInt(3, age);
				ptmt.setString(4,phone);
				ptmt.setString(5,major);
				ptmt.setString(6,tid);
				// 执行
				ptmt.execute();
				JOptionPane.showMessageDialog(null, "数据修改成功！", "提示", JOptionPane.WARNING_MESSAGE);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "数据错误", "提示", JOptionPane.WARNING_MESSAGE);
			}
		
	}

}
