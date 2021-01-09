package Fonction;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Util.DBUtil;

//账号密码
public class Password {
	//判断能否登录
	public boolean init(String userId, String password) {
		//建立数据库连接
		Connection conn = DBUtil.getConnection();
		//设置sql语句
		String sql = "select password from userdata where user=?";
		try {
			//预编译
			PreparedStatement ptmt = conn.prepareStatement(sql);
			//传参
			ptmt.setString(1, userId);
			//执行sql语句，并将执行结果返回给结果集rs
			ResultSet rs = ptmt.executeQuery();
			
			while (rs.next()) {
				//判断数据库的搜索结果是否和用户输入的密码一致
				if (rs.getString("password").equals(password)) {
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	//注册
	public void Rejest(String newuserId, String newpassword) {
		//建立数据库联系
		Connection conn = DBUtil.getConnection();
		//数据库插入的SQL语句
		String sql = "insert into userdata(user,password) values(?,?)";
		try {
			//预编译
			PreparedStatement ptmt = conn.prepareStatement(sql);
			//传参
			ptmt.setString(1, newuserId);
			ptmt.setString(2, newpassword);
			//执行
			ptmt.execute();
			//提示信息
			JOptionPane.showMessageDialog(null, "注册成功！", "提示", JOptionPane.WARNING_MESSAGE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "该用户已存在，注册失败请重新注册！", "提示", JOptionPane.WARNING_MESSAGE);
		}
	}

}
