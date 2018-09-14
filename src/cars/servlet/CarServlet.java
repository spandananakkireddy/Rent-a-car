/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cars.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cars.model.*;
import cars.model.Car;
import cars.data.*;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author SPANDANA
 */

@WebServlet(name = "CarServlet", urlPatterns = {"/CarServlet"})
public class CarServlet extends HttpServlet {

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try  {
			/* TODO output your page here. You may use following sample code. */
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet CarServlet</title>");            
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Servlet CarServlet at " + request.getContextPath() + "</h1>");
			out.println("</body>");
			out.println("</html>");
		}
		finally {
			out.close();
		}
	}


	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		String url = null;

		if (action == null) {
			action = "add";
			url = "/index.jsp";
		}
		if (action.equals("edit")) {
			String id = request.getParameter("carId");
			Car car = CarsDB.selectCar(id);            
			request.setAttribute("car", car);
			url = "/editcar.jsp";
		}

		if (action.equals("viewcarsbyuser")) {
			String id = request.getParameter("uemail");
			List<Car> cList = CarsDB.selectCars();
			request.setAttribute("carList", cList);
			request.setAttribute("username", id);
			url = "/viewcars.jsp";
		}

		if (action.equals("delete")) {
			String id = request.getParameter("carId");
			Car car = CarsDB.selectCar(id);
			request.setAttribute("car", car);
			url = "/confirmdelete.jsp";
		}

		if(action.equals("rentcar")){
			String id=request.getParameter("carId");
			String uemail=request.getParameter("uemail");
			System.out.println("--------------");
			CarsDB.insertIntoRental(id,uemail);
			List<Rental> rentals= CarsDB.selectRentals(uemail);
			request.setAttribute("rentals",rentals);
			request.setAttribute("uemail", uemail);      
			url="/mail.jsp";          
		}

		if(action.equals("editprofile"))
		{
			String email=request.getParameter("uemail");
			User u=CarsDB.selectUser(email);
			request.setAttribute("cust",u);     
			url="/editProfile.jsp";
		}

		getServletContext()
		.getRequestDispatcher(url)
		.forward(request,response);

	}
	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = null;

		if (request.getParameter("addcar") != null) {
			String carid = request.getParameter("carid");
			String cname = request.getParameter("carname");
			String p = request.getParameter("price");

			Car c = new Car();
			c.setCarId(carid);
			c.setCarName(cname);
			c.setPrice(p);

			CarsDB.insertCar(c);
			url = "/Afteraddcar.jsp";                              
		}

		if (request.getParameter("register") != null) {

			String name = request.getParameter("name"); 
			String Address = request.getParameter("address");
			String City = request.getParameter("city");
			String State = request.getParameter("state");
			String Zipcode = request.getParameter("zipcode");
			String Email = request.getParameter("email");
			String Password = request.getParameter("password");

			User u = new User();
			u.setmembershipid(50);
			u.setname(name);  
			u.setAddress(Address);
			u.setcity(City);
			u.setstate(State);
			u.setzipcode(Zipcode);
			u.setemail(Email);
			u.setpassword(Password);
			CarsDB.insertCustomer(u);

			request.setAttribute("success","success");
			url = "/AfterRegister.jsp";   	
		}

		if(request.getParameter("adminlogin")!=null)
		{
			String Name=request.getParameter("adminname");
			String Password=request.getParameter("adminpassword");
			Admin a= CarsDB.selectAdmin(Name, Password);

			if(a!=null)
				url="/addcar.jsp";
			else
				url="/index.jsp";

		}

		if(request.getParameter("login")!=null)
		{
			String Email=request.getParameter("username");
			String Password=request.getParameter("password");
			User u= CarsDB.selectUser(Email, Password);

			if(u!=null)
			{
				String name=u.getname();
				request.setAttribute("username", name);
				url="/main.jsp";
			}
			else
			{
				url="/index.jsp";
			}
		}

		if (request.getParameter("viewcars")!=null) {
			ArrayList<Car> cList = new ArrayList<Car>();
			cList = CarsDB.selectCars();
			System.out.println(cList.get(0).getCarName());
			request.setAttribute("carList", cList);
			url = "/cars.jsp";
		}

		if (request.getParameter("UpdateExist") != null) {
			String title = request.getParameter("cname");
			String year = request.getParameter("price");
			String cid=request.getParameter("cid");

			List<Car> carList = CarsDB.updateCar(cid, title,year);
			request.setAttribute("carList", carList);
			url = "/cars.jsp";
		}

		if (request.getParameter("Yes") != null) {
			String code = request.getParameter("carId");
			Car m = CarsDB.selectCar(code);
			CarsDB.deleteCar(m);
			List<Car> cList = CarsDB.selectCars();
			request.setAttribute("carList", cList);
			url = "/cars.jsp";
		}

		if (request.getParameter("No") != null) {
			List<Car> cList = CarsDB.selectCars();
			request.setAttribute("carList", cList);
			url = "/cars.jsp";
		}

		if(request.getParameter("UpdateCustomer")!=null)
		{
			String Fname = request.getParameter("name");

			String Address = request.getParameter("address");
			String City = request.getParameter("city");
			String State = request.getParameter("state");
			String Zipcode = request.getParameter("zipcode");
			String Password = request.getParameter("password");

			User u = new User();

			u.setname(Fname);
			u.setAddress(Address);
			u.setcity(City);
			u.setstate(State);
			u.setzipcode(Zipcode);
			u.setpassword(Password);

			CarsDB.editCustomerProfile(u);
			request.setAttribute("cust",u);
			url="/afterEdit.jsp";
		}

		getServletContext()
		.getRequestDispatcher(url)
		.forward(request, response);

	}


	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
