/**
 * 
 */
package pojos;

import java.sql.Date;

/**
 * @author Anand Lok
 *
 */
public class Vendor {
	private int id;
	private String name,email,city;
	private int cell_no;
	private double reg_amt;
	private Date reg_date;
	private String role;

	public Vendor() {}

	public Vendor(int id, String name, String email, String city, int cell_no, double reg_amt, Date reg_date,
			String role) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.city = city;
		this.cell_no = cell_no;
		this.reg_amt = reg_amt;
		this.reg_date = reg_date;
		this.role = role;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the cell_no
	 */
	public int getCell_no() {
		return cell_no;
	}
	/**
	 * @param cell_no the cell_no to set
	 */
	public void setCell_no(int cell_no) {
		this.cell_no = cell_no;
	}
	/**
	 * @return the reg_amt
	 */
	public double getReg_amt() {
		return reg_amt;
	}
	/**
	 * @param reg_amt the reg_amt to set
	 */
	public void setReg_amt(double reg_amt) {
		this.reg_amt = reg_amt;
	}
	/**
	 * @return the reg_date
	 */
	public Date getReg_date() {
		return reg_date;
	}
	/**
	 * @param reg_date the reg_date to set
	 */
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Vendor [id=" + id + ", name=" + name + ", email=" + email + ", city=" + city + ", cell_no=" + cell_no
				+ ", reg_amt=" + reg_amt + ", reg_date=" + reg_date + ", role=" + role + "]";
	}
	
}