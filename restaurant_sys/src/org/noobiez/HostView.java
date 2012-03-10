package org.noobiez;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class HostView {

	protected Shell shlHost;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			HostView window = new HostView();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlHost.open();
		shlHost.layout();
		while (!shlHost.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlHost = new Shell();
		shlHost.setSize(450, 300);
		shlHost.setText("Host");
		shlHost.setLayout(null);
		
		final Button btnTable1 = new Button(shlHost, SWT.NONE);
		btnTable1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (btnTable1.isEnabled())
					btnTable1.setEnabled(false);
				else
					btnTable1.setEnabled(true);
				
			}
		});
		btnTable1.setBounds(43, 45, 75, 25);
		btnTable1.setText("Table 1");
		
		Button btnNewButton_1 = new Button(shlHost, SWT.NONE);
		btnNewButton_1.setBounds(43, 114, 75, 25);
		btnNewButton_1.setText("New Button");
		
		Button btnNewButton_2 = new Button(shlHost, SWT.NONE);
		btnNewButton_2.setBounds(43, 198, 75, 25);
		btnNewButton_2.setText("New Button");
		
		Button btnNewButton_3 = new Button(shlHost, SWT.NONE);
		btnNewButton_3.setBounds(175, 45, 75, 25);
		btnNewButton_3.setText("New Button");
		
		Button btnNewButton_4 = new Button(shlHost, SWT.NONE);
		btnNewButton_4.setBounds(175, 114, 75, 25);
		btnNewButton_4.setText("New Button");
		
		Button btnNewButton_5 = new Button(shlHost, SWT.NONE);
		btnNewButton_5.setBounds(175, 198, 75, 25);
		btnNewButton_5.setText("New Button");
		
		Button btnNewButton_6 = new Button(shlHost, SWT.NONE);
		btnNewButton_6.setBounds(322, 45, 75, 25);
		btnNewButton_6.setText("New Button");
		
		Button btnNewButton_7 = new Button(shlHost, SWT.NONE);
		btnNewButton_7.setBounds(322, 114, 75, 25);
		btnNewButton_7.setText("New Button");
		
		Button btnNewButton_8 = new Button(shlHost, SWT.NONE);
		btnNewButton_8.setBounds(322, 198, 75, 25);
		btnNewButton_8.setText("New Button");

	}
}
