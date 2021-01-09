package Fonction;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Util.DBUtil;

//�˺�����
public class Password {
	//�ж��ܷ��¼
	public boolean init(String userId, String password) {
		//�������ݿ�����
		Connection conn = DBUtil.getConnection();
		//����sql���
		String sql = "select password from userdata where user=?";
		try {
			//Ԥ����
			PreparedStatement ptmt = conn.prepareStatement(sql);
			//����
			ptmt.setString(1, userId);
			//ִ��sql��䣬����ִ�н�����ظ������rs
			ResultSet rs = ptmt.executeQuery();
			
			while (rs.next()) {
				//�ж����ݿ����������Ƿ���û����������һ��
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
	
	//ע��
	public void Rejest(String newuserId, String newpassword) {
		//�������ݿ���ϵ
		Connection conn = DBUtil.getConnection();
		//���ݿ�����SQL���
		String sql = "insert into userdata(user,password) values(?,?)";
		try {
			//Ԥ����
			PreparedStatement ptmt = conn.prepareStatement(sql);
			//����
			ptmt.setString(1, newuserId);
			ptmt.setString(2, newpassword);
			//ִ��
			ptmt.execute();
			//��ʾ��Ϣ
			JOptionPane.showMessageDialog(null, "ע��ɹ���", "��ʾ", JOptionPane.WARNING_MESSAGE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "���û��Ѵ��ڣ�ע��ʧ��������ע�ᣡ", "��ʾ", JOptionPane.WARNING_MESSAGE);
		}
	}

}
