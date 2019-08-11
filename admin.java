package com.lms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class admin extends JFrame {

	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin frame = new admin();
					frame.setVisible(true);
				    
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Add Librarian");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				add_librarian a=new add_librarian();
				a.setVisible(true);
				a.setLocationRelativeTo(null);
				a.setTitle("Add Librarian");
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 16));
		btnNewButton.setBounds(150, 63, 179, 40);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("View Librarian");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				view_librarian vl=new view_librarian();
				vl.setVisible(true);
				vl.setTitle("View Librarian");
				vl.setLocationRelativeTo(null);
				setVisible(false);
			}
			
		});
		button.setFont(new Font("Arial", Font.PLAIN, 16));
		button.setBounds(150, 132, 179, 40);
		contentPane.add(button);
		
		JButton btnDeleteLibrarian = new JButton("Delete Librarian");
		btnDeleteLibrarian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				del_librarian d=new del_librarian();
				d.setVisible(true);
				d.setLocationRelativeTo(null);
				d.setTitle("Remove Librarian");
				setVisible(false);
			}
		});
		btnDeleteLibrarian.setFont(new Font("Arial", Font.PLAIN, 16));
		btnDeleteLibrarian.setBounds(150, 206, 179, 40);
		contentPane.add(btnDeleteLibrarian);
		
		JButton button_1 = new JButton("Logout");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				login l=new login();
				l.setVisible(true);
				l.setLocationRelativeTo(null);
				l.setTitle("Admin Login");
				setVisible(false);
			}
		});
		button_1.setFont(new Font("Arial", Font.PLAIN, 16));
		button_1.setBounds(150, 282, 179, 40);
		contentPane.add(button_1);
		
		JLabel lblAdminSection = new JLabel("ADMIN SECTION");
		lblAdminSection.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblAdminSection.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminSection.setBounds(150, 11, 179, 41);
		contentPane.add(lblAdminSection);
	}

}
