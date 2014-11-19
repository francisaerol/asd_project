package framework.view.bank;

public class JDialog_Report extends javax.swing.JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 37211114886079048L;
	private javax.swing.JButton JButton_OK;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea reportArea;

	public JDialog_Report(String reportTitle, String report) {

		jScrollPane1 = new javax.swing.JScrollPane();
		reportArea = new javax.swing.JTextArea();
		JButton_OK = new javax.swing.JButton();
		setTitle(reportTitle);
		reportArea.setText(report);


		reportArea.setEditable(false);
		reportArea.setColumns(20);
		reportArea.setRows(5);
		jScrollPane1.setViewportView(reportArea);

		JButton_OK.setText("OK");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(43, 43, 43)
								.addComponent(jScrollPane1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										317,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(40, Short.MAX_VALUE))
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(JButton_OK).addGap(160, 160, 160)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(34, 34, 34)
								.addComponent(jScrollPane1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										234,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										9, Short.MAX_VALUE)
								.addComponent(JButton_OK)));

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

	void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {

		dispose();
	}

}
