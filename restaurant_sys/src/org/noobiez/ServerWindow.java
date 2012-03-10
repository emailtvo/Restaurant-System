package org.noobiez;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class ServerWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerWindow frame = new ServerWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ServerWindow() {
		setTitle("Test GUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 501);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnLoginout = new JMenu("Login/out");
		menuBar.add(mnLoginout);
		
		JMenuItem mntmLogin = new JMenuItem("Login");
		mnLoginout.add(mntmLogin);
		
		JMenuItem mntmLogoutbreak = new JMenuItem("Logout/break");
		mnLoginout.add(mntmLogoutbreak);
		
		JMenu mnReports = new JMenu("Reports");
		menuBar.add(mnReports);
		
		JMenuItem mntmSalesReports = new JMenuItem("Sales reports");
		mnReports.add(mntmSalesReports);
		
		JMenuItem mntmEmployeeReports = new JMenuItem("Employee reports");
		mnReports.add(mntmEmployeeReports);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
		);
		
		JPanel mnFood = new JPanel();
		tabbedPane.addTab("Food", null, mnFood, null);
		GridBagLayout gbl_mnFood = new GridBagLayout();
		gbl_mnFood.columnWidths = new int[]{0, 0};
		gbl_mnFood.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_mnFood.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_mnFood.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		mnFood.setLayout(gbl_mnFood);
		
		JButton btnBurger = new JButton("Burger 1");
		GridBagConstraints gbc_btnBurger = new GridBagConstraints();
		gbc_btnBurger.insets = new Insets(0, 0, 5, 0);
		gbc_btnBurger.gridx = 0;
		gbc_btnBurger.gridy = 0;
		mnFood.add(btnBurger, gbc_btnBurger);
		
		JButton btnBurger_1 = new JButton("Burger 2");
		GridBagConstraints gbc_btnBurger_1 = new GridBagConstraints();
		gbc_btnBurger_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnBurger_1.gridx = 0;
		gbc_btnBurger_1.gridy = 2;
		mnFood.add(btnBurger_1, gbc_btnBurger_1);
		
		JButton button = new JButton("Burger 2");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 0;
		gbc_button.gridy = 4;
		mnFood.add(button, gbc_button);
		
		JButton button_1 = new JButton("Burger 2");
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 0);
		gbc_button_1.gridx = 0;
		gbc_button_1.gridy = 6;
		mnFood.add(button_1, gbc_button_1);
		
		JButton button_2 = new JButton("Burger 2");
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.insets = new Insets(0, 0, 5, 0);
		gbc_button_2.gridx = 0;
		gbc_button_2.gridy = 8;
		mnFood.add(button_2, gbc_button_2);
		
		JButton button_3 = new JButton("Burger 2");
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.gridx = 0;
		gbc_button_3.gridy = 10;
		mnFood.add(button_3, gbc_button_3);
		
		JPanel mnDrinks = new JPanel();
		tabbedPane.addTab("Drinks", null, mnDrinks, null);
		GridBagLayout gbl_mnDrinks = new GridBagLayout();
		gbl_mnDrinks.columnWidths = new int[]{0, 0};
		gbl_mnDrinks.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_mnDrinks.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_mnDrinks.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		mnDrinks.setLayout(gbl_mnDrinks);
		
		JButton btnLemonade = new JButton("Lemonade");
		GridBagConstraints gbc_btnLemonade = new GridBagConstraints();
		gbc_btnLemonade.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLemonade.insets = new Insets(0, 0, 5, 0);
		gbc_btnLemonade.gridx = 0;
		gbc_btnLemonade.gridy = 0;
		mnDrinks.add(btnLemonade, gbc_btnLemonade);
		
		JButton btnFountainDrink = new JButton("Fountain Drink");
		GridBagConstraints gbc_btnFountainDrink = new GridBagConstraints();
		gbc_btnFountainDrink.insets = new Insets(0, 0, 5, 0);
		gbc_btnFountainDrink.gridx = 0;
		gbc_btnFountainDrink.gridy = 2;
		mnDrinks.add(btnFountainDrink, gbc_btnFountainDrink);
		
		JButton btnWater = new JButton("Water");
		GridBagConstraints gbc_btnWater = new GridBagConstraints();
		gbc_btnWater.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnWater.insets = new Insets(0, 0, 5, 0);
		gbc_btnWater.gridx = 0;
		gbc_btnWater.gridy = 4;
		mnDrinks.add(btnWater, gbc_btnWater);
		
		JButton btnBlarg = new JButton("Blarg");
		GridBagConstraints gbc_btnBlarg = new GridBagConstraints();
		gbc_btnBlarg.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBlarg.gridx = 0;
		gbc_btnBlarg.gridy = 6;
		mnDrinks.add(btnBlarg, gbc_btnBlarg);
		contentPane.setLayout(gl_contentPane);
	}
}
