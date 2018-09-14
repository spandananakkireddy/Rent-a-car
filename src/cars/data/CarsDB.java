/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cars.data;

import cars.model.Admin;
import cars.model.Car;
import cars.model.Rental;
import cars.model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import cars.data.ConnectionPool;
import java.lang.ClassNotFoundException;
import java.sql.SQLException;


/**
 *
 * @author SPANDANA
 */
public class CarsDB {

	private static List<User> users = null;
	private static List<Car> car=null;
	private static List<Rental> rental=null;

	public static ArrayList<Admin> selectAdmins()

	{
		ArrayList<Admin> admin = new ArrayList<Admin>();
		ConnectionPool pool =null;
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rslt = null;
		String query = "SELECT * FROM InventoryManager";
		try {
			pool = ConnectionPool.getInstance();
			connection = pool.getConnection();
			ps = connection.prepareStatement(query);
			rslt = ps.executeQuery();
			while (rslt.next()) {
				String Username = rslt.getString("username");                
				String Password = rslt.getString("pass");

				Admin p = new Admin();
				p.setaname(Username);
				p.setapassword(Password);

				admin.add(p);
			}
			return admin;
		} 
		catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
			return null;
		} 
		finally {
			pool.freeConnection(connection);        
		}                      
	}
	public static ArrayList<User> selectUser()
	{

		ArrayList<User> users = new ArrayList<User>();
		ConnectionPool pool = null;
		Connection c = null;
		try{

			pool = ConnectionPool.getInstance();
			c=pool.getConnection();
			Statement s = c.createStatement();
			String sql="select * from Customer";
			System.out.print("after select");
			ResultSet productsResSet;
			productsResSet = s.executeQuery(sql);

			if (productsResSet != null) 
			{
				while (productsResSet.next()) 
				{
					User u = new User();
					u.setmembershipid(productsResSet.getInt(1));
					u.setname(productsResSet.getString(2));
					u.setAddress(productsResSet.getString(3));
					u.setcity(productsResSet.getString(4));
					u.setstate(productsResSet.getString(5));
					u.setzipcode(productsResSet.getString(6));
					u.setemail(productsResSet.getString(7));
					u.setpassword(productsResSet.getString(8));

					users.add(u);
				} 
				return users;
			} 

			else {
				System.out.println("else statement");
				return users;
			}                      

		}
		catch(Exception e)
		{
			System.out.println("Exception"+e);
		}

		return users;

	}

	public static User selectUser(String email) {
		users = selectUser();
		for (User p : users) {
			if (email != null
					&& email.equalsIgnoreCase(p.getemail())) {
				return p;
			}
		}
		return null;
	}

	public static User selectUser(String username, String password) {

		users = selectUser();
		for (User p : users) {
			if (username != null
					&& username.equalsIgnoreCase(p.getemail()) && password!=null && password.equals(p.getpassword())) {
				return p;
			}
		}
		return null;
	}

	public static Admin selectAdmin(String uname, String password)  {
		ArrayList<Admin> admin = new ArrayList<Admin>();
		admin = selectAdmins();
		for (Admin p : admin) {
			if (p != null
					&& uname.equals(p.getaname()) && password.equals(p.getapassword())) {
				return p;
			}
		}
		return null;
	}

	public static ArrayList<Car> selectCars() {
		ArrayList<Car> car = new ArrayList<Car>();
		ConnectionPool pool =null;
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rslt = null;
		String query = "SELECT * FROM Car";
		try {
			pool =ConnectionPool.getInstance();
			connection = pool.getConnection();
			ps = connection.prepareStatement(query);
			rslt = ps.executeQuery();
			while (rslt.next()) {
				String carid = rslt.getString("car_id");
				String carname=rslt.getString("car_name");
				String price = rslt.getString("price");

				System.out.println(carid);


				Car m = new Car();
				m.setCarId(carid);
				m.setCarName(carname);
				m.setPrice(price);


				car.add(m);
			}
			return car;

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
			return null;
		} finally {
			pool.freeConnection(connection);
		}
	}

	public static List<Car> updateCar( String c,String n,String p) {
		ConnectionPool pool =null;
		Connection connection = null;
		PreparedStatement ps = null;              
		String query = "UPDATE Car SET car_name = ?, price=? WHERE car_id= ?";
		try {
			pool = ConnectionPool.getInstance();
			connection = pool.getConnection();
			ps = connection.prepareStatement(query);
			ps.setString(1, n);
			ps.setString(2, p);
			ps.setString(3,c);  
			System.out.println(c+" "+n+" "+p+"hi");
			ps.executeUpdate();

			car=selectCars();
			return car;

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);return null;
		} finally {
			pool.freeConnection(connection);
		}
	}

	public static Car selectCar(String car_id) {
		car = selectCars();
		for (Car p : car) {
			if (car_id != null
					&& car_id.equalsIgnoreCase(p.getCarId())) {
				return p;
			}
		}
		return null;
	}

	public static void deleteCar(Car c) {
		ConnectionPool pool = null;

		Connection connection = null;
		PreparedStatement ps = null;

		String query = "DELETE from Car WHERE car_id= ?";
		try {
			pool = ConnectionPool.getInstance();
			connection = pool.getConnection();
			ps = connection.prepareStatement(query);
			ps.setString(1, c.getCarId());
			ps.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			pool.freeConnection(connection);
		}
	}

	public static void editCustomerProfile(User c) {

		ConnectionPool pool = null;

		Connection connection = null;

		PreparedStatement ps = null;              
		String query = "UPDATE Customer SET c_name = ?,address=?,city=?,state=?,zip_code=?,password=?  WHERE email= ?";
		try {
			pool =   ConnectionPool.getInstance();
			connection = pool.getConnection();
			ps = connection.prepareStatement(query);
			ps.setString(1, c.getname());

			ps.setString(2, c.getAddress());
			ps.setString(3, c.getcity());
			ps.setString(4, c.getstate());
			ps.setString(5, c.getzipcode());
			ps.setString(6, c.getemail());
			ps.setString(7, c.getpassword());

			ps.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
		} finally {
			pool.freeConnection(connection);
		}
	}


	public static void insertCustomer(User u)  {        
		ConnectionPool pool = null;

		Connection connection = null;

		PreparedStatement ps = null;
		String query = "INSERT INTO Customer (c_name, address, city, state, zip_code, email, password) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {
			pool = ConnectionPool.getInstance();
			connection = 	pool.getConnection();

			ps = connection.prepareStatement(query);
			ps.setString(1, u.getname());
			ps.setString(2, u.getAddress());
			ps.setString(3, u.getcity());
			ps.setString(4, u.getstate());
			ps.setString(5, u.getzipcode());
			ps.setString(6, u.getemail());
			ps.setString(7, u.getpassword());

			ps.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
		} 


		finally {
			pool.freeConnection(connection);
		}
	}

	public static void insertIntoRental(String id, String uemail) {        
		ConnectionPool pool = null;
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rslt = null;
		int membershipID= 0;
		String cname="";
		String query = "SELECT * FROM Customer WHERE email=?";
		try {    
			pool =  ConnectionPool.getInstance();
			connection =   pool.getConnection();
			ps = connection.prepareStatement(query);
			ps.setString(1, uemail);                        
			rslt=ps.executeQuery();
			while (rslt.next()) {
				membershipID = rslt.getInt("membership_id");

				ps = null;
			}
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
		} 
		String query2 = "SELECT * FROM Car WHERE car_id=?";
		try {            
			ps = connection.prepareStatement(query2);
			ps.setString(1, id);                        
			rslt=ps.executeQuery();
			while (rslt.next()) {
				cname = rslt.getString("car_name");                
				ps = null;
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		String query3 = "INSERT INTO Rental (membership_id,car_id,car_name,email) values (?,?,?,?)";
		try {            
			ps = connection.prepareStatement(query3);
			ps.setInt(1, membershipID); 
			ps.setString(2, id); 
			ps.setString(3,cname);
			ps.setString(4,uemail);

			ps.executeUpdate();           
		} catch (SQLException e) {
			System.out.println(e);
		}                
		finally {
			pool.freeConnection(connection);
		}
	}

	public static void insertCar(Car c) {        
		ConnectionPool pool = null;

		Connection connection = null;

		PreparedStatement ps = null;
		String query = "INSERT INTO Car (car_id,car_name,price) "
				+ "VALUES (?, ?, ?)";
		try { 
			pool = ConnectionPool.getInstance();
			connection = pool.getConnection();
			ps = connection.prepareStatement(query);
			ps.setString(1, c.getCarId());
			ps.setString(2, c.getCarName());
			ps.setString(3, c.getPrice());


			ps.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
		} finally {
			pool.freeConnection(connection);
		}
	}

	public static List<Rental> selectRentals(String uemail) {  
		rental=new ArrayList<Rental>();           
		ConnectionPool pool = null;

		Connection connection = null;

		PreparedStatement ps = null;
		ResultSet rslt = null;
		String query = "SELECT * FROM Rental WHERE email=?";
		try {         
			pool = ConnectionPool.getInstance();
			connection = pool.getConnection();
			ps = connection.prepareStatement(query);
			ps.setString(1, uemail);                        
			rslt=ps.executeQuery();
			while (rslt.next()) {
				int userid = rslt.getInt("membership_id");
				String carId=rslt.getString("car_id");
				String carname = rslt.getString("car_name");

				Rental r=new Rental();

				r.setmembershipId(userid);
				r.setCarId(carId);
				r.setCarName(carname);
				r.setuemail(uemail);                             
				rental.add(r);  
				System.out.println("rental added");
			} 
			return rental; 
		}catch (SQLException | ClassNotFoundException e) {

			System.out.println("SQL exception");
			return null;
		} finally {
			pool.freeConnection(connection);
		}
	}
}

