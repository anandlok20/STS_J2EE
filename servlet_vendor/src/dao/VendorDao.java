/**
 * 
 */
package dao;

import static utils.DbUtils.*;
import java.sql.*;
import java.util.*;
import pojos.Vendor;

/**
 * @author Anand Lok
 *
 */
public class VendorDao implements IVendorDao {
	private Connection cn;
	private PreparedStatement ps,ps1;
	/**
	 * @param cn
	 * @param ps
	 */
	public VendorDao() throws Exception{
		cn = fetchConnection();
		ps = cn.prepareStatement("select * from vendor");
		ps1= cn.prepareStatement("DELETE FROM vendor WHERE id=?");
		System.out.println("dao created..");
	}
	public void cleanUp() throws Exception
	{
		if(ps!=null)
			ps.close();
		if(ps1!=null)
			ps1.close();
		if(cn!=null)
			cn.close();
	}
	@Override
	public List<Vendor> getVendor() throws Exception {
		ArrayList<Vendor> ar=new ArrayList<>();
		try (ResultSet rs=ps.executeQuery())
		{
			while(rs.next())
			{
				ar.add(new Vendor(rs.getInt("id"),rs.getString("name"),rs.getString("email"),rs.getString("city"),rs.getInt("cell_no"),rs.getDouble("reg_amt"),rs.getDate("reg_date"),rs.getString("role")));
			}
			return ar;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void deleteCustomer(int rid) throws Exception
	{
		ps1.setInt(1, rid);
		try
		{
			int rt=ps1.executeUpdate();
			if(rt==1)
				System.out.println("Deleted");
			else 
				System.out.println("Failure");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void updateCustomer(int rid) throws Exception
	{
		
	}
	
}
