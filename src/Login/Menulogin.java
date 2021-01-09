package Login;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Fonction.Password;
import View.ViewRejest;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

// 登录界面与main测试
public class Menulogin extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menulogin frame = new Menulogin();
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
	public Menulogin() {
		setBackground(Color.GRAY);
		setResizable(false);
		setTitle("高校学员信息管理");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Administrator\\Pictures\\\u5DE5\u4F5C\\1.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 413, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nameLabel = new JLabel("账号:");
		nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nameLabel.setFont(new Font("宋体", Font.BOLD, 17));
		nameLabel.setBounds(118, 64, 74, 29);
		contentPane.add(nameLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(209, 125, 105, 21);
		contentPane.add(passwordField);
		
		JLabel keyLabel = new JLabel("密码:");
		keyLabel.setFont(new Font("宋体", Font.BOLD, 18));
		keyLabel.setHorizontalAlignment(SwingConstants.LEFT);
		keyLabel.setBounds(81, 125, 111, 18);
		contentPane.add(keyLabel);
		
		textField = new JTextField();
		textField.setBounds(209, 69, 105, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		JButton btnno = new JButton("登录");
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 218, 185));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"学生", "教师"}));
		comboBox.setBounds(209, 171, 111, 23);
		contentPane.add(comboBox);
		btnno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userId=textField.getText();//将输入的账号赋值给userId
				String password=String.valueOf(passwordField.getPassword());//将输入的密码赋值给password
				
				if(userId.trim().equals("")||userId==null||password.trim().equals("")||password==null){
					JOptionPane.showMessageDialog(null,"用户名或密码不能为空！","提示",JOptionPane.WARNING_MESSAGE);
				}
				else {
					if(new Password().init(userId, password)){
						//comboBox.getSelectedItem()返回当前选项
						if(comboBox.getSelectedItem().equals("学生")) {
							dispose();
							new StudentLogin().init();//学生功能管理页面
						}if(comboBox.getSelectedItem().equals("教师")){
							dispose();
							new TeacherLogin().init();//教室功能管理页面
						}
						
					}else{
						//提示信息
						JOptionPane.showMessageDialog(null,"用户名或密码输入不正确！","提示",JOptionPane.WARNING_MESSAGE);
						//账号、密码清空
						textField.setText("");
						passwordField.setText("");
					}
				}
			}
		});
	
		btnno.setBounds(237, 218, 93, 23);
		contentPane.add(btnno);
		
		JButton RejestButton = new JButton("注册");
		RejestButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewRejest().init();//注册页面
			}
		});
		RejestButton.setBounds(68, 218, 93, 23);
		contentPane.add(RejestButton);
		
	}
}
