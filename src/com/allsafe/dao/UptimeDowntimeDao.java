package com.allsafe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.allsafe.model.WebServiceRequests;

import java.io.UnsupportedEncodingException;


public class UptimeDowntimeDao {
	

	public int setConnectionStatus(WebServiceRequests requests) throws ClassNotFoundException {
			
		    ConnectionFactory connectionFactory=new ConnectionFactory();
		    Connection connection=connectionFactory.getConnection();
			String INSERT_WEB_SERVICE_REQUESTS_SQL="INSERT INTO WEB_SERVICE_REQUESTS"+
			"(REQUEST_STATUS,REQUEST_TIME) VALUES"+
					"(?,?)";
			int result=0;
			try {
				PreparedStatement preparedStatement=connection.prepareStatement(INSERT_WEB_SERVICE_REQUESTS_SQL);
				preparedStatement.setInt(1, requests.getRequestStatus());
				preparedStatement.setString(2, requests.getTime());
				System.out.println(preparedStatement);
			    result=preparedStatement.executeUpdate();   
				preparedStatement.close();
			    
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				connection.close();
				System.out.println("connection closed");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
	    }
 
	        public WebServiceRequests getRequest(int requestId){
	        	
	        	ConnectionFactory connectionFactory=new ConnectionFactory();
	    	    Connection connection=connectionFactory.getConnection();
	    	    WebServiceRequests req=null;           
	            String FETCH_REQUEST ="select * from WEB_SERVICE_REQUESTS where REQUEST_ID=?";
	            try{
	                
	                PreparedStatement preparedStatement=connection.prepareStatement(FETCH_REQUEST); 
	                preparedStatement.setInt(1, requestId);	                
	                ResultSet rs = preparedStatement.executeQuery();
	                
	                if(rs.next()){
	                	req = new WebServiceRequests();
	                	req.setRequestId(rs.getInt("REQUEST_ID"));
	                	req.setRequestStatus(rs.getInt("REQUEST_STATUS"));
	                	req.setTime("REQUEST_TIME");
	                  
	                    
	                }
	                
	            }catch(Exception e){
	                e.printStackTrace();
	            }
	            try {
	    			connection.close();
	    			System.out.println("connection closed");
	    		} catch (SQLException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
	            return req;
	        }
	        
	


}
