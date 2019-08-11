package com.lms;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;


public class home extends JFrame {

	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home frame = new home();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setTitle("Library Management System");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public home() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton admin_btn= new JButton("Admin");
		admin_btn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				login l=new login();
				l.setVisible(true);
				l.setLocationRelativeTo(null);
				l.setTitle("Admin Login");
				setVisible(false);
			}
		});
		admin_btn.setBounds(148, 92, 147, 36);
		contentPane.add(admin_btn);
		
		JButton btnLibrarian = new JButton("Librarian");
		btnLibrarian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				login_1 l1=new login_1();
				l1.setVisible(true);
				l1.setLocationRelativeTo(null);
				l1.setTitle("Librarian Login");
				setVisible(false);
			}
		});
		btnLibrarian.setBounds(148, 160, 147, 36);
		contentPane.add(btnLibrarian);
		
		JLabel lblLibraryManagementSystem = new JLabel("Library Management System");
		lblLibraryManagementSystem.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblLibraryManagementSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblLibraryManagementSystem.setBounds(74, 37, 307, 32);
		contentPane.add(lblLibraryManagementSystem);
	}
}

