package com.letsstartcoding.angularjsdemo.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.letsstartcoding.angularjsdemo.dao.FetchData;
import com.letsstartcoding.angularjsdemo.model.Emp;

@WebServlet("/GetAllEmployees")
public class GetAllEmployees extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException 
    {
    	System.out.println("inside out");
    	 ArrayList<Emp> EmpArrayList=new ArrayList<Emp>();
 	    
    	 FetchData fetchData=new FetchData();
    	 
 	    EmpArrayList=fetchData.getAllRows();
 	    
 	    
 	    Gson gsonObj=new Gson();
 	    
 	    JsonElement jsonElm = gsonObj.toJsonTree(EmpArrayList,new TypeToken<java.util.List<Emp>>(){}.getType());
 	    
 	    JsonArray jsonArray=jsonElm.getAsJsonArray();
 	    
 	    System.out.println("jsonArray size is"+jsonArray.toString());
 	    
 	    response.setCharacterEncoding("UTF-8");
 	    
 	    response.getWriter().print(jsonArray);
    }
    

}
