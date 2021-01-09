package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 加载JDBC-MySQL数据库驱动程序
 * 进行对数据库的连接操作
 * 
 *
 */
public class DBUtil {
	protected static String driverName="com.mysql.cj.jdbc.Driver";
	protected static String uri="jdbc:mysql:///student?useSSL=true&serverTimezone=UTC";
	protected static String user="root";//用户名
	protected static String password="123456";//密码
    private static Connection conn = null;
    static{
        try {
           // 1.加载JDBC-MySQL数据库驱动程序
		Class.forName(driverName);
			//2. 与数据库建立连接
            conn = DriverManager.getConnection(uri, user, password);
    
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   
    /**
     * @return 可进行调用，与数据库建立连接
     */
    public static Connection getConnection(){
        return conn;
    }
}
