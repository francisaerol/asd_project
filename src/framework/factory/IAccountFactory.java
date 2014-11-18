/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package framework.factory;

import framework.factory.customer.IAccount;
import framework.factory.customer.ICustomer;

/**
 *
 * @author Adit
 */
public interface IAccountFactory {

	public abstract IAccount createAccount(ICustomer cust);

}
