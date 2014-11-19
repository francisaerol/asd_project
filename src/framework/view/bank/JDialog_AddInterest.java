package framework.view.bank;

import javax.swing.JDialog;

public class JDialog_AddInterest extends JDialog {
	private BankFrm parentframe;

	public JDialog_AddInterest(BankFrm parent) {
		super(parent);
		parentframe = parent;

		jLabel1 = new javax.swing.JLabel();
		JText_Interest = new javax.swing.JTextField();
		JButton_OK = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jLabel1.setText("Interest");

		JButton_OK.setText("OK");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(42, 42, 42)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabel1)
												.addComponent(
														JText_Interest,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														102,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(10, 10,
																		10)
																.addComponent(
																		JButton_OK,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		66,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(22, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(38, 38, 38)
								.addComponent(jLabel1)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(JText_Interest,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
			if (object == JButton_OK)
				JButtonOK_actionPerformed(event);

		}
	}

	private javax.swing.JButton JButton_OK;
	private javax.swing.JTextField JText_Interest;
	private javax.swing.JLabel jLabel1;

	void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
		parentframe.interest = JText_Interest.getText();
		parentframe.interestFlag = true;
		dispose();

	}

}
