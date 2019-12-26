package com.SpringMVC.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.SpringMVC.Dao.CustomerDao;
import com.SpringMVC.Entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDao customerDao;

	@Transactional
	public List<Customer> getCustomers() {
		
		
		return customerDao.getCustomers();
	}

	@Transactional
	public void saveCustomer(Customer customer) {
	
		 customerDao.saveCustomer(customer);
	
	}

	@Transactional
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		return customerDao.getCustomer(id);
	}

	@Transactional
	public void deleteCustomer(int id) {

		customerDao.deleteCustomer(id);
	}

    @Transactional
    public List<Customer> searchCustomers(String theSearchName) {

        return customerDao.searchCustomers(theSearchName);
    }

	
	

}
