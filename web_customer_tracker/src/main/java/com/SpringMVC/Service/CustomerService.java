package com.SpringMVC.Service;

import java.util.List;

import com.SpringMVC.Entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);


}
