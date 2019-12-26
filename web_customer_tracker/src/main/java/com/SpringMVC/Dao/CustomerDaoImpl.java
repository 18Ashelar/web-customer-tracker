package com.SpringMVC.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.SpringMVC.Entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	SessionFactory sessionFactory;
	
	
	public List<Customer> getCustomers() {

		Session session=sessionFactory.getCurrentSession();
		
		Query<Customer> query=session.createQuery("from Customer order by last_name",Customer.class);
		
		List<Customer> customer=query.getResultList();
		
		return customer;
	}


	public void saveCustomer(Customer customer) {

		Session session=sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(customer);
		

		
	}

	public Customer getCustomer(int id) {

		Session session=sessionFactory.getCurrentSession();
		
		Customer customer=session.get(Customer.class, id);
		
		return customer;
	}


	public void deleteCustomer(int id) {
		
		Session session=sessionFactory.getCurrentSession();

		Customer customer=session.get(Customer.class, id);

		session.delete(customer);
		
		
	}
	
	 public List<Customer> searchCustomers(String theSearchName) {

	        // get the current hibernate session
	        Session currentSession = sessionFactory.getCurrentSession();
	        
	        Query theQuery = null;
	        
	        //
	        // only search by name if theSearchName is not empty
	        //
	        if (theSearchName != null && theSearchName.trim().length() > 0) {

	            // search for firstName or lastName ... case insensitive
	            theQuery =currentSession.createQuery("from Customer where lower(first_name) like :theName or lower(last_name) like :theName", Customer.class);
	            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

	        }
	        else {
	            // theSearchName is empty ... so just get all customers
	            theQuery =currentSession.createQuery("from Customer", Customer.class);            
	        }
	        
	        // execute query and get result list
	        List<Customer> customers = theQuery.getResultList();
	                
	        // return the results        
	        return customers;
	        
	    }

}
