package framework.view.bank;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import framework.control.IController;
import framework.control.command.TransactionTypes;
import framework.view.IFrame;
import framework.view.JDialog_Report;
import framework.view.messages.Message;

public class BankFrm extends JFrame implements IFrame {

	private static final long serialVersionUID = 3848527839309928931L;

	String accountnr, clientName, street, city, zip, state, email, accountType,
			clientType, amountDeposit, birthDate, noOfEmp, interest;
	boolean newaccount;
	private DefaultTableModel model;
	private JTable JTable1;
	private JScrollPane JScrollPane1;
	private BankFrm myframe;
	private Object rowdata[];
	private Message msg = new Message();
	boolean isExisting = false;

	private IController control;
	JPanel JPanel1 = new JPanel();
	JButton JButton_PerAC = new JButton();
	JButton JButton_CompAC = new JButton();
	JButton JButton_Deposit = new JButton();
	JButton JButton_Withdraw = new JButton();
	JButton JButton_Addinterest = new JButton();
	JButton JButton_GenerateBill = new JButton();
	JButton JButton_Exit = new JButton();
	JCheckBox jCheckBox1 = new JCheckBox();

	public BankFrm() {
		myframe = this;
		setTitle("Bank Application.");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setSize(650, 350);
		setVisible(false);
		JPanel1.setLayout(null);
		getContentPane().add(BorderLayout.CENTER, JPanel1);
		JPanel1.setBounds(0, 0, 600, 500);

		JScrollPane1 = new JScrollPane();
		model = new DefaultTableModel();
		JTable1 = new JTable(model);
		model.addColumn("AccountNr");
		model.addColumn("Name");
		model.addColumn("Street");
		model.addColumn("State");
		model.addColumn("Zip");
		model.addColumn("City");
		model.addColumn("BirthDate");
		model.addColumn("Email");
		model.addColumn("P/C");
		model.addColumn("Ch/S");
		model.addColumn("Amount");

		rowdata = new Object[11];
		newaccount = false;

		JPanel1.add(JScrollPane1);
		JScrollPane1.setBounds(12, 92, 444, 160);
		JScrollPane1.getViewport().add(JTable1);
		JTable1.setBounds(0, 0, 420, 0);

		JButton_PerAC.setText("Add personal account");
		JPanel1.add(JButton_PerAC);
		JButton_PerAC.setBounds(24, 20, 192, 33);

		JButton_CompAC.setText("Add company account");
		JButton_CompAC.setActionCommand("jbutton");
		JPanel1.add(JButton_CompAC);
		jCheckBox1.setText("Existing Customer");
		jCheckBox1.setBounds(24, 65, 190, 20);

		JPanel1.add(jCheckBox1);

		JButton_CompAC.setBounds(240, 20, 192, 33);

		JButton_Deposit.setText("Deposit");
		JPanel1.add(JButton_Deposit);
		JButton_Deposit.setBounds(468, 104, 96, 33);
		JButton_Withdraw.setText("Withdraw");
		JPanel1.add(JButton_Withdraw);

		JButton_GenerateBill.setBounds(468, 205, 126, 33);
		JButton_GenerateBill.setText("Report");
		JPanel1.add(JButton_GenerateBill);

		JButton_Addinterest.setBounds(470, 20, 106, 33);
		JButton_Addinterest.setText("Add interest");
		JPanel1.add(JButton_Addinterest);

		JButton_Withdraw.setBounds(468, 155, 96, 33);

		JButton_Exit.setText("Exit");
		JPanel1.add(JButton_Exit);
		JButton_Exit.setBounds(468, 248, 96, 31);

		JButton_PerAC.setActionCommand("jbutton");

		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		SymAction lSymAction = new SymAction();
		JButton_Exit.addActionListener(lSymAction);
		JButton_PerAC.addActionListener(lSymAction);
		JButton_CompAC.addActionListener(lSymAction);
		JButton_Deposit.addActionListener(lSymAction);
		JButton_Withdraw.addActionListener(lSymAction);
		JButton_Addinterest.addActionListener(lSymAction);
		JButton_GenerateBill.addActionListener(lSymAction);
		jCheckBox1.addActionListener(lSymAction);

	}

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
			if (object == BankFrm.this)
				BankFrm_windowClosing(event);
		}
	}

	void BankFrm_windowClosing(java.awt.event.WindowEvent event) {
		BankFrm_windowClosing_Interaction1(event);
	}

	void BankFrm_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
		try {
			this.exitApplication();
		} catch (Exception e) {
		}
	}

	class SymAction implements java.awt.event.ActionListener {
		@Override
		public void actionPerformed(java.awt.event.ActionEvent event) {

			Object object = event.getSource();
			if (object == JButton_Exit)
				JButtonExit_actionPerformed(event);
			else if (object == JButton_PerAC)
				JButtonPerAC_actionPerformed(event);
			else if (object == JButton_CompAC)
				JButtonCompAC_actionPerformed(event);
			else if (object == JButton_Deposit)
				JButtonDeposit_actionPerformed(event);
			else if (object == JButton_Withdraw)
				JButtonWithdraw_actionPerformed(event);
			else if (object == JButton_Addinterest)
				JButtonAddinterest_actionPerformed(event);
			else if (object == JButton_GenerateBill) {
				JButtonGenerateBill_actionPerformed(event);
			} else if (object == jCheckBox1) {
				jCheckBox1_actionPerformed(event);
			}

		}
	}

	void jCheckBox1_actionPerformed(ActionEvent evt) {
		isExisting = jCheckBox1.isSelected();
	}

	void JButtonGenerateBill_actionPerformed(java.awt.event.ActionEvent event) {

		control.transact(TransactionTypes.GENERATE_REPORT, null, null);

		JDialog_Report Rpac = new JDialog_Report(control.getReportName(),
				control.getReport());
		Rpac.setBounds(450, 20, 400, 400);
		Rpac.setVisible(true);
	}

	void JButtonExit_actionPerformed(java.awt.event.ActionEvent event) {
		System.exit(0);
	}

	void JButtonPerAC_actionPerformed(java.awt.event.ActionEvent event) {
		if (isExisting) {
			int selection = JTable1.getSelectionModel().getMinSelectionIndex();

			JDialog_AddPAcc exist = new JDialog_AddPAcc(myframe);
			exist.setBounds(450, 20, 300, 330);
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
			exist.JTextField_BD.setText(String.valueOf(model.getValueAt(
					selection, 6)));
			exist.JTextField_BD.setEditable(false);
			exist.JTextField_EM.setText(String.valueOf(model.getValueAt(
					selection, 7)));
			exist.JTextField_EM.setEditable(false);

			exist.setVisible(true);
			if (newaccount) {
				rowdata[1] = model.getValueAt(selection, 1);
				rowdata[2] = model.getValueAt(selection, 2);
				rowdata[3] = model.getValueAt(selection, 3);
				rowdata[4] = model.getValueAt(selection, 4);
				rowdata[5] = model.getValueAt(selection, 5);
				rowdata[6] = model.getValueAt(selection, 6);
				rowdata[7] = model.getValueAt(selection, 7);
				rowdata[8] = "P";
				rowdata[9] = accountType;
				rowdata[10] = "0";

				control.addNewAccount(
						model.getValueAt(selection, 0).toString(), accountType);
				rowdata[0] = control.getAcctNo();
				model.addRow(rowdata);

				JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
			}

		} else {
			JDialog_AddPAcc pac = new JDialog_AddPAcc(myframe);
			pac.setBounds(450, 20, 300, 330);
			pac.setVisible(true);
			if (newaccount) {
				rowdata[0] = accountnr;
				rowdata[1] = clientName;
				rowdata[2] = street;
				rowdata[3] = city;
				rowdata[4] = state;
				rowdata[5] = zip;
				rowdata[6] = birthDate;
				rowdata[7] = email;
				rowdata[8] = "P";
				rowdata[9] = accountType;
				rowdata[10] = "0";

				String[] newArr = Arrays.copyOf(rowdata, rowdata.length,
						String[].class);
				control.addCustomer(newArr);
				rowdata[0] = control.getAcctNo();
				model.addRow(rowdata);

				JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
			}
		}
		newaccount = false;
	}

	void JButtonCompAC_actionPerformed(java.awt.event.ActionEvent event) {
		if (isExisting) {
			int selection = JTable1.getSelectionModel().getMinSelectionIndex();

			JDialog_AddCompAcc exist = new JDialog_AddCompAcc(myframe);
			exist.setBounds(450, 20, 300, 330);
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
			exist.JTextField_NoOfEmp.setText(String.valueOf(model.getValueAt(
					selection, 6)));
			exist.JTextField_NoOfEmp.setEditable(false);
			exist.JTextField_EM.setText(String.valueOf(model.getValueAt(
					selection, 7)));
			exist.JTextField_EM.setEditable(false);

			exist.setVisible(true);
			if (newaccount) {
				rowdata[1] = model.getValueAt(selection, 1);
				rowdata[2] = model.getValueAt(selection, 2);
				rowdata[3] = model.getValueAt(selection, 3);
				rowdata[4] = model.getValueAt(selection, 4);
				rowdata[5] = model.getValueAt(selection, 5);
				rowdata[6] = model.getValueAt(selection, 6);
				rowdata[7] = model.getValueAt(selection, 7);
				rowdata[8] = "C";
				rowdata[9] = accountType;
				rowdata[10] = "0";

				control.addNewAccount(
						model.getValueAt(selection, 0).toString(), accountType);
				rowdata[0] = control.getAcctNo();
				model.addRow(rowdata);

				JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
			}

		} else {
			JDialog_AddCompAcc pac = new JDialog_AddCompAcc(myframe);
			pac.setBounds(450, 20, 300, 330);
			pac.setVisible(true);
			if (newaccount) {
				rowdata[0] = accountnr;
				rowdata[1] = clientName;
				rowdata[2] = street;
				rowdata[3] = city;
				rowdata[4] = state;
				rowdata[5] = zip;
				rowdata[6] = noOfEmp;
				rowdata[7] = email;
				rowdata[8] = "C";
				rowdata[9] = accountType;
				rowdata[10] = "0";

				String[] newArr = Arrays.copyOf(rowdata, rowdata.length,
						String[].class);
				control.addCustomer(newArr);
				rowdata[0] = control.getAcctNo();
				model.addRow(rowdata);
				JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
			}
		}
		newaccount = false;
	}

	void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event) {
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			String accnr = (String) model.getValueAt(selection, 0);

			JDialog_Deposit dep = new JDialog_Deposit(myframe, accnr);
			dep.setBounds(430, 15, 275, 140);
			dep.setVisible(true);

			Double deposit = Double.parseDouble(amountDeposit);
			control.transact(TransactionTypes.DEPOSIT, accnr, deposit);
			model.setValueAt(String.valueOf(control.getBalance()), selection,
					10);

		}

	}

	void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event) {
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			String accnr = (String) model.getValueAt(selection, 0);

			JDialog_Withdraw wd = new JDialog_Withdraw(myframe, accnr);
			wd.setBounds(430, 15, 275, 140);
			wd.setVisible(true);

			Double wdraw = Double.parseDouble(amountDeposit);
			control.transact(TransactionTypes.WITHDRAW, accnr, wdraw);
			model.setValueAt(String.valueOf(control.getBalance()), selection,
					10);
			if (control.getBalance() < 0) {
				msg.warning(JButton_Withdraw,
						" Account " + accnr + " : balance is negative: $"
								+ String.valueOf(control.getBalance()) + " !");
			}
		}

	}

	void addInterest() {
		if (interest != null) {
			control.transact(TransactionTypes.ADD_INTEREST, null,
					Double.parseDouble(interest));
		}
	}

	void JButtonAddinterest_actionPerformed(java.awt.event.ActionEvent event) {
		JDialog_AddInterest pac = new JDialog_AddInterest(myframe);
		pac.setBounds(430, 15, 200, 200);
		pac.setVisible(true);
	}

	@Override
	public void setController(IController control) {
		this.control = control;

	}

}
