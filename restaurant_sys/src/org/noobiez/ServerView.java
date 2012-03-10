package org.noobiez;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;


public class ServerView {

	protected Shell shell;
	private Table table;
	protected Combo cmbQty;
	protected Combo cmbBurgers;
	private static String userName;
	private Button btnCancelItem;

	/**
	 * Launch the application.
	 * @param userType
	 * @wbp.parser.entryPoint
	 */
	public static void main(String userType) {
		try {
			userName = userType;
			ServerView window = new ServerView();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 * @throws FileNotFoundException 
	 */
	public void open() throws FileNotFoundException {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.forceActive();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 * @throws FileNotFoundException 
	 */
	protected void createContents() throws FileNotFoundException {
		shell = new Shell();
		shell.setSize(620, 363);
		shell.setText(userName);
		
		Button btnAdd = new Button(shell, SWT.NONE);
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Order newOrder = new Order();
				try {
					newOrder.addItem(cmbBurgers.getText(), Integer.valueOf(cmbQty.getText()));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				TableItem tableItem = new TableItem(table, SWT.NONE);
				String[] orderDetails = {Integer.toString(newOrder.getOrderNumber()),cmbQty.getText(),cmbBurgers.getText(), newOrder.getPriceAsString()};
				tableItem.setText(orderDetails);
			}
		});
		btnAdd.setBounds(173, 62, 75, 25);
		btnAdd.setText("Add");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(254, 62, 307, 205);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnOrder = new TableColumn(table, SWT.NONE);
		tblclmnOrder.setWidth(59);
		tblclmnOrder.setText("Order #");
		
		TableColumn tblclmnQty = new TableColumn(table, SWT.NONE);
		tblclmnQty.setWidth(40);
		tblclmnQty.setText("Qty");
		
		TableColumn tblclmnItem = new TableColumn(table, SWT.NONE);
		tblclmnItem.setWidth(124);
		tblclmnItem.setText("Item");
		
		TableColumn tblclmnPrice = new TableColumn(table, SWT.NONE);
		tblclmnPrice.setWidth(100);
		tblclmnPrice.setText("Price");
		
		//Populate the Table with previous orders
		populateTable(table);
		
		btnCancelItem = new Button(shell, SWT.NONE);
		btnCancelItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int selection = table.getSelectionIndex();
				
				if (selection != -1)
				{
					TableItem temp = table.getItem(selection);
					String lineToRemove = "";
					
					for (int i = 0; i < 4; ++i)
					{
						lineToRemove += temp.getText(i) + " ";
					}
					
					table.remove(table.getSelectionIndex());
					
					File orderFile = new File(System.getProperty("user.dir") + "\\orders.dat");
					FileUtil fileUtil = new FileUtil();
					fileUtil.removeLineFromFile(orderFile.getAbsolutePath(), lineToRemove.trim());
				}
			}
		});
		btnCancelItem.setBounds(254, 290, 75, 25);
		btnCancelItem.setText("Cancel Order");
		
		cmbBurgers = new Combo(shell, SWT.NONE);
		cmbBurgers.setItems(new String[] {"brgSwiss", "fries", "rice", "sushi"});
		cmbBurgers.setBounds(5, 64, 109, 23);
		
		//TODO -- Owner View code
		cmbBurgers.add("ADD NEW MENU ITEM HERE");
		// ^^^ owner view code
		
		cmbQty = new Combo(shell, SWT.NONE);
		cmbQty.setItems(new String[] {"2", "3", "4", "5", "6", "7", "8", "9"});
		cmbQty.setBounds(129, 64, 39, 23);
		cmbQty.setText("1");
		
		Button btnLogOut = new Button(shell, SWT.NONE);
		btnLogOut.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
				LoginWindow.main(null);
			}
		});
		btnLogOut.setBounds(519, 290, 75, 25);
		btnLogOut.setText("Log Out");

	}
	
	/**
	 * This method populates the table in the current view with the current orders.
	 * @param table- the table that is going to be repopulated
	 * @throws FileNotFoundException
	 */
	private void populateTable(Table table) throws FileNotFoundException
	{
		File orderFile = new File(System.getProperty("user.dir") + "\\orders.dat");
		Scanner cin = new Scanner(orderFile);
		
		while (cin.hasNext())
		{
			TableItem tableItem = new TableItem(table, SWT.NONE);
			String[] orderDetails = new String[4];
			
			for (int i = 0; i < 4; ++i)
				orderDetails[i] = cin.next();
			
			tableItem.setText(orderDetails);
		}
		
		cin.close();
	}
}
