package com.WebApp.Servlet;

import java.sql.Date;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.WebApp.Beans.Quote;


/**
 * Servlet implementation class clientServlet
 */
public class ClientInformationOld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientInformationOld() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			String url = "jdbc:mysql://localhost:3306/CS3320";
			String user = "root";
			String password = "admin";
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, password);
			
			Statement selectStatement = conn.createStatement();
			String selectSql = "SELECT MAX(clientId) FROM clientInformation;";
			ResultSet rs = selectStatement.executeQuery(selectSql);
			if (rs.next()){
				int clientId = rs.getInt(1) + 1;
				long time = System.currentTimeMillis();
				java.sql.Date date = new java.sql.Date(time);
				
				System.out.println(date);
			
				Quote quote = new Quote();
				quote.setClientId(clientId);		 
				quote.setGallonsRequested(Double.valueOf(request.getParameter("gallonsRequested")));
				quote.setDeliveryDate(Date.valueOf(request.getParameter("date")));
				quote.setDeliveryAddress(request.getParameter("addresss"));
				quote.setDeliveryCity(request.getParameter("city"));
				quote.setDeliveryState(request.getParameter("state"));
				quote.setDeliveryZip(request.getParameter("zip"));
				quote.setDeliveryContactName(request.getParameter("contactName"));
				quote.setDeliveryContactPhone(request.getParameter("contactPhone"));
				quote.setDeliveryContactEmail(request.getParameter("contactEmail"));
				quote.setSuggestedPrice(Double.valueOf(request.getParameter("suggestedPrice")));
				quote.setTotalAmountDue(Double.valueOf(request.getParameter("amount")));
	
			
				String insertTableSQL = "INSERT INTO fuelQuote"
						+ "(clientId, gallonsRequested, requestDate, deliveryDate, deliveryAddress, deliveryCity, deliveryState, deliveryZipCode, deliveryContactName, deliveryContactPhone, deliveryContactEmail, suggestedPrice, totalAmountDue) VALUES"
						+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement insertStatement = conn.prepareStatement(insertTableSQL);
				insertStatement.setInt(1, quote.getClientId());
				insertStatement.setDouble(2, quote.getGallonsRequested());
				insertStatement.setDate(3, date);
				insertStatement.setDate(4,  date);
				insertStatement.setString(5, quote.getDeliveryAddress());
				insertStatement.setString(6, quote.getDeliveryCity());
				insertStatement.setString(7, quote.getDeliveryState());
				insertStatement.setString(8, quote.getDeliveryZip());
				insertStatement.setString(9, quote.getDeliveryContactName());
				insertStatement.setString(10, quote.getDeliveryContactPhone());
				insertStatement.setString(11, quote.getDeliveryContactEmail());
				insertStatement.setDouble(12, quote.getSuggestedPrice());
				insertStatement.setDouble(13, quote.getTotalAmountDue());
				
				insertStatement.executeUpdate();
			
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}


		
	}

}
