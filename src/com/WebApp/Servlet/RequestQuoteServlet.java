package com.WebApp.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.WebApp.Beans.Quote;
import com.WebApp.Util.DBUtils;
import com.WebApp.Util.MyUtils;
 
@WebServlet(urlPatterns = { "/request-a-quote" })
public class RequestQuoteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public RequestQuoteServlet() {
        super();
    }
 
    // Show product creation page.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/request-a-quote.jsp");
        dispatcher.forward(request, response);
    }
 
    // When the user enters the product information, and click Submit.
    // This method will be called.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        //Get Current Date
		long time = System.currentTimeMillis();
		java.sql.Date requestDate = new java.sql.Date(time);
		String errorString = null;
        
        
        Double gallonsRequested = Double.valueOf(request.getParameter("gallonsRequested"));
        Date deliveryDate = Date.valueOf(request.getParameter("date"));
        String deliveryAddress = request.getParameter("address");
        String deliveryCity = request.getParameter("city");
        String deliveryState = request.getParameter("state");
        String deliveryZip = request.getParameter("zip");
        String deliveryContactName = request.getParameter("contactName");
        String deliveryContactPhone = request.getParameter("contactPhone");
        String deliveryContactEmail = request.getParameter("deliveryEmail");
        Double suggestedPrice = Double.valueOf(request.getParameter("suggestedPrice"));
        Double totalAmountDue = Double.valueOf(request.getParameter("amount"));
        
        
        Quote quote= new Quote();
		int clientId = 1;
		quote.setClientId(clientId);
		quote.setGallonsRequested(gallonsRequested);
		quote.setDeliveryDate(deliveryDate);
		quote.setRequestDate(requestDate);
		quote.setDeliveryAddress(deliveryAddress);
		quote.setDeliveryCity(deliveryCity);
		quote.setDeliveryState(deliveryState);
		quote.setDeliveryZip(deliveryZip);
		quote.setDeliveryContactName(deliveryContactName);
		quote.setDeliveryContactPhone(deliveryContactPhone);
		quote.setDeliveryContactEmail(deliveryContactEmail);
		quote.setSuggestedPrice(suggestedPrice);
		quote.setTotalAmountDue(totalAmountDue);	        
        
        try {				
			DBUtils.insertQuote(conn, quote);			
		}
		catch(Exception e) {
			System.out.println(e);
			errorString = e.getMessage();
		}


       
        // Store infomation to request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("quote", quote);
 
        // If error, forward to Edit page.
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/request-a-quote.jsp");
            dispatcher.forward(request, response);
        }
        // If everything nice.
        // Redirect to the product listing page.
        else {
            response.sendRedirect(request.getContextPath() + "/quote-history");
        }
    }
 
}