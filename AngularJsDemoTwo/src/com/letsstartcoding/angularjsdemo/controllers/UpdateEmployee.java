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

@WebServlet("/UpdateEmployee")
public class UpdateEmployee extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException 
    {
    	
    	System.out.println("inside update person method");
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
    	    } catch (JsonParseException e) { 
    	    	System.out.println("inside json parse exception");
    	    	e.printStackTrace(); 
    	    	}
    	 
    	    
    	    
    	    String name=joUser.get("name").toString();
    	    name=name.substring(1, name.length()-1);
    	    System.out.println("name is"+name);
    	    
    	    String id=joUser.get("id").toString();
    	  //  id= id.substring(1,id.length()-1);
    	    
    	  long idValue=new Long(id.trim()).intValue();
    	    System.out.println("id is"+id);
    	    
    	    String designation=joUser.get("designation").toString();
    	    designation=designation.substring(1, designation.length()-1);
    	    System.out.println("designation is"+designation);
    	    
    	    String salary=joUser.get("salary").toString();
    	    salary=salary.substring(1,salary.length()-1);
    	    int salaryValue=new Integer(salary).intValue();
    	 
    	    
    	    obj.updateRecord(idValue,name,designation,salaryValue);
    	    
    	    
    	    
    	 
    }
    

}