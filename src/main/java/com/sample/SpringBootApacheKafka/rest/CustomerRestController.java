package com.sample.SpringBootApacheKafka.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.SpringBootApacheKafka.model.Customer;
import com.sample.SpringBootApacheKafka.service.KafkaService;

@RestController
public class CustomerRestController 
{
	@Autowired
	private KafkaService service;
	
	@PostMapping("/addCus")
	public String addCustoKafka(@RequestBody Customer cus)
	{
		System.out.println(cus);
		String status= service.addMsg(cus);
		System.out.println(status);
		return status;
		
	}
	
	@PostMapping("/addManyCus")
	public String addManyCustoKafka(@RequestBody List<Customer> cus)
	{
		return service.add(cus);
		
	}

}
