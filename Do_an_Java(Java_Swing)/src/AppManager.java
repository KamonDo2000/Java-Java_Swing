

import java.awt.EventQueue;

import javax.swing.JDialog;

import AppView.FormLogin;
import AppView.FormMenu;

public class AppManager {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FormLogin dialog = new FormLogin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
}
