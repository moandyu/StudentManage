package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Fonction.Password;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//◊¢≤·“≥√Ê
public class ViewRejest extends JFrame {

	private JPanel contentPane;
	private JTextField textField;//’À∫≈
	private JTextField textField_1;//√‹¬Î

	/**
	 * Launch the application.
	 */
	public  void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewRejest frame = new ViewRejest();
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
	public ViewRejest() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Administrator\\Pictures\\\u5DE5\u4F5C\\1.jpg"));
		setTitle("–¬”√ªß◊¢≤·");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel userLabel = new JLabel("’À∫≈");
		userLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userLabel.setFont(new Font("ÀŒÃÂ", Font.BOLD, 16));
		userLabel.setBounds(113, 63, 54, 26);
		contentPane.add(userLabel);
		
		JLabel passwordLabel = new JLabel("√‹¬Î");
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel.setFont(new Font("ÀŒÃÂ", Font.BOLD, 16));
		passwordLabel.setBounds(113, 133, 54, 26);
		contentPane.add(passwordLabel);
		
		textField = new JTextField();
		textField.setBounds(188, 67, 155, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(188, 137, 155, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		setLocationRelativeTo(null);
		
		JButton RbtnTrue = new JButton("»∑∂®");
		RbtnTrue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newuserId=textField.getText();
				String newpassword = textField_1.getText();
				new Password().Rejest(newuserId, newpassword);
			}
		});
		RbtnTrue.setBounds(333, 230, 93, 23);
		contentPane.add(RbtnTrue);
	}
}
