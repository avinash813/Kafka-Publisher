package com.sample.SpringBootApacheKafka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.sample.SpringBootApacheKafka.model.Customer;
import com.sample.SpringBootApacheKafka.util.AppConstants;

@Service
public class KafkaService 
{
	@Autowired
	private KafkaTemplate<String, Customer> kafkaTemplate;
	
	public String addMsg(Customer cus) {

		System.out.println(cus + " is in service");
		kafkaTemplate.send(AppConstants.TOPIC_NAME, cus);
        System.out.println("Able to send data");
		return "Msg Published To Kafka Topic";
	}
	
	public String add(List<Customer> customers) {

		if (!customers.isEmpty()) {
			for (Customer cus : customers) {
				kafkaTemplate.send(AppConstants.TOPIC_NAME, cus);
				System.out.println("************Msg published to Kafka topic***************");
			}
		}
		return "Customer Records Added To Kafka Successfully";
	}
	
}
