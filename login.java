package com.lms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;


public class login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public login()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 469, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(159, 78, 230, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsername.setBounds(41, 82, 108, 23);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(41, 144, 108, 23);
		contentPane.add(lblPassword);
		
		JLabel lblAdminLoginForm = new JLabel("ADMIN LOGIN FORM");
		lblAdminLoginForm.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAdminLoginForm.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminLoginForm.setBounds(135, 11, 171, 34);
		contentPane.add(lblAdminLoginForm);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String name=textField.getText().toString();
				String pass=new String(passwordField.getPassword());
				if(name.equals("admin") && pass.equals("admin123"))
				{
					admin a=new admin();
					a.setVisible(true);
					a.setLocationRelativeTo(null);
					a.setTitle("Admin");
					setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Invalid Username or Password","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnLogin.setBounds(225, 178, 89, 34);
		contentPane.add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(159, 133, 230, 34);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("BACK\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				home h=new home();
				h.setVisible(true);
				h.setLocationRelativeTo(null);
				h.setTitle("Library Management System");
				setVisible(false);
			}
		});
		btnNewButton.setBounds(336, 228, 89, 23);
		contentPane.add(btnNewButton);
	}
}
