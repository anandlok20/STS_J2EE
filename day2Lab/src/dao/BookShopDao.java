/**
 * 
 */
package dao;

import core.Customer;

/**
 * @author Anand Lok
 *
 */
public interface BookShopDao {
	Customer validateCustomer(String email, String pass) throws Exception;
}