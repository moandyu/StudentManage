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
//ѧ���ɼ�ɾ��ҳ��
public class TDeletescore extends JFrame {

	private JPanel contentPane;
	private JTextField textField;//ѧ��
	private JTextField textField_1;//�γ̺�

	/**
	 * Launch the application.
	 */
	public  void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TDeletescore frame = new TDeletescore();
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
	public TDeletescore() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Administrator\\Pictures\\\u5DE5\u4F5C\\1.jpg"));
		setTitle("ɾ��ѧ���ɼ�");
		setBounds(100, 100, 427, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel IDLabel = new JLabel("ѧ��");
		IDLabel.setHorizontalAlignment(SwingConstants.CENTER);
		IDLabel.setFont(new Font("����", Font.BOLD, 16));
		IDLabel.setBounds(93, 63, 46, 33);
		contentPane.add(IDLabel);
		
		JLabel ClassLabel = new JLabel("�γ̺�");
		ClassLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ClassLabel.setFont(new Font("����", Font.BOLD, 16));
		ClassLabel.setBounds(75, 131, 74, 33);
		contentPane.add(ClassLabel);
		
		textField = new JTextField();
		textField.setBounds(148, 70, 120, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(148, 138, 120, 21);
		contentPane.add(textField_1);
		
		JButton TrueButton = new JButton("ȷ��");
		TrueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TeacherFonctin().delsId(textField,textField_1);
			}
		});
		TrueButton.setBounds(310, 230, 93, 23);
		contentPane.add(TrueButton);
		setLocationRelativeTo(null);
	}

}
