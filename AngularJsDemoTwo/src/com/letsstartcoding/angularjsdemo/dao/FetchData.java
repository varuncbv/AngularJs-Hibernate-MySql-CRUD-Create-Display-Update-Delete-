package com.letsstartcoding.angularjsdemo.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.letsstartcoding.angularjsdemo.model.Emp;
import com.letsstartcoding.angularjsdemo.model.Emp;

public class FetchData {

	private static SessionFactory factory;
	
	
	private static void getFactory() {
		
		try {
			
			Configuration configuration= new Configuration();
			configuration.addAnnotatedClass(Emp.class);
			configuration.configure();
			
			ServiceRegistry sr= new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			
			factory=configuration.buildSessionFactory(sr);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/*method to insert a record into table*/
	   
	   public void insertRecord(String designation,String name,int Salary){
		   
		   System.out.println("INSIDE insert record");
		  
		   
		   getFactory();
		   
		      Session session = factory.openSession();
		      
		      
		      
		      Transaction tx = null;
		     
		      try{
		         tx = session.beginTransaction();
		         
		         session.save(new Emp(designation,name,Salary));
		         
		        
		        		         
		         
		         tx.commit();
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }
		     
		      
	   }
	   
	   public ArrayList<Emp> getAllRows(){
			
			getFactory();
			
			Session session=factory.openSession();
			
			Transaction tx=null;
			
			ArrayList<Emp> empArrayList=new ArrayList<Emp>();
			
			try {
				tx=session.beginTransaction();
				
				String sql="SELECT * from Emp";
				
				SQLQuery query=session.createSQLQuery(sql);
				
				query.addEntity(Emp.class);
				
				List<Emp> empDetailsList=query.list();
				
				for (Iterator iterator = 
		        		 empDetailsList.iterator(); iterator.hasNext();){
		        	 Emp empObject = (Emp) iterator.next(); 
		        	 empArrayList.add(empObject);
		         }
		         tx.commit();
			}catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }
		      return empArrayList;
			
			
			
		}
	   
	   
	   public void updateRecord(long idValue, String name, String designation, int salary) {
		   getFactory();
		   
		      Session session = factory.openSession();
		      
		      Transaction tx = null;
		     
		      try{
		         tx = session.beginTransaction();
		         String sql = "Update world.Emp set name='"+name+"',designation='"+designation+"',salary="+salary+" where id="+idValue;
		         
		         System.out.println("sql is"+sql);
		         SQLQuery query = session.createSQLQuery(sql);
		        
		         
		         query.executeUpdate();
		         
		         
		         tx.commit();
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }
	}
	   
	   public void deleteRecord(int idValue) {
			getFactory();
			   
		      Session session = factory.openSession();
		      
		      Transaction tx = null;
		     
		      try{
		         tx = session.beginTransaction();
		         String sql = "Delete from world.Emp where id="+idValue;
		         SQLQuery query = session.createSQLQuery(sql);
		        
		         
		         query.executeUpdate();
		         
		         
		         tx.commit();
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }
	 }
	
	
}
