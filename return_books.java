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
import java.sql.ResultSet;
import java.awt.event.ActionEvent;


public class return_books extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					return_books frame = new return_books();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public return_books() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblReturnBook = new JLabel("RETURN BOOK\r\n\r\n");
		lblReturnBook.setHorizontalAlignment(SwingConstants.CENTER);
		lblReturnBook.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblReturnBook.setBounds(12, 65, 544, 31);
		contentPane.add(lblReturnBook);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(185, 123, 263, 26);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(185, 170, 263, 26);
		contentPane.add(textField_1);
		
		JLabel label = new JLabel("BOOK ID");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Dialog", Font.BOLD, 14));
		label.setBounds(12, 125, 156, 20);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("STUDENT ID\r\n");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Dialog", Font.BOLD, 14));
		label_1.setBounds(31, 172, 135, 20);
		contentPane.add(label_1);
		
		JButton btnReturnBook = new JButton("Return Book");
		btnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				int bid,sid;
				String b=textField.getText().toString();
				String s=textField_1.getText().toString();
				bid=Integer.parseInt(b);
				sid=Integer.parseInt(s);
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
			        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/library?useSSL=false","root","root123");
			        PreparedStatement ps=conn.prepareStatement("Delete From Issue where B_Id=? and S_Id=?");
			        ps.setInt(1,bid);
			        ps.setInt(2,sid); 
			        int j=ps.executeUpdate();
			        if(j==1)
			        {
			        	JOptionPane.showMessageDialog(null,"Book Returned Successfully","Message",JOptionPane.INFORMATION_MESSAGE);
			        	PreparedStatement pl=conn.prepareStatement("Update Books set Quantity=Quantity+1 where B_Id = ?");
			        	pl.setInt(1,bid);
			        	pl.executeUpdate();
			        }
			        else
			        {
			        	JOptionPane.showMessageDialog(null,"Invalid Book Id or Student Id","Error",JOptionPane.ERROR_MESSAGE);
			        }
			    }
				catch(Exception ex)
				{
					System.out.println(ex);  
				}
				
			}
		});
		btnReturnBook.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnReturnBook.setBounds(223, 217, 179, 40);
		contentPane.add(btnReturnBook);
		
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
		button.setBounds(425, 282, 89, 31);
		contentPane.add(button);
	}

}
