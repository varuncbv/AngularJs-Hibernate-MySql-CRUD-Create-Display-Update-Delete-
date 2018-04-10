package com.letsstartcoding.angularjsdemo.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.letsstartcoding.angularjsdemo.dao.FetchData;

@WebServlet("/CreateEmployee")
public class createEmployee extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

protected void doPost(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException 
{
	
	System.out.println("inside create person method");
	 StringBuffer sb = new StringBuffer();
	 
	 FetchData obj=new FetchData();
	 
	    try 
	    {
	      BufferedReader reader = request.getReader();
	      String line = null;
	      while ((line = reader.readLine()) != null)
	      {
	        sb.append(line);
	      }
	    } catch (Exception e) { e.printStackTrace(); }
	 
	    JsonParser parser = new JsonParser();
	    JsonObject joUser = null;
	    try
	    {
	      joUser = (JsonObject) parser.parse(sb.toString());
	    } catch (JsonParseException e) { e.printStackTrace(); }
	 
	    String name=joUser.get("name").toString();
	    name=name.substring(1, name.length()-1);
	    System.out.println("name is"+name);
	    
	  
	    
	    String designation=joUser.get("designation").toString();
	    designation=designation.substring(1, designation.length()-1);
	    System.out.println("designation is"+designation);
	    
	    String salary=joUser.get("salary").toString();
	   salary=salary.substring(1,salary.length()-1);
	    int salaryValue=new Integer(salary).intValue();
	    System.out.println("salary is"+salary);
	    
	    obj.insertRecord(designation, name, salaryValue);
	    
	    
	    
	 
}


}
