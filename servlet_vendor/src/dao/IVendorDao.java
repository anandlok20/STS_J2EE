/**
 * 
 */
package dao;
import java.util.List;

import pojos.Vendor;
/**
 * @author Anand Lok
 *
 */
public interface IVendorDao {
	public List<Vendor> getVendor() throws Exception;
	public void deleteCustomer(int rid) throws Exception;
	public void updateCustomer(int rid) throws Exception;
}