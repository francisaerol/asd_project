package framework.view.ccard;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;

import framework.control.IController;
import framework.control.command.TransactionTypes;
import framework.view.IFrame;
import framework.view.JDialog_Report;

/**
 * A basic JFC based application.
 */
public class CardFrm extends javax.swing.JFrame implements IFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5083022150039051998L;
	/****
	 * init variables in the object
	 ****/
	public String clientName, street, city, state, zip, email, accountType,
			amountDeposit, expdate, ccnumber;
	public boolean newaccount;
	private DefaultTableModel model;
	private JTable JTable1;
	private JScrollPane JScrollPane1;
	CardFrm thisframe;
	private Object rowdata[];
	private IController cardController;

	public CardFrm() {
		thisframe = this;

		setTitle("Credit-card processing Application.");
		setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setSize(575, 310);
		setVisible(false);
		JPanel1.setLayout(null);
		getContentPane().add(BorderLayout.CENTER, JPanel1);
		JPanel1.setBounds(0, 0, 575, 310);
		/*
		 * /Add five buttons on the pane /for Adding personal account, Adding
		 * company account /Deposit, Withdraw and Exit from the system
		 */
		JScrollPane1 = new JScrollPane();
		model = new DefaultTableModel();
		JTable1 = new JTable(model);
		model.addColumn("Id");
		model.addColumn("Name");
		model.addColumn("Street");
		model.addColumn("City");
		model.addColumn("State");
		model.addColumn("Zip");
		model.addColumn("Email");
		model.addColumn("CC number");
		model.addColumn("Exp date");
		model.addColumn("Type");
		model.addColumn("Balance");

		rowdata = new Object[11];
		newaccount = false;

		JPanel1.add(JScrollPane1);
		JScrollPane1.setBounds(12, 92, 444, 160);
		JScrollPane1.getViewport().add(JTable1);
		JTable1.setBounds(0, 0, 420, 0);

		jCheckBox1.setText("Existing Customer");
		jCheckBox1.setBounds(24, 65, 190, 20);
		JPanel1.add(jCheckBox1);
		// rowdata = new Object[8];

		JButton_NewCCAccount.setText("Add Credit-card account");
		JPanel1.add(JButton_NewCCAccount);
		JButton_NewCCAccount.setBounds(24, 20, 192, 33);
		JButton_GenBill.setText("Generate Monthly bills");
		JButton_GenBill.setActionCommand("jbutton");
		JPanel1.add(JButton_GenBill);
		JButton_GenBill.setBounds(240, 20, 192, 33);
		JButton_Deposit.setText("Deposit");
		JPanel1.add(JButton_Deposit);
		JButton_Deposit.setBounds(468, 104, 96, 33);
		JButton_Withdraw.setText("Charge");
		JPanel1.add(JButton_Withdraw);
		JButton_Withdraw.setBounds(468, 164, 96, 33);
		JButton_Exit.setText("Exit");
		JPanel1.add(JButton_Exit);
		JButton_Exit.setBounds(468, 248, 96, 31);

		JButton_GenBill.setActionCommand("jbutton");

		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		SymAction lSymAction = new SymAction();
		JButton_Exit.addActionListener(lSymAction);
		JButton_NewCCAccount.addActionListener(lSymAction);
		JButton_GenBill.addActionListener(lSymAction);
		JButton_Deposit.addActionListener(lSymAction);
		JButton_Withdraw.addActionListener(lSymAction);
		jCheckBox1.addActionListener(lSymAction);

	}

	/*****************************************************
	 * The entry point for this application. Sets the Look and Feel to the
	 * System Look and Feel. Creates a new JFrame1 and makes it visible.
	 *****************************************************/

	javax.swing.JPanel JPanel1 = new javax.swing.JPanel();
	javax.swing.JButton JButton_NewCCAccount = new javax.swing.JButton();
	javax.swing.JButton JButton_GenBill = new javax.swing.JButton();
	javax.swing.JButton JButton_Deposit = new javax.swing.JButton();
	javax.swing.JButton JButton_Withdraw = new javax.swing.JButton();
	javax.swing.JButton JButton_Exit = new javax.swing.JButton();
	JCheckBox jCheckBox1 = new javax.swing.JCheckBox();
	javax.swing.JButton JButton_Addinterest = new javax.swing.JButton();

	void exitApplication() {
		try {
			this.setVisible(false); // hide the Frame
			this.dispose(); // free the system resources
			System.exit(0); // close the application
		} catch (Exception e) {
		}
	}

	class SymWindow extends java.awt.event.WindowAdapter {
		public void windowClosing(java.awt.event.WindowEvent event) {
			Object object = event.getSource();
			if (object == CardFrm.this)
				BankFrm_windowClosing(event);
		}
	}

	boolean isExisting = false;

	void jCheckBox1_actionPerformed(ActionEvent evt) {
		isExisting = jCheckBox1.isSelected();
		System.out.println("but" + isExisting);
	}

	void BankFrm_windowClosing(java.awt.event.WindowEvent event) {
		// to do: code goes here.

		BankFrm_windowClosing_Interaction1(event);
	}

	void BankFrm_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
		try {
			this.exitApplication();
		} catch (Exception e) {
		}
	}

	class SymAction implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent event) {
			Object object = event.getSource();
			if (object == JButton_Exit)
				JButtonExit_actionPerformed(event);
			else if (object == JButton_NewCCAccount)
				JButtonNewCCAC_actionPerformed(event);
			else if (object == JButton_GenBill)
				JButtonGenerateBill_actionPerformed(event);
			else if (object == JButton_Deposit)
				JButtonDeposit_actionPerformed(event);
			else if (object == JButton_Withdraw)
				JButtonWithdraw_actionPerformed(event);
			else if (object == jCheckBox1) {
				jCheckBox1_actionPerformed(event);
			}

		}
	}

	// When the Exit button is pressed this code gets executed
	// this will exit from the system
	void JButtonExit_actionPerformed(java.awt.event.ActionEvent event) {
		System.exit(0);
	}

	void JButtonNewCCAC_actionPerformed(java.awt.event.ActionEvent event) {
		/*
		 * JDialog_AddPAcc type object is for adding personal information
		 * construct a JDialog_AddPAcc type object set the boundaries and show
		 * it
		 */
		System.out.println("isExisting " + isExisting);
		if (isExisting) {

			int selection = JTable1.getSelectionModel().getMinSelectionIndex();
			JDialog_AddCCAccount exist = new JDialog_AddCCAccount(thisframe);
			exist.setBounds(450, 20, 300, 380);

			exist.JTextField_NAME.setText(String.valueOf(model.getValueAt(
					selection, 1)));
			exist.JTextField_NAME.setEditable(false);
			exist.JTextField_STR.setText(String.valueOf(model.getValueAt(
					selection, 2)));
			exist.JTextField_STR.setEditable(false);
			exist.JTextField_CT.setText(String.valueOf(model.getValueAt(
					selection, 3)));
			exist.JTextField_CT.setEditable(false);
			exist.JTextField_CT.setText(String.valueOf(model.getValueAt(
					selection, 3)));
			exist.JTextField_CT.setEditable(false);
			exist.JTextField_ST.setText(String.valueOf(model.getValueAt(
					selection, 4)));
			exist.JTextField_ST.setEditable(false);
			exist.JTextField_ZIP.setText(String.valueOf(model.getValueAt(
					selection, 5)));
			exist.JTextField_ZIP.setEditable(false);
			exist.JTextField_Email.setText(String.valueOf(model.getValueAt(
					selection, 6)));
			exist.JTextField_Email.setEditable(false);
			exist.JTextField_CCNR.setText(String.valueOf(model.getValueAt(
					selection, 7)));
			exist.JTextField_CCNR.setEditable(false);
			exist.JTextField_ExpDate.setText(String.valueOf(model.getValueAt(
					selection, 8)));
			exist.JTextField_ExpDate.setEditable(false);

			exist.setVisible(true);

			if (newaccount) {
				rowdata[0] = "";
				rowdata[1] = clientName;
				rowdata[2] = street;
				rowdata[3] = city;
				rowdata[4] = state;
				rowdata[5] = zip;
				rowdata[6] = email;
				rowdata[7] = ccnumber;
				rowdata[8] = expdate;
				rowdata[9] = accountType;
				rowdata[10] = "0";

				cardController.addNewAccount(model.getValueAt(selection, 0)
						.toString(), accountType);
				rowdata[0] = cardController.getAcctNo();
				model.addRow(rowdata);

				JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
			}
		} else {

			JDialog_AddCCAccount ccac = new JDialog_AddCCAccount(thisframe);
			ccac.setBounds(450, 20, 300, 380);
			ccac.setVisible(true);
			if (newaccount) {
				// add row to table

				rowdata[0] = "";
				rowdata[1] = clientName;
				rowdata[2] = street;
				rowdata[3] = city;
				rowdata[4] = state;
				rowdata[5] = zip;
				rowdata[6] = email;
				rowdata[7] = ccnumber;
				rowdata[8] = expdate;
				rowdata[9] = accountType;
				rowdata[10] = "0";

				String[] stringArray = Arrays.copyOf(rowdata, rowdata.length,
						String[].class);
				cardController.addCustomer(stringArray);
				rowdata[0] = cardController.getAcctNo();

				model.addRow(rowdata);
				JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
			}
		}
		newaccount = false;
	}

	void JButtonGenerateBill_actionPerformed(java.awt.event.ActionEvent event) {
		JDialog_Report billFrm = new JDialog_Report(
				cardController.getReportName(), cardController.getReport());
		billFrm.setBounds(450, 20, 400, 350);
		billFrm.setVisible(true);

	}

	boolean isCancel = false;

	void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event) {
		// get selected name
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			String acctNumber = (String) model.getValueAt(selection, 0);

			// Show the dialog for adding deposit amount for the current mane
			JDialog_Deposit dep = new JDialog_Deposit(thisframe, acctNumber);
			dep.setBounds(430, 15, 275, 140);
			dep.setVisible(true);
			if (isCancel) {
				// compute new a mount
				Double deposit = Double.parseDouble(amountDeposit);

				cardController.transact(TransactionTypes.DEPOSIT, acctNumber,
						deposit);
				model.setValueAt(String.valueOf(cardController.getBalance()),
						selection, 10);
			}
		}

	}

	void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event) {
		// get selected name
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			String acctNumber = (String) model.getValueAt(selection, 0);

			// Show the dialog for adding withdraw amount for the current mane
			JDialog_Withdraw wd = new JDialog_Withdraw(thisframe, acctNumber);
			wd.setBounds(430, 15, 275, 140);
			wd.setVisible(true);

			// compute new amount
			Double value = Double.parseDouble(amountDeposit);
			cardController.transact(TransactionTypes.WITHDRAW, acctNumber,
					value);
			model.setValueAt(String.valueOf(cardController.getBalance()),
					selection, 4);
			if (cardController.getBalance() < 0) {
				JOptionPane.showMessageDialog(JButton_Withdraw,
						" " + acctNumber + " Your balance is negative: $"
								+ String.valueOf(cardController.getBalance())
								+ " !", "Warning: negative balance",
						JOptionPane.WARNING_MESSAGE);
			}
		}

	}

	@Override
	public void setController(IController control) {
		this.cardController = control;
	}

}
