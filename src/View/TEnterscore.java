package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//录入学生信息页面
public class TEnterscore extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldId;//学号
	private JTextField textFieldName;//姓名
	private JTextField textFieldCid;//课程号
	private JTextField textFieldCname;//课程名
	private JTextField textFieldGrade;//成绩

	
	/**
	 * Create the frame.
	 */
	public TEnterscore() {
		setTitle("学生课程成绩录入");
		setBackground(new Color(250, 235, 215));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Administrator\\Pictures\\\u5DE5\u4F5C\\1.jpg"));
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 407, 446);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("学号");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel.setBounds(53, 47, 54, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("姓名");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel_1.setBounds(53, 107, 54, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("课程号");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel_2.setBounds(53, 166, 54, 26);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("课程名");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel_3.setBounds(53, 233, 54, 26);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("成绩");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel_4.setBounds(53, 293, 54, 26);
		contentPane.add(lblNewLabel_4);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(117, 51, 180, 21);
		contentPane.add(textFieldId);
		textFieldId.setColumns(10);
		
		textFieldName = new JTextField();
		textFieldName.setColumns(10);
		textFieldName.setBounds(117, 111, 180, 21);
		contentPane.add(textFieldName);
		
		textFieldCid = new JTextField();
		textFieldCid.setColumns(10);
		textFieldCid.setBounds(117, 170, 180, 21);
		contentPane.add(textFieldCid);
		
		textFieldCname = new JTextField();
		textFieldCname.setColumns(10);
		textFieldCname.setBounds(117, 237, 180, 21);
		contentPane.add(textFieldCname);
		
		textFieldGrade = new JTextField();
		textFieldGrade.setColumns(10);
		textFieldGrade.setBounds(117, 297, 180, 21);
		contentPane.add(textFieldGrade);
		
		JButton btnTrue = new JButton("确定");
		btnTrue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Fonction.TeacherFonctin().addscore(textFieldId,textFieldName,textFieldCid,textFieldCname,textFieldGrade);
			}
		});
		btnTrue.setBounds(290, 376, 93, 23);
		contentPane.add(btnTrue);
		setLocationRelativeTo(null);
	}
	
	/**
	 * Launch the application.
	 */
	public void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TEnterscore frame = new TEnterscore();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
