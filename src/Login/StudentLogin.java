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


//ѧ���û�����
public class StudentLogin extends JFrame {
	Scanner scan=new Scanner(System.in);
	
	private JPanel contentPane;
	private JTextField textField;
	private final JButton btnNo = new JButton("�˳�");
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
		setTitle("ѧ������ҳ��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رմ����˳�����
		setBounds(100, 100, 532, 175);//���ô�С��λ��
		contentPane = new JPanel();//�������
		contentPane.setBackground(new Color(250, 235, 215));//������ɫ
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);//������ʾ����
		JButton btnA = new JButton("������Ϣ��ѯ");
		btnA.addActionListener(new ActionListener() {//������Ϣ��ѯ��ť�¼�
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
		
		JButton btnB = new JButton("�ɼ���ѯ");
		btnB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//�ɼ���ѯ��ť�¼�
				String sId=textField.getText();//���ѧ��
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
		
		JLabel lblNewLabel = new JLabel("������ѧ�ţ�");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("����", Font.BOLD, 16));
		lblNewLabel.setBounds(55, 18, 100, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("��ѡ���ѯ��Ŀ��");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("����", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 62, 156, 22);
		contentPane.add(lblNewLabel_1);
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);//�˳��رճ���
			}
		});
		btnNo.setBounds(408, 114, 100, 24);
		contentPane.add(btnNo);
	}
}
