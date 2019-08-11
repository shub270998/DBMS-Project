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
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class add_books extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					add_books frame = new add_books();
					frame.setVisible(true);
					frame.setTitle("Add Books");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	public add_books() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddBooks = new JLabel("ADD BOOK");
		lblAddBooks.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddBooks.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblAddBooks.setBounds(216, 34, 179, 31);
		contentPane.add(lblAddBooks);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(192, 121, 263, 26);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(192, 165, 263, 26);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(192, 216, 263, 26);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(192, 264, 263, 26);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(192, 314, 263, 26);
		contentPane.add(textField_4);
		
		JLabel label = new JLabel("NAME");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Dialog", Font.BOLD, 14));
		label.setBounds(41, 167, 122, 20);
		contentPane.add(label);
		
		JLabel lblBookId = new JLabel("BOOK ID");
		lblBookId.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookId.setFont(new Font("Dialog", Font.BOLD, 14));
		lblBookId.setBounds(24, 127, 156, 20);
		contentPane.add(lblBookId);
		
		JLabel lblAuthor = new JLabel("AUTHOR");
		lblAuthor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAuthor.setFont(new Font("Dialog", Font.BOLD, 14));
		lblAuthor.setBounds(41, 218, 122, 20);
		contentPane.add(lblAuthor);
		
		JLabel lblPublisher = new JLabel("PUBLISHER");
		lblPublisher.setHorizontalAlignment(SwingConstants.CENTER);
		lblPublisher.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPublisher.setBounds(24, 269, 156, 20);
		contentPane.add(lblPublisher);
		
		JLabel lblQuantity = new JLabel("QUANTITY");
		lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity.setFont(new Font("Dialog", Font.BOLD, 14));
		lblQuantity.setBounds(41, 320, 139, 20);
		contentPane.add(lblQuantity);
		
		JButton btnAddBooks = new JButton("Add Book\r\n");
		btnAddBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				int id,quantity;
				String i,q,name,author,publisher;
				i=textField.getText().toString();
				name=textField_1.getText().toString();
				author=textField_2.getText().toString();
				publisher=textField_3.getText().toString();
				q=textField_4.getText().toString();
				id=Integer.parseInt(i);
				quantity=Integer.parseInt(q);
				try
				{
					 Class.forName("com.mysql.cj.jdbc.Driver");
			         Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/library?useSSL=false","root","root123");
			         Statement stmt=conn.createStatement();
	                 String table="Create table if not exists Books(Id int not null,Name varchar(50),Author varchar(30),Publisher varchar(30),Quantity int not null,primary key (Id))";
	                 stmt.executeUpdate(table);
	                 String ins="Insert into Books values(?,?,?,?,?)";
	                 PreparedStatement pstmt=conn.prepareStatement(ins);
	                 pstmt.setInt(1,id);
	                 pstmt.setString(2,name);
	                 pstmt.setString(3,author);
	                 pstmt.setString(4,publisher);
	                 pstmt.setInt(5,quantity);
	                 pstmt.executeUpdate();
	                 JOptionPane.showMessageDialog(null,"Book Added Suceesfully","Message",JOptionPane.INFORMATION_MESSAGE);    
	                 textField.setText(null);
	                 textField_1.setText(null);
	                 textField_2.setText(null);
	                 textField_3.setText(null);
	                 textField_4.setText(null);
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
			}
		});
		btnAddBooks.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddBooks.setBounds(248, 363, 161, 40);
		contentPane.add(btnAddBooks);
		
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				librarian lib=new librarian();
				lib.setVisible(true);
				lib.setLocationRelativeTo(null);
				lib.setTitle("Librarian");
				setVisible(false);
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 13));
		button.setBounds(286, 426, 89, 31);
		contentPane.add(button);
	}
}
