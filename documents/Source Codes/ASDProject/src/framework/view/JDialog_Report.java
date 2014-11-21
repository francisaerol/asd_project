package framework.view;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;

public class JDialog_Report extends JDialog {

	private static final long serialVersionUID = 37211114886079048L;
	private JButton JButton_OK;
	private JScrollPane scroller;
	private JTextArea reportArea;

	public JDialog_Report(String reportTitle, String report) {

		scroller = new JScrollPane();
		reportArea = new JTextArea();
		JButton_OK = new JButton();
		setTitle(reportTitle);
		reportArea.setText(report);
		reportArea.setEditable(false);
		reportArea.setColumns(20);
		reportArea.setRows(5);
		scroller.setViewportView(reportArea);
		JButton_OK.setText("OK");

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(43, 43, 43)
								.addComponent(scroller,
										GroupLayout.PREFERRED_SIZE, 317,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(40, Short.MAX_VALUE))
				.addGroup(
						GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(JButton_OK).addGap(160, 160, 160)));
		layout.setVerticalGroup(layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addGap(34, 34, 34)
						.addComponent(scroller, GroupLayout.PREFERRED_SIZE,
								234, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(
								LayoutStyle.ComponentPlacement.RELATED, 9,
								Short.MAX_VALUE).addComponent(JButton_OK)));

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
