/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cars.servlet;

import car.util.MailUtilGmail;
import cars.data.CarsDB;
import cars.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SPANDANA
 */
@WebServlet(name = "EmailServlet", urlPatterns = {"/EmailServlet"})
public class EmailServlet extends HttpServlet {

	private String host;
	private String port;
	private String user;
	private String pass;

	public void init() {
		// reads SMTP server setting from web.xml file
		ServletContext context = getServletContext();
		host = context.getInitParameter("host");
		port = context.getInitParameter("port");
		user = context.getInitParameter("user");
		pass = context.getInitParameter("pass");
	}
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
		try {
			/* TODO output your page here. You may use following sample code. */
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet EmailServlet</title>");            
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Servlet EmailServlet at " + request.getContextPath() + "</h1>");
			out.println("</body>");
			out.println("</html>");
		} finally {
			out.close();
		}
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
		processRequest(request, response);
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
		String url=null;   

		String email = request.getParameter("email");
		User u=CarsDB.selectUser(email);

		// store data in User object
		// send email to user
		String to = email;
		String from = user;
		String subject = "Welcome to car rental store";
		String body = "Dear "+u.getname()+"\n"
				+ "Thanks for visting car rental store. Have a nice day";
		boolean isBodyHTML = false;

		try {

			MailUtilGmail.sendMail(host, port, user, pass, to, from, subject, body, isBodyHTML);
		} catch (MessagingException e) {
			String errorMessage
			= "ERROR: Unable to send email. "
					+ "Check Tomcat logs for details.<br>"
					+ "NOTE: You may need to configure your system "
					+ "as described in chapter 14.<br>"
					+ "ERROR MESSAGE: " + e.getMessage();
			request.setAttribute("errorMessage", errorMessage);
			this.log(
					"Unable to send email. \n"
							+ "Here is the email you tried to send: \n"
							+ "=====================================\n"
							+ "TO: " + email + "\n"
							+ "FROM: " + from + "\n"
							+ "SUBJECT: " + subject + "\n"
							+ "\n"
							+ body + "\n\n");
		} 
		request.setAttribute("uemail",email);

		url = "/main.jsp";

		//}

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
