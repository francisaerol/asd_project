/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package framework.factory.customer;

import java.util.List;

/**
 *
 * @author Adit
 */
public interface ICustomer {

	public String getName();

	public List<IAddress> getAddress();

	public String getEmail();

	public void addAddress(IAddress address);

}
