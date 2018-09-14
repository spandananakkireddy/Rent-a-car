/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cars.model;

/**
 *
 * @author SPANDANA
 */
public class User {
	private int membershipId;
	private String name;
	private String address;
	private String city;
	private String state;
	private String zipcode;
	private String email;
	private String password;

	public User()   { }

	public void setmembershipid(int id) {
		this.membershipId = id;
	}

	public int getmembershipid() {
		return membershipId;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getname() {
		return name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}
	public void setcity(String city) {
		this.city = city;
	}

	public String getcity() {
		return city;
	}

	public void setstate(String state) {
		this.state = state;
	}

	public String getstate() {
		return state;
	}
	public void setzipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getzipcode() {
		return zipcode;
	}
	public void setemail(String email) {
		this.email = email;
	}

	public String getemail() {
		return email;
	}
	public void setpassword(String password) {
		this.password = password;
	}

	public String getpassword() {
		return password;
	}

}
