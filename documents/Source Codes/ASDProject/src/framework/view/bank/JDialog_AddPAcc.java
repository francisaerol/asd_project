package framework.view.bank;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class JDialog_AddPAcc extends JDialog {
	private static final long serialVersionUID = 3641896046197658335L;
	private BankFrm parentframe;

	public JDialog_AddPAcc(BankFrm parent) {
		super(parent);
		parentframe = parent;
		setTitle("Add personal account");
		setModal(true);
		getContentPane().setLayout(null);
		setSize(283, 303);
		setVisible(false);
		JRadioButton_Chk.setText("Checkings");
		JRadioButton_Chk.setActionCommand("Checkings");
		getContentPane().add(JRadioButton_Chk);
		JRadioButton_Chk.setBounds(36, 0, 84, 24);
		JRadioButton_Sav.setText("Savings");
		JRadioButton_Sav.setActionCommand("Savings");
		getContentPane().add(JRadioButton_Sav);
		JRadioButton_Sav.setBounds(36, 24, 84, 24);
		JLabel1.setText("Name");
		getContentPane().add(JLabel1);
		JLabel1.setForeground(java.awt.Color.black);
		JLabel1.setBounds(12, 64, 48, 24);
		JLabel2.setText("Street");
		getContentPane().add(JLabel2);
		JLabel2.setForeground(java.awt.Color.black);
		JLabel2.setBounds(12, 88, 48, 24);
		JLabel3.setText("City");
		getContentPane().add(JLabel3);
		JLabel3.setForeground(java.awt.Color.black);
		JLabel3.setBounds(12, 112, 48, 24);
		JLabel4.setText("State");
		getContentPane().add(JLabel4);
		JLabel4.setForeground(java.awt.Color.black);
		JLabel4.setBounds(12, 136, 48, 24);
		JLabel5.setText("Zip");
		getContentPane().add(JLabel5);
		JLabel5.setForeground(java.awt.Color.black);
		JLabel5.setBounds(12, 160, 48, 24);
		JLabel6.setText("Birthdate");
		getContentPane().add(JLabel6);
		JLabel6.setForeground(java.awt.Color.black);
		JLabel6.setBounds(12, 184, 96, 24);
		JLabel7.setText("Email");
		getContentPane().add(JLabel7);
		JLabel7.setForeground(java.awt.Color.black);
		JLabel7.setBounds(12, 208, 48, 24);
		getContentPane().add(JTextField_NAME);
		JTextField_NAME.setBounds(84, 64, 156, 20);
		getContentPane().add(JTextField_CT);
		JTextField_CT.setBounds(84, 112, 156, 20);
		getContentPane().add(JTextField_ST);
		JTextField_ST.setBounds(84, 136, 156, 20);
		getContentPane().add(JTextField_STR);
		JTextField_STR.setBounds(84, 88, 156, 20);
		getContentPane().add(JTextField_ZIP);
		JTextField_ZIP.setBounds(84, 160, 156, 20);
		getContentPane().add(JTextField_BD);
		JTextField_BD.setBounds(84, 184, 156, 20);
		getContentPane().add(JTextField_EM);
		JTextField_EM.setBounds(84, 208, 156, 20);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(48, 244, 84, 24);
		JButton_Cancel.setText("Cancel");
		JButton_Cancel.setActionCommand("Cancel");
		getContentPane().add(JButton_Cancel);
		JButton_Cancel.setBounds(156, 244, 84, 24);
		SymMouse aSymMouse = new SymMouse();
		JRadioButton_Chk.addMouseListener(aSymMouse);
		JRadioButton_Sav.addMouseListener(aSymMouse);
		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
		JButton_Cancel.addActionListener(lSymAction);
	}

	JRadioButton JRadioButton_Chk = new JRadioButton();
	JRadioButton JRadioButton_Sav = new JRadioButton();
	JLabel JLabel1 = new JLabel();
	JLabel JLabel2 = new JLabel();
	JLabel JLabel3 = new JLabel();
	JLabel JLabel4 = new JLabel();
	JLabel JLabel5 = new JLabel();
	JLabel JLabel6 = new JLabel();
	JLabel JLabel7 = new JLabel();
	JTextField JTextField_NAME = new JTextField();
	JTextField JTextField_CT = new JTextField();
	JTextField JTextField_ST = new JTextField();
	JTextField JTextField_STR = new JTextField();
	JTextField JTextField_ZIP = new JTextField();
	JTextField JTextField_BD = new JTextField();
	JTextField JTextField_EM = new JTextField();
	JButton JButton_OK = new JButton();
	JButton JButton_Cancel = new JButton();

	JLabel JLabel8 = new JLabel();

	class SymMouse extends java.awt.event.MouseAdapter {
		@Override
		public void mouseClicked(java.awt.event.MouseEvent event) {
			Object object = event.getSource();
			if (object == JRadioButton_Chk)
				JRadioButtonChk_mouseClicked(event);
			else if (object == JRadioButton_Sav)
				JRadioButtonSav_mouseClicked(event);
		}
	}

	void JRadioButtonChk_mouseClicked(java.awt.event.MouseEvent event) {
		JRadioButton_Chk.setSelected(true);
		JRadioButton_Sav.setSelected(false);
	}

	void JRadioButtonSav_mouseClicked(java.awt.event.MouseEvent event) {
		JRadioButton_Chk.setSelected(false);
		JRadioButton_Sav.setSelected(true);
	}

	class SymAction implements java.awt.event.ActionListener {
		@Override
		public void actionPerformed(java.awt.event.ActionEvent event) {
			Object object = event.getSource();
			if (object == JButton_OK)
				JButtonOK_actionPerformed(event);
			else if (object == JButton_Cancel)
				JButtonCalcel_actionPerformed(event);
		}
	}

	void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {

		parentframe.clientName = JTextField_NAME.getText();
		parentframe.street = JTextField_STR.getText();
		parentframe.city = JTextField_CT.getText();
		parentframe.zip = JTextField_ZIP.getText();
		parentframe.state = JTextField_ST.getText();
		parentframe.email = JTextField_EM.getText();
		parentframe.birthDate = JTextField_BD.getText();
		if (JRadioButton_Chk.isSelected())
			parentframe.accountType = "Ch";
		else
			parentframe.accountType = "S";
		parentframe.newaccount = true;
		dispose();
	}

	void JButtonCalcel_actionPerformed(java.awt.event.ActionEvent event) {
		dispose();
	}

	void JButtonChecKing_actionPerformed(java.awt.event.ActionEvent event) {
		JRadioButton_Sav.setSelected(false);
	}

	void JButtonSaving_actionPerformed(java.awt.event.ActionEvent event) {
		JRadioButton_Chk.setSelected(false);
	}

}