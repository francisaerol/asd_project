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
public class SimpleAccount {
    
   
    
    public ICustomerFactory getICustomerFactory(){
    
        return new CustomerFactory();
    }
    
    public IAccountFactory getAccountFactory(){
    
        return new CompanyAccFactory();
    }
}
