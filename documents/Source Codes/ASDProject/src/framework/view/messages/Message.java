package framework.view.messages;

import java.awt.Component;

import javax.swing.JOptionPane;

public class Message {
	public void warning(Component component, String message) {
		JOptionPane.showMessageDialog(component, message, "Warning",
				JOptionPane.WARNING_MESSAGE);
	}

	public void error(Component component, String message) {
		JOptionPane.showMessageDialog(component, message, "Error",
				JOptionPane.ERROR_MESSAGE);
	}

	public void info(Component component, String message) {
		JOptionPane.showMessageDialog(component, message, "Info",
				JOptionPane.INFORMATION_MESSAGE);
	}
}
