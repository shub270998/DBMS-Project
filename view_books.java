package com.lms;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class view_books extends JFrame 
{
	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view_books frame = new view_books();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public view_books() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		table = new JTable();
		table.setBounds(30, 28, 603, 362);
		contentPane.add(table);	
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/library?useSSL=false","root","root123");
	        Statement stmt=conn.createStatement();
	        String sql="Select * from Books";
	        ResultSet rs=stmt.executeQuery(sql);
	        table.setModel(DbUtils.resultSetToTableModel(rs));
	        
	        btnNewButton = new JButton("BACK");
	        btnNewButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) 
	        	{
	        		librarian lib=new librarian();
					lib.setVisible(true);
					lib.setLocationRelativeTo(null);
					lib.setTitle("Librarian");
					setVisible(false);
	        	}
	        });
	        btnNewButton.setBounds(523, 415, 89, 23);
	        contentPane.add(btnNewButton);
		}
		catch(Exception e1)
		{
		 System.out.println(e1);
		}
	}

}
