package com.lms;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;



public class login_1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel label;
	private JLabel label_1;
	private JPasswordField passwordField;
	private JButton btnNewButton;


	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_1 frame = new login_1();
					frame.setVisible(true);
					frame.setTitle("Librarian Login");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	public login_1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLibrarianLoginForm = new JLabel("LIBRARIAN LOGIN FORM");
		lblLibrarianLoginForm.setHorizontalAlignment(SwingConstants.CENTER);
		lblLibrarianLoginForm.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLibrarianLoginForm.setBounds(66, 39, 355, 34);
		contentPane.add(lblLibrarianLoginForm);
		
		JButton button = new JButton("LOGIN");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String usr=null;
				String pas=null;
				String name=textField.getText().toString();
				String pass=new String(passwordField.getPassword());
				try
				{
				  Class.forName("com.mysql.cj.jdbc.Driver");
		          Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/library?useSSL=false","root","root123");
		          String sql="Select * from Librarian where Username= ? and Password = ?";
		          PreparedStatement pstmt=conn.prepareStatement(sql);
		          pstmt.setString(1,name);
		          pstmt.setString(2,pass);
		          ResultSet rs=pstmt.executeQuery();
		          if(!rs.next())
				  {
					JOptionPane.showMessageDialog(null,"Invalid Username or Password","Error",JOptionPane.ERROR_MESSAGE);
					textField.setText(null);
					passwordField.setText(null);
					return;
				  }
		          else
		          {
		           usr=rs.getString("Username");
		           pas=rs.getString("Password");
		           if(usr.equals(name) && pass.equals(pas))
		           {
		        	    librarian lib=new librarian();
						lib.setVisible(true);
						lib.setLocationRelativeTo(null);
						lib.setTitle("Librarian");
						setVisible(false);
		           }
		          }
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
				
			}
		});
		button.setBounds(209, 189, 89, 34);
		contentPane.add(button);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(145, 95, 230, 34);
		contentPane.add(textField);
		
		label = new JLabel("USERNAME");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(12, 100, 108, 23);
		contentPane.add(label);
		
		label_1 = new JLabel("PASSWORD");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(12, 154, 108, 23);
		contentPane.add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(145, 142, 230, 34);
		contentPane.add(passwordField);
		
		btnNewButton = new JButton("BACK");
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
		btnNewButton.setBounds(329, 239, 89, 23);
		contentPane.add(btnNewButton);
	}
}
