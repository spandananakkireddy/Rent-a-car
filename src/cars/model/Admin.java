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
public class Admin {
	private String ausername;
	private String apassword;
	public Admin(){}

	public void setaname(String name) {
		this.ausername =name;
	}

	public String getaname() {
		return ausername;
	}
	public void setapassword(String pass) {
		this.apassword = pass;
	}

	public String getapassword() {
		return apassword;
	}

}
