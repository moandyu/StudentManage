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


//��ʦ�û�����
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
		setTitle("��ʦ����ҳ��");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 467);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton ScoreEnterButton = new JButton("�ɼ�¼��");
		ScoreEnterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TEnterscore().init();//�ɼ�¼��ҳ��
			}
		});
		ScoreEnterButton.setBounds(43, 106, 125, 30);
		contentPane.add(ScoreEnterButton);
		
		JButton ScoreDeleteButton = new JButton("�ɼ�ɾ��");
		ScoreDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TDeletescore().init();//�ɼ�ɾ��ҳ��
			}
		});
		ScoreDeleteButton.setBounds(229, 106, 125, 30);
		contentPane.add(ScoreDeleteButton);
		
		JButton ScoreLookButton = new JButton("�ɼ���ѯ");
		ScoreLookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TViewLookstudentscore().init();//�ɼ���ѯ���ҳ��
				
				}
		});
		ScoreLookButton.setBounds(409, 106, 125, 30);
		contentPane.add(ScoreLookButton);
		
		JButton StudentLookButton = new JButton("ѧ����Ϣ��ѯ");
		StudentLookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TViewLookstudentdata().init();//ѧ����Ϣ��ѯ���ҳ��
				
			}
		});
		StudentLookButton.setBounds(43, 199, 125, 30);
		contentPane.add(StudentLookButton);
		
		JButton StudentDeleteButton = new JButton("ѧ����Ϣɾ��");
		StudentDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TViewDeletestudent().init();//ѧ����Ϣɾ��ҳ���Լ�����
				
			}
		});
		StudentDeleteButton.setBounds(229, 203, 125, 30);
		contentPane.add(StudentDeleteButton);
		
		JButton AllstudentButton = new JButton("�鿴����ѧ����Ϣ");
		AllstudentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//��ʾ����ѧ����Ϣҳ��
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
		
		JButton btnclassAvgscore = new JButton("����ƽ����");
		btnclassAvgscore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
					new TeacherFonctin().getClassavgscore();//��ø���ƽ���ֲ���ʾ
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
		
		JButton btnstudentSumscore = new JButton("ѧ���ܷ�");
		btnstudentSumscore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
					new TeacherFonctin().getStudentsumscore();//���ѧ���ֲܷ���ʾ
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
		
		JButton EnterandAlterButton = new JButton("¼����޸�ѧ����Ϣ");
		EnterandAlterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewEnterOrAlterstudentdata().init();//¼����޸�ѧ����Ϣҳ��
			}
		});
		EnterandAlterButton.setBounds(409, 284, 144, 30);
		contentPane.add(EnterandAlterButton);
		
		JButton btnNewButton = new JButton("�˳�");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);//�˳�����������
			}
		});
		btnNewButton.setBounds(548, 397, 93, 23);
		contentPane.add(btnNewButton);
		setLocationRelativeTo(null);
	}
}
