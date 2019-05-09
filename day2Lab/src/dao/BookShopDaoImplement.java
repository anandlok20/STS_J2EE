/**
 * 
 */
package dao;

import core.Customer;
import java.sql.*;
import static dBUtils.DBUtils.*;

/**
 * @author Anand Lok
 *
 */
public class BookShopDaoImplement implements BookShopDao
{
	private Connection cn;
	private PreparedStatement pst;
	/**
	 * @param cn
	 * @param pst
	 */
	public BookShopDaoImplement() throws Exception {
		cn = fetchConnection();
		pst = cn.prepareStatement("select * from my_customers where email=? and password=?");
	}
	
	public void closeAll() throws Exception
	{
		if(cn!=null) {
			cn.close();
		}
		if(pst!=null) {
			pst.close();
		}
	}

	@Override
	public Customer validateCustomer(String email, String pass) throws Exception {
		pst.setString(1, email);
		pst.setString(2, pass);
		try(ResultSet rst=pst.executeQuery()) {
			if(rst.next())
				return new Customer(rst.getInt(1), rst.getDouble(2), email, rst.getString(4), pass, rst.getDate(6), rst.getString(7));
		}
		return null;
	}
	
	
	
	
}
