package com.SpringMVC.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.SpringMVC.Dao.CustomerDao;
import com.SpringMVC.Entity.Customer;
import com.SpringMVC.Service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController
{
	//Inject Customer Dao 
	@Autowired
	CustomerService customerService;

	@GetMapping("/list")
	public String listCustomers(Model model)
	{
		
		//Get Customer from Dao
		List<Customer> customer=customerService.getCustomers();
		
		//Add Customers in model
		model.addAttribute("Customer",customer);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormAdd")
	public String showFormAdd(Model model) {
		
		Customer customer=new Customer();
		
		model.addAttribute("customer",customer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer)
	{
		//SAve Customer 
		customerService.saveCustomer(customer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormUpdate")
	public String showFormUpdate(@RequestParam("customerID") int id,Model model)
	{
		Customer customer=customerService.getCustomer(id);
		
		model.addAttribute(customer);
		
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("customerID") int id)
	{
		
		customerService.deleteCustomer(id);
		
		return "redirect:/customer/list";

	}

}
