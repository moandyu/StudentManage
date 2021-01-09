package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Fonction.TeacherFonctin;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//录入和修改学生信息页面
public class ViewEnterOrAlterstudentdata extends JFrame {

	private JPanel contentPane;
	private JTextField textField;//学号
	private JTextField textField_1;//姓名
	private JTextField textField_2;//性别
	private JTextField textField_3;//年龄
	private JTextField textField_4;//手机号码
	private JTextField textField_5;//专业

	/**
	 * Launch the application.
	 */
	public void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewEnterOrAlterstudentdata frame = new ViewEnterOrAlterstudentdata();
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
	public ViewEnterOrAlterstudentdata() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Administrator\\Pictures\\\u5DE5\u4F5C\\1.jpg"));
		setTitle("录入或修改学生信息");
		setBounds(100, 100, 568, 567);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		JLabel idLabel = new JLabel("学号");
		idLabel.setHorizontalAlignment(SwingConstants.CENTER);
		idLabel.setFont(new Font("宋体", Font.BOLD, 16));
		idLabel.setBounds(130, 55, 54, 29);
		contentPane.add(idLabel);
		
		JLabel nameLabel = new JLabel("姓名");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setFont(new Font("宋体", Font.BOLD, 16));
		nameLabel.setBounds(130, 109, 54, 29);
		contentPane.add(nameLabel);
		
		JLabel sexLabel = new JLabel("性别");
		sexLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sexLabel.setFont(new Font("宋体", Font.BOLD, 16));
		sexLabel.setBounds(130, 167, 54, 29);
		contentPane.add(sexLabel);
		
		JLabel ageLabel = new JLabel("年龄");
		ageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ageLabel.setFont(new Font("宋体", Font.BOLD, 16));
		ageLabel.setBounds(130, 223, 54, 29);
		contentPane.add(ageLabel);
		
		JLabel phoneLabel = new JLabel("手机号码");
		phoneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		phoneLabel.setFont(new Font("宋体", Font.BOLD, 16));
		phoneLabel.setBounds(104, 278, 80, 29);
		contentPane.add(phoneLabel);
		
		JLabel majorLabel = new JLabel("专业");
		majorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		majorLabel.setFont(new Font("宋体", Font.BOLD, 16));
		majorLabel.setBounds(130, 333, 54, 29);
		contentPane.add(majorLabel);
		
		textField = new JTextField();
		textField.setBounds(205, 60, 207, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(205, 114, 207, 21);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(205, 172, 207, 21);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(205, 228, 207, 21);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(205, 283, 207, 21);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(205, 338, 207, 21);
		contentPane.add(textField_5);
		
		JButton AlterButton = new JButton("确认修改");
		AlterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TeacherFonctin().Alterstudentdata(textField, textField_1,textField_2,textField_3,textField_4,textField_5);
			}
		});
		AlterButton.setBounds(72, 427, 93, 23);
		contentPane.add(AlterButton);
		
		JButton EnterButton = new JButton("确认录入");
		EnterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TeacherFonctin().addstudentdata(textField, textField_1,textField_2,textField_3,textField_4,textField_5);
			}
		});
		EnterButton.setBounds(400, 427, 93, 23);
		contentPane.add(EnterButton);
	}
}
