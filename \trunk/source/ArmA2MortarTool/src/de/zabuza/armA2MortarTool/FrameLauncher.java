package de.zabuza.armA2MortarTool;

import java.awt.EventQueue;

import de.zabuza.armA2MortarTool.gui.MortarTool;

/**
 * Starts the tool in a frame.
 * 
 * @author Zabuza
 * 
 */
public final class FrameLauncher {

	/**
	 * Launches the application.
	 * 
	 * @param args
	 *            Not supported
	 */
	public static void main(final String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					MortarTool window = new MortarTool();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Utility class. No implementation.
	 */
	private FrameLauncher() {

	}
}
