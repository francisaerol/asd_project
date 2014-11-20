package framework.view.bank;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

public class JDialog_AddInterest extends JDialog {
	private static final long serialVersionUID = 5555322106933254149L;
	private BankFrm parentframe;

	public JDialog_AddInterest(BankFrm parent) {
		super(parent);
		parentframe = parent;
		jLabel1 = new JLabel();
		JText_Interest = new JTextField();
		JButton_OK = new JButton();

		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		jLabel1.setText("Interest");

		JButton_OK.setText("OK");

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(42, 42, 42)
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.LEADING)
												.addComponent(jLabel1)
												.addComponent(
														JText_Interest,
														GroupLayout.PREFERRED_SIZE,
														102,
														GroupLayout.PREFERRED_SIZE)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(10, 10,
																		10)
																.addComponent(
																		JButton_OK,
																		GroupLayout.PREFERRED_SIZE,
																		66,
																		GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(22, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(38, 38, 38)
								.addComponent(jLabel1)
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(JText_Interest,
										GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(JButton_OK)
								.addContainerGap(18, Short.MAX_VALUE)));

		pack();
		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
	}

	class SymAction implements java.awt.event.ActionListener {
		@Override
		public void actionPerformed(java.awt.event.ActionEvent event) {
			Object object = event.getSource();
			if (object == JButton_OK) {
				JButtonOK_actionPerformed(event);
			}
		}
	}

	private JButton JButton_OK;
	private JTextField JText_Interest;
	private JLabel jLabel1;

	void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
		parentframe.interest = JText_Interest.getText();
		parentframe.addInterest();
		dispose();

	}

}
