package custom.bank.UI;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 

 
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Adit
 */
public class Facade {
    
    public BankFrm mainFrame;
  
    
    
    private static Facade _instance;
    public static Facade getInstace()
    {
        if(_instance == null){
            _instance = new Facade();
        }
        return _instance;
    }
    private Component JButton_Addinterest;
    private Component JButton_Withdraw;
    
  
    
    
    /*showing MainUI*/
    public void showBankMain(){
        try {
		    
		try {
		        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		    } 
		catch (Exception e) { 
                    
		}
		    
			//Create a new instance of our application's frame, and make it visible.
	        (new BankFrm()).setVisible(true);
		} 
		catch (Throwable t) {
			t.printStackTrace();
			//Ensure the application exits with an error condition.
			System.exit(1);
		}
    }
    /*Showing Company Account UI*/
    public void showAddCompanyAccount()
    {
                JDialog_AddCompAcc pac = new JDialog_AddCompAcc(mainFrame);
		pac.setBounds(450, 20, 300, 330);
		pac.show();
    }
    /*Showing Company Account UI*/
    
    
    
    /*Showing Personal Account UI*/
    public void showAddPersonalAccount()
    {
     		JDialog_AddPAcc pac = new JDialog_AddPAcc(mainFrame);
		pac.setBounds(450, 20, 300, 330);
		pac.show();
    }
    
     /*Showing Personal Account UI*/
    
    /*Adding Interest to all Account*/
    
    public void AddInterestToAllAccounts(){
    
      JOptionPane.showMessageDialog(JButton_Addinterest, "Add interest to all accounts","Add interest to all accounts",JOptionPane.WARNING_MESSAGE);
	    
    }
    
    public void showWidrawSubview(String AccountNo){
    		    
        	 
        
                    JDialog_Withdraw wd = new JDialog_Withdraw(mainFrame,AccountNo);
		    wd.setBounds(430, 15, 275, 140);
		    wd.show();
        
        
//        int selection = mainFrame.JTable1.getSelectionModel().getMinSelectionIndex();
//        if (selection >=0){
//            String accnr = (String)mainFrame.model.getValueAt(selection, 0);
//
//		    //Show the dialog for adding withdraw amount for the current mane
//		    JDialog_Withdraw wd = new JDialog_Withdraw(mainFrame,accnr);
//		    wd.setBounds(430, 15, 275, 140);
//		    wd.show();
//    		
//		    // compute new amount
//                    long deposit = Long.parseLong(mainFrame.amountDeposit);
//                    String samount = (String)mainFrame.model.getValueAt(selection, 5);
//                    long currentamount = Long.parseLong(samount);
//		    long newamount=currentamount-deposit;
//		    mainFrame.model.setValueAt(String.valueOf(newamount),selection, 5);
//		    if (newamount <0){
//		       JOptionPane.showMessageDialog(JButton_Withdraw, " Account "+accnr+" : balance is negative: $"+String.valueOf(newamount)+" !","Warning: negative balance",JOptionPane.WARNING_MESSAGE);
//		    }
//		}
    
    }
    
    public void showDepositView(String AccountNo){
        
        
        
                   JDialog_Deposit dep = new JDialog_Deposit(mainFrame,AccountNo);
		    dep.setBounds(430, 15, 275, 140);
		    dep.show();
                    
        // get selected name
//        int selection = mainFrame.JTable1.getSelectionModel().getMinSelectionIndex();
//        if (selection >=0){
//            String accnr = (String)mainFrame.model.getValueAt(selection, 0);
//    	    
//		    //Show the dialog for adding deposit amount for the current mane
////		    JDialog_Deposit dep = new JDialog_Deposit(myframe,accnr);
////		    dep.setBounds(430, 15, 275, 140);
////		    dep.show();
//    		
//		    // compute new amount
//            long deposit = Long.parseLong(mainFrame.amountDeposit);
//            String samount = (String)mainFrame.model.getValueAt(selection, 5);
//            long currentamount = Long.parseLong(samount);
//	    long newamount=currentamount+deposit;
//            mainFrame.model.setValueAt(String.valueOf(newamount),selection, 5);
//            
//	}
    
    }
    
    
    /*Its gonna create company Account*/
    public void createCompanyAccount(Object compObj){
    
    
    }
    /*Its gonna create Personal Account*/
    public void createPersonalAccount(Object compObj){
    
    
    }  
    
    /*Its gonna add deposite money to selected account*/
    
    public void AddDepositeToAccount(Object compObj){
    
    
    }   
    
    /*Its gonna widraw money from selected Account*/
    public void WidrawMoneyFromAccount(Object compObj){
    
    
    }      
}
