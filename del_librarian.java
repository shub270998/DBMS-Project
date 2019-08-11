package com.lms;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.TextField;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;


public class del_librarian extends JFrame {

	private JPanel contentPane;
	private JTextField textField;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					del_librarian frame = new del_librarian();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public del_librarian() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRemoveLibrarian = new JLabel("REMOVE LIBRARIAN");
		lblRemoveLibrarian.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemoveLibrarian.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblRemoveLibrarian.setBounds(86, 71, 346, 41);
		contentPane.add(lblRemoveLibrarian);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(170, 150, 213, 26);
		contentPane.add(textField);
		
		JLabel lblLibrarianId = new JLabel("CONTACT NUMBER");
		lblLibrarianId.setHorizontalAlignment(SwingConstants.CENTER);
		lblLibrarianId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLibrarianId.setBounds(0, 151, 160, 20);
		contentPane.add(lblLibrarianId);
		
		JButton btnDelete = new JButton("Delete\r\n\r\n");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				long ph;
				String pho=textField.getText().toString();
				if(pho.isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Invalid Librarian Phone Number","Message",JOptionPane.ERROR_MESSAGE);
					return;
				}
				try
				{
				  ph=Long.parseLong(pho);
				  Class.forName("com.mysql.cj.jdbc.Driver");
		          Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/library?useSSL=false","root","root123");
		          String q1="Delete from Librarian where Phone=?";
		          PreparedStatement ps=conn.prepareStatement(q1);
		          ps.setLong(1,ph);
		          int j=ps.executeUpdate();
		          if(j==1)
		          {
		          JOptionPane.showMessageDialog(null,"Librarian Deleted Succesfully","Message",JOptionPane.INFORMATION_MESSAGE);
		          }
		          else
		          {
		        	  JOptionPane.showMessageDialog(null,"Invalid Librarian Phone Number","Message",JOptionPane.ERROR_MESSAGE);
		          }
				}
				catch(Exception e1)
				{
				 
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete.setBounds(216, 198, 115, 26);
		contentPane.add(btnDelete);
		
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				admin a=new admin();
				a.setVisible(true);
				a.setLocationRelativeTo(null);
				a.setTitle("Admin");
				setVisible(false);
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 13));
		button.setBounds(232, 253, 84, 26);
		contentPane.add(button);
	}

}
