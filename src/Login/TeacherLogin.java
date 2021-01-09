package Login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Fonction.TeacherFonctin;
import View.TDeletescore;
import View.TEnterscore;
import View.TViewDeletestudent;
import View.TViewLookstudentdata;
import View.TViewLookstudentscore;
import View.ViewEnterOrAlterstudentdata;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Toolkit;


//教师用户管理
public class TeacherLogin extends JFrame {
	Scanner scan=new Scanner(System.in);
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherLogin frame = new TeacherLogin();
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
	public TeacherLogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Administrator\\Pictures\\\u5DE5\u4F5C\\1.jpg"));
		setTitle("教师管理页面");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 467);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton ScoreEnterButton = new JButton("成绩录入");
		ScoreEnterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TEnterscore().init();//成绩录入页面
			}
		});
		ScoreEnterButton.setBounds(43, 106, 125, 30);
		contentPane.add(ScoreEnterButton);
		
		JButton ScoreDeleteButton = new JButton("成绩删除");
		ScoreDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TDeletescore().init();//成绩删除页面
			}
		});
		ScoreDeleteButton.setBounds(229, 106, 125, 30);
		contentPane.add(ScoreDeleteButton);
		
		JButton ScoreLookButton = new JButton("成绩查询");
		ScoreLookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TViewLookstudentscore().init();//成绩查询结果页面
				
				}
		});
		ScoreLookButton.setBounds(409, 106, 125, 30);
		contentPane.add(ScoreLookButton);
		
		JButton StudentLookButton = new JButton("学生信息查询");
		StudentLookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TViewLookstudentdata().init();//学生信息查询结果页面
				
			}
		});
		StudentLookButton.setBounds(43, 199, 125, 30);
		contentPane.add(StudentLookButton);
		
		JButton StudentDeleteButton = new JButton("学生信息删除");
		StudentDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TViewDeletestudent().init();//学生信息删除页面以及操作
				
			}
		});
		StudentDeleteButton.setBounds(229, 203, 125, 30);
		contentPane.add(StudentDeleteButton);
		
		JButton AllstudentButton = new JButton("查看所有学生信息");
		AllstudentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//显示所有学生信息页面
				try {
					new TeacherFonctin().getAllstudent();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		AllstudentButton.setBounds(409, 203, 144, 30);
		contentPane.add(AllstudentButton);
		
		JButton btnclassAvgscore = new JButton("各科平均分");
		btnclassAvgscore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
					new TeacherFonctin().getClassavgscore();//获得各科平均分并显示
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnclassAvgscore.setBounds(43, 280, 125, 30);
		contentPane.add(btnclassAvgscore);
		
		JButton btnstudentSumscore = new JButton("学生总分");
		btnstudentSumscore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
					new TeacherFonctin().getStudentsumscore();//获得学生总分并显示
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		btnstudentSumscore.setBounds(229, 284, 125, 30);
		contentPane.add(btnstudentSumscore);
		
		JButton EnterandAlterButton = new JButton("录入或修改学生信息");
		EnterandAlterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewEnterOrAlterstudentdata().init();//录入或修改学生信息页面
			}
		});
		EnterandAlterButton.setBounds(409, 284, 144, 30);
		contentPane.add(EnterandAlterButton);
		
		JButton btnNewButton = new JButton("退出");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);//退出，结束程序
			}
		});
		btnNewButton.setBounds(548, 397, 93, 23);
		contentPane.add(btnNewButton);
		setLocationRelativeTo(null);
	}
}
