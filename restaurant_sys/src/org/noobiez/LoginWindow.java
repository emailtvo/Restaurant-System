package org.noobiez;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import java.io.FileNotFoundException;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import net.miginfocom.swing.MigLayout;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class LoginWindow {

	private JFrame frame;
	private JTextField txtPasswordEntry;
	protected static JLabel lblError;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow window = new LoginWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 484, 315);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				frame.setVisible(true);
			}
		});
		panel.setForeground(Color.BLACK);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[79px][86px][57px][110px]", "[23px][][][][][]"));
		
		JLabel lblEnterPassword = new JLabel("Enter Password:");
		panel.add(lblEnterPassword, "cell 2 2,alignx center,aligny center");
		
		txtPasswordEntry = new JTextField();
		panel.add(txtPasswordEntry, "cell 2 3,alignx center,aligny center");
		txtPasswordEntry.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		panel.add(btnLogin, "cell 2 4,alignx center,aligny top");
		
		lblError = new JLabel("Incorrect Password");
		lblError.setVisible(false);
		lblError.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblError.setForeground(Color.RED);
		panel.add(lblError, "cell 2 5,alignx center,aligny center");
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String userPasswordEntry = "";
				String userType[] = {};
				
				//Get text from password textbox
				userPasswordEntry = txtPasswordEntry.getText();
				LoginProcessor loginProcessor = new LoginProcessor(userPasswordEntry);
				
				try 
				{
					userType = loginProcessor.determineUserTypeAndName();
				} catch (FileNotFoundException e1) {
					lblError.setText("Database Error"); // Error shows users file was not found
					lblError.setVisible(true);
				}
				
				if (!userType[0].isEmpty())	//If the user was found
				{
					//Reset the login view
					lblError.setVisible(false);
					txtPasswordEntry.setText("");
					frame.dispose();
					
					//Launch window depending on user type
					if (userType[0].equals("mgr"))
					{
						ServerView.main(userType[1]);
					}
					else if (userType[0].equals("srv"))
					{
						ServerView.main(userType[1]);
					}
				}
				else	//If no user found, output error message
				{
					txtPasswordEntry.setText("");
					lblError.setVisible(true);
				}
			}
		});
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmQuit = new JMenuItem("Quit");
		mntmQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		mnFile.add(mntmQuit);
		mnFile.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{mntmQuit}));
	}

}
