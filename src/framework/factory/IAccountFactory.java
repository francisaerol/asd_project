/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package framework.factory;

/**
 *
 * @author Adit
 */
public interface IAccountFactory {
    
   public IAccount createAccount(PersonalCustomer cust);
  
}
