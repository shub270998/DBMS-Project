package com.lms;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class librarian extends JFrame {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					librarian frame = new librarian();
					frame.setVisible(true);
					frame.setTitle("Librarian");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public librarian() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 520);
		getContentPane().setLayout(null);
		
		JLabel lblLibrarianSection = new JLabel("LIBRARIAN SECTION");
		lblLibrarianSection.setHorizontalAlignment(SwingConstants.CENTER);
		lblLibrarianSection.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblLibrarianSection.setBounds(129, 37, 339, 41);
		getContentPane().add(lblLibrarianSection);
		
		JButton btnAddBooks = new JButton("Add Book\r\n");
		btnAddBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				add_books adb=new add_books();
				adb.setVisible(true);
				adb.setLocationRelativeTo(null);
				adb.setTitle("Add Book");
				setVisible(false);
			}
		});
		btnAddBooks.setFont(new Font("Arial", Font.PLAIN, 16));
		btnAddBooks.setBounds(213, 91, 179, 40);
		getContentPane().add(btnAddBooks);
		
		JButton btnViewBooks = new JButton("View Books");
		btnViewBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				view_books vb=new view_books();
				vb.setLocationRelativeTo(null);
				vb.setTitle("View Books");
				vb.setVisible(true);
				setVisible(false);
			}
		});
		btnViewBooks.setFont(new Font("Arial", Font.PLAIN, 16));
		btnViewBooks.setBounds(213, 153, 179, 40);
		getContentPane().add(btnViewBooks);
		
		JButton btnIssueBooks = new JButton("Issue Book");
		btnIssueBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				isuue_books ib=new isuue_books();
				ib.setVisible(true);
				ib.setLocationRelativeTo(null);
				ib.setTitle("Issue Book");
				setVisible(false);
			}
		});
		btnIssueBooks.setFont(new Font("Arial", Font.PLAIN, 16));
		btnIssueBooks.setBounds(213, 213, 179, 40);
		getContentPane().add(btnIssueBooks);
		
		JButton btnViewIssuedBooks = new JButton("View Issued Books");
		btnViewIssuedBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				view_issued_books vib=new view_issued_books();
				vib.setVisible(true);
				vib.setTitle("View Issued Books");
				vib.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnViewIssuedBooks.setFont(new Font("Arial", Font.PLAIN, 16));
		btnViewIssuedBooks.setBounds(213, 277, 179, 40);
		getContentPane().add(btnViewIssuedBooks);
		
		JButton btnReturnBook = new JButton("Return Book\r\n");
		btnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				return_books rb=new return_books();
				rb.setVisible(true);
				rb.setLocationRelativeTo(null);
				rb.setTitle("Return Book");
				setVisible(false);
			}
		});
		btnReturnBook.setFont(new Font("Arial", Font.PLAIN, 16));
		btnReturnBook.setBounds(213, 340, 179, 40);
		getContentPane().add(btnReturnBook);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				login_1 l1=new login_1();
				l1.setVisible(true);
				l1.setLocationRelativeTo(null);
				l1.setTitle("Librarian Login");
				setVisible(false);
			}
		});
		btnLogout.setFont(new Font("Arial", Font.PLAIN, 16));
		btnLogout.setBounds(213, 401, 179, 40);
		getContentPane().add(btnLogout);
	}
}
