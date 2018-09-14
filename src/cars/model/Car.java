package cars.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SPANDANA
 */
public class Car {
	String carid;
	String price;
	String carname;

	public void setCarId(String id) {
		this.carid = id;
	}

	public String getCarId() {
		return carid;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPrice() {
		return price;
	}

	public void setCarName(String car_name) {
		this.carname = car_name;
	}

	public String getCarName() {
		return carname;
	}


}
