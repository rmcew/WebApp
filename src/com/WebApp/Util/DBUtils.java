package com.WebApp.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
 
/*
import org.o7planning.simplewebapp.beans.Product;
import org.o7planning.simplewebapp.beans.UserAccount;
*/ 
import com.WebApp.Beans.*;

public class DBUtils {

    public static UserAccount findUser(Connection conn, //
            String userName, String password) throws SQLException {
 
        String sql = "Select a.User_Name, a.Password, a.Gender from User_Account a " //
                + " where a.User_Name = ? and a.password= ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
        pstm.setString(2, password);
        ResultSet rs = pstm.executeQuery();
 
        if (rs.next()) {
            UserAccount user = new UserAccount();
            user.setUserName(userName);
            user.setPassword(password);
            return user;
        }
        return null;
    }
 
    public static UserAccount findUser(Connection conn, String userName) throws SQLException {
 
        String sql = "Select a.User_Name, a.Password, a.Gender from User_Account a "//
                + " where a.User_Name = ? ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
 
        ResultSet rs = pstm.executeQuery();
 
        if (rs.next()) {
            String password = rs.getString("Password");
            UserAccount user = new UserAccount();
            user.setUserName(userName);
            user.setPassword(password);
            return user;
        }
        return null;
    }
 /*
    public static List<Product> queryProduct(Connection conn) throws SQLException {
        String sql = "Select a.Code, a.Name, a.Price from Product a ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        ResultSet rs = pstm.executeQuery();
        List<Product> list = new ArrayList<Product>();
        while (rs.next()) {
            String code = rs.getString("Code");
            String name = rs.getString("Name");
            float price = rs.getFloat("Price");
            Product product = new Product();
            product.setCode(code);
            product.setName(name);
            product.setPrice(price);
            list.add(product);
        }
        return list;
    }
*/ 
    public static List<Quote> getQuotes(Connection conn) throws SQLException {
        String sql = "SELECT * FROM fuelQuote ORDER BY requestDate DESC";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        ResultSet rs = pstm.executeQuery();
        List<Quote> list = new ArrayList<Quote>();
        while (rs.next()) {
            int clientId = rs.getInt("clientId");
            String deliveryAddress = rs.getString("deliveryAddress");
            String deliveryCity = rs.getString("deliveryCity");
            String deliveryContactEmail = rs.getString("deliveryContactEmail");
            String deliveryContactName = rs.getString("deliveryContactName");
            String deliveryContactPhone = rs.getString("deliveryContactPhone");
            Date deliveryDate = rs.getDate("deliveryDate");
            String deliveryState = rs.getString("deliveryState");
            String deliveryZip = rs.getString("deliveryZipCode");
            double gallonsRequested = rs.getDouble("gallonsRequested");
            Date requestDate = rs.getDate("requestDate");
            double suggestedPrice = rs.getDouble("suggestedPrice");
            double totalAmountDue = rs.getDouble("totalAmountDue");
            
            Quote quote = new Quote();

            quote.setClientId(clientId);
            quote.setDeliveryAddress(deliveryAddress);
            quote.setDeliveryCity(deliveryCity);
            quote.setDeliveryContactEmail(deliveryContactEmail);
            quote.setDeliveryContactPhone(deliveryContactPhone);
            quote.setDeliveryContactName(deliveryContactName);
            quote.setDeliveryDate(deliveryDate);
            quote.setDeliveryState(deliveryState);
            quote.setDeliveryZip(deliveryZip);
            quote.setGallonsRequested(gallonsRequested);
            quote.setRequestDate(requestDate);
            quote.setSuggestedPrice(suggestedPrice);
            quote.setTotalAmountDue(totalAmountDue);
            
            list.add(quote);
        }
        return list;
    }    
    
    public static List<ClientInformation> getClientInfo(Connection conn) throws SQLException {
        String sql = "SELECT * FROM clientInformation WHERE clientId='1'";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        ResultSet rs = pstm.executeQuery();
        List<ClientInformation> list = new ArrayList<ClientInformation>();
        while (rs.next()) {
            int clientId = rs.getInt("clientId");
            String name = rs.getString("fullName");
            String address = rs.getString("address");
            String city = rs.getString("city");
            String state = rs.getString("state");
            String zip = rs.getString("zipCode");
            String phone = rs.getString("phone");
            String email = rs.getString("email");            
                        
            ClientInformation client = new ClientInformation();
            address = address + ", " + city + ", " + state + " " + zip;
            
            client.setClientId(clientId);
            client.setName(name);
            client.setAddress(address);
            client.setPhone(phone);
            client.setEmail(email);
                      
            list.add(client);
        }
        return list;
    }       
/*
    public static Product findProduct(Connection conn, String code) throws SQLException {
        String sql = "Select a.Code, a.Name, a.Price from Product a where a.Code=?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, code);
 
        ResultSet rs = pstm.executeQuery();
 
        while (rs.next()) {
            String name = rs.getString("Name");
            float price = rs.getFloat("Price");
            Product product = new Product(code, name, price);
            return product;
        }
        return null;
    }

    public static void updateProduct(Connection conn, Product product) throws SQLException {
        String sql = "Update Product set Name =?, Price=? where Code=? ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, product.getName());
        pstm.setFloat(2, product.getPrice());
        pstm.setString(3, product.getCode());
        pstm.executeUpdate();
    }
*/
    
    public static void insertQuote(Connection conn, Quote quote) throws SQLException {
        String sql = "Insert into fuelQuote"
        		+ "(clientId, gallonsRequested, requestDate, deliveryDate, deliveryAddress, deliveryCity, deliveryState, deliveryZipCode, deliveryContactName, deliveryContactPhone, deliveryContactEmail, suggestedPrice, totalAmountDue) "
        		+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setInt(1, quote.getClientId());
        pstm.setDouble(2, quote.getGallonsRequested());
        pstm.setDate(3, (java.sql.Date) quote.getRequestDate());
        pstm.setDate(4, (java.sql.Date) quote.getDeliveryDate());
        pstm.setString(5, quote.getDeliveryAddress());
        pstm.setString(6, quote.getDeliveryCity());
        pstm.setString(7, quote.getDeliveryState());
        pstm.setString(8, quote.getDeliveryZip());
        pstm.setString(9, quote.getDeliveryContactName());
        pstm.setString(10, quote.getDeliveryContactPhone());
        pstm.setString(11, quote.getDeliveryContactEmail());
        pstm.setDouble(12, quote.getSuggestedPrice());
        pstm.setDouble(13, quote.getTotalAmountDue());
 
        pstm.executeUpdate();
    }

    public static void deleteProduct(Connection conn, String code) throws SQLException {
        String sql = "Delete From Product where Code= ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, code);
 
        pstm.executeUpdate();
    }
}
