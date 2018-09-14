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
public class Rental {
	private int membership_id;
	private String uemail;
	private String car_name;
	private String car_id;

	public Rental(){}

	public void setmembershipId(int userid) {
		this.membership_id = userid;
	}
	public int getmembershipId() {
		return membership_id;
	}
	public void setuemail(String email) {
		this.uemail = email;
	}
	public String getuemail() {
		return uemail;
	}
	public void setCarName(String title) {
		this.car_name = title;
	}
	public String getCarName() {
		return car_name;
	}
	public void setCarId(String carid) {
		this.car_id = carid;
	}
	public String getCarId() {
		return car_id;
	}
}
