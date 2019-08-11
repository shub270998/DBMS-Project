package com.lms;

import javax.swing.*;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;


import net.proteanit.sql.DbUtils;

import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class view_librarian extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view_librarian frame = new view_librarian();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	
	public view_librarian() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		table = new JTable();
		table.setBounds(33, 33, 603, 362);
		contentPane.add(table);	
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/library?useSSL=false","root","root123");
	        Statement stmt=conn.createStatement();
	        String sql="Select * from Librarian";
	        ResultSet rs=stmt.executeQuery(sql);
	        table.setModel(DbUtils.resultSetToTableModel(rs));
	        
	        JButton btnNewButton = new JButton("BACK");
	        btnNewButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) 
	        	{
	        		admin a=new admin();
					a.setVisible(true);
					a.setLocationRelativeTo(null);
					a.setTitle("Admin");
					setVisible(false);
	        	}
	        });
	        btnNewButton.setBounds(535, 415, 89, 23);
	        contentPane.add(btnNewButton);
		}
		catch(Exception e1)
		{
		 System.out.println(e1);
		}
		;
	}
}
