package org.noobiez;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.noobiez.messages"; //$NON-NLS-1$
	public static String FoodItem_prices_file;
	public static String FoodItem_default_price_value;
	public static String Order_decimalFormat;
	public static String Order_ordersFileLocation;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
