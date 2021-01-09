package Login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Fonction.StudentFonction;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.Toolkit;


//学生用户管理
public class StudentLogin extends JFrame {
	Scanner scan=new Scanner(System.in);
	
	private JPanel contentPane;
	private JTextField textField;
	private final JButton btnNo = new JButton("退出");
	/**
	 * Launch the application.
	 */
	
	public void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentLogin frame = new StudentLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StudentLogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Administrator\\Pictures\\\u5DE5\u4F5C\\1.jpg"));
		setBackground(new Color(255, 192, 203));
		setTitle("学生管理页面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口退出程序
		setBounds(100, 100, 532, 175);//设置大小和位置
		contentPane = new JPanel();//创建面板
		contentPane.setBackground(new Color(250, 235, 215));//设置颜色
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);//窗口显示居中
		JButton btnA = new JButton("基本信息查询");
		btnA.addActionListener(new ActionListener() {//基本信息查询按钮事件
			public void actionPerformed(ActionEvent e) {
				String Id=textField.getText();
				try {
					new StudentFonction().getStudent(Id);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnA.setBounds(162, 63, 124, 23);
		contentPane.add(btnA);
		
		JButton btnB = new JButton("成绩查询");
		btnB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//成绩查询按钮事件
				String sId=textField.getText();//获得学号
				try {
					new StudentFonction().getScore(sId);
			
					 new StudentFonction().getsumAndavg(sId);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnB.setBounds(329, 63, 124, 23);
		contentPane.add(btnB);
		
		textField = new JTextField();
		textField.setBounds(162, 18, 291, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("请输入学号：");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel.setBounds(55, 18, 100, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("请选择查询项目：");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 62, 156, 22);
		contentPane.add(lblNewLabel_1);
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);//退出关闭程序
			}
		});
		btnNo.setBounds(408, 114, 100, 24);
		contentPane.add(btnNo);
	}
}
