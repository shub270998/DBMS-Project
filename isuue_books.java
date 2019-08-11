package com.lms;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;


public class isuue_books extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel label;
	private JLabel lblStudentId;
	private JLabel lblStudentName;
	private JLabel lblStudentContact;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					isuue_books frame = new isuue_books();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public isuue_books() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIssueBooks = new JLabel("ISSUE BOOK\r\n");
		lblIssueBooks.setHorizontalAlignment(SwingConstants.CENTER);
		lblIssueBooks.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblIssueBooks.setBounds(209, 38, 179, 31);
		contentPane.add(lblIssueBooks);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(177, 108, 263, 26);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(177, 161, 263, 26);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(177, 219, 263, 26);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(177, 278, 263, 26);
		contentPane.add(textField_3);
		
		JButton btnIssueBook = new JButton("Issue Book");
		btnIssueBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
			  int id,quan;
			  int bid,sid;
			  long contact;	
			  String b,s,sname,scontact;
			  b=textField.getText().toString();
			  s=textField_1.getText().toString();
			  sname=textField_2.getText().toString();
			  scontact=textField_3.getText().toString();
			  contact=Long.parseLong(scontact);
			  bid=Integer.parseInt(b);
			  sid=Integer.parseInt(s);
			  try
			  {
				  Class.forName("com.mysql.cj.jdbc.Driver");
		          Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/library?useSSL=false","root","root123");
		          Statement stmt=conn.createStatement();
		          String table="Create table if not exists Issue(B_Id int not null,S_Id int not null,S_Name varchar(30),S_Contact long not null)";
		          stmt.execute(table);
		          PreparedStatement p=conn.prepareStatement("Select * from Books where Id = ?");
		          p.setInt(1,bid);
		          ResultSet rs=p.executeQuery();
		          if(!rs.next())
		          {
		        	  JOptionPane.showMessageDialog(null,"Invalid Book Id","Error",JOptionPane.ERROR_MESSAGE);
		          }
		          else
		          {
		        	 id=rs.getInt("Id");
		        	 quan=rs.getInt("Quantity");
		        	 if(bid==id && quan>0)
		        	 {
		        		 String sql1="Insert into Issue values(?,?,?,?)";
		        		 PreparedStatement p1=conn.prepareStatement(sql1);
		        		 p1.setInt(1,bid);
		        		 p1.setInt(2,sid);
		        		 p1.setString(3,sname);
		        		 p1.setLong(4,contact);
		        		 p1.executeUpdate();
		        		 String sql2="Update Books set Quantity=Quantity-1 where Id=?";
		        		 PreparedStatement p2=conn.prepareStatement(sql2);
		        		 p2.setInt(1,bid);
		        		 p2.executeUpdate();
		        		 JOptionPane.showMessageDialog(null,"Book Issued Suceesfully","Message",JOptionPane.INFORMATION_MESSAGE);  
		        		 textField.setText(null);
		        		 textField_1.setText(null);
		        		 textField_2.setText(null);
		        		 textField_3.setText(null);	        		 
		        	 }
		        	 else
		        	 {
		        		 JOptionPane.showMessageDialog(null,"Book is not Available in Library","Message",JOptionPane.INFORMATION_MESSAGE);
		        	 }
		          }
		          
			  }
			  catch(Exception ex)
			  {
				  System.out.println(ex);
			  }
			}
			
		});
		btnIssueBook.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnIssueBook.setBounds(220, 333, 179, 40);
		contentPane.add(btnIssueBook);
		
		JButton button_1 = new JButton("Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				librarian lib=new librarian();
				lib.setVisible(true);
				lib.setLocationRelativeTo(null);
				lib.setTitle("Librarian");
				setVisible(false);
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		button_1.setBounds(267, 397, 89, 31);
		contentPane.add(button_1);
		
		label = new JLabel("BOOK ID");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Dialog", Font.BOLD, 14));
		label.setBounds(9, 113, 156, 20);
		contentPane.add(label);
		
		lblStudentId = new JLabel("STUDENT ID\r\n");
		lblStudentId.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentId.setFont(new Font("Dialog", Font.BOLD, 14));
		lblStudentId.setBounds(12, 163, 135, 20);
		contentPane.add(lblStudentId);
		
		lblStudentName = new JLabel("STUDENT NAME\r\n");
		lblStudentName.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentName.setFont(new Font("Dialog", Font.BOLD, 14));
		lblStudentName.setBounds(12, 221, 153, 20);
		contentPane.add(lblStudentName);
		
		lblStudentContact = new JLabel("STUDENT CONTACT\r\n\r\n");
		lblStudentContact.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentContact.setFont(new Font("Dialog", Font.BOLD, 14));
		lblStudentContact.setBounds(12, 280, 164, 20);
		contentPane.add(lblStudentContact);
	}

}
