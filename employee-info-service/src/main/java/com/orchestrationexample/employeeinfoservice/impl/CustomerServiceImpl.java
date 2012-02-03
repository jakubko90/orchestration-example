package com.orchestrationexample.employeeinfoservice.impl;

import java.util.HashMap;
import java.util.Map;

import javax.jws.WebService;

import com.orchestrationexample.employeeinfoservice.Employee;
import com.orchestrationexample.employeeinfoservice.EmployeeInfoService;
import com.orchestrationexample.employeeinfoservice.NoSuchEmployeeException;

@WebService(endpointInterface = "com.orchestrationexample.employeeinfoservice.EmployeeInfoService")
public class CustomerServiceImpl implements EmployeeInfoService
{
	private Map<String,Employee> customers;
	
	public CustomerServiceImpl()
	{
		customers = new HashMap<String,Employee>();

		Employee c = new Employee();
		c.setId("1");
		c.setName("Faculty of Mathematics, Physics and Informatics, Comenius University in Bratislava");
		c.setType("CORP");
		c.setLevel("GOLD");
		c.setAddress("Mlynská dolina", "84248", "Bratislava", "Slovak Republic");
		c.setPhone("+421-2-1111-2222");
		c.setMail("info@fmph.uniba.sk");
		c.setAccount("a-0001");
		
		customers.put(c.getId(), c);
	}
	
	@Override
	public Employee getInformation(String id) throws NoSuchEmployeeException
	{
		System.out.println("getInformation called for a customer with id = " + id);
		Employee c = customers.get(id);
		
		if (c == null)
			throw new NoSuchEmployeeException(id);
		else
			return c;
	}
}
