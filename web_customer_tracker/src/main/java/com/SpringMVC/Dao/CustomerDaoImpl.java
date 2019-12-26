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

}
