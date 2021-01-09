package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
//��ѯѧ���ɼ�ҳ��
public class TViewLookstudentscore extends JFrame {

	private JPanel contentPane;
	private JTextField textField;//ѧ��

	/**
	 * Launch the application.
	 */
	public void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TViewLookstudentscore frame = new TViewLookstudentscore();
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
	public TViewLookstudentscore() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Administrator\\Pictures\\\u5DE5\u4F5C\\1.jpg"));
		setTitle("��ѯѧ���ɼ�");
		setBounds(100, 100, 428, 222);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel NewLabel = new JLabel("ѧ��");
		NewLabel.setFont(new Font("����", Font.BOLD, 16));
		NewLabel.setBounds(97, 68, 41, 29);
		contentPane.add(NewLabel);
		
		textField = new JTextField();
		textField.setBounds(140, 73, 149, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton TrueButton = new JButton("ȷ��");
		TrueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sid = textField.getText();
				try {
					new Fonction.StudentFonction().getScore(sid);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		TrueButton.setBounds(311, 152, 93, 23);
		contentPane.add(TrueButton);
	}

}
