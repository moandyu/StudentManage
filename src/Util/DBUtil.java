package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ����JDBC-MySQL���ݿ���������
 * ���ж����ݿ�����Ӳ���
 * 
 *
 */
public class DBUtil {
	protected static String driverName="com.mysql.cj.jdbc.Driver";
	protected static String uri="jdbc:mysql:///student?useSSL=true&serverTimezone=UTC";
	protected static String user="root";//�û���
	protected static String password="123456";//����
    private static Connection conn = null;
    static{
        try {
           // 1.����JDBC-MySQL���ݿ���������
		Class.forName(driverName);
			//2. �����ݿ⽨������
            conn = DriverManager.getConnection(uri, user, password);
    
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   
    /**
     * @return �ɽ��е��ã������ݿ⽨������
     */
    public static Connection getConnection(){
        return conn;
    }
}
