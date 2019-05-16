package com.example.demo;

import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

	private final RabbitTemplate rabbitTemplate;
	private final Receiver receiver;
	
	
	/**
	 * @param rabbitTemplate
	 * @param receiver
	 */
	public Runner(RabbitTemplate rabbitTemplate, Receiver receiver) {
		super();
		this.rabbitTemplate = rabbitTemplate;
		this.receiver = receiver;
	}


	@Override
	public void run(String... args) throws Exception {
		System.out.println("Sending messages....");
		rabbitTemplate.convertAndSend(SpringBootMicroserviceTestApplication.topicExchangeName, "foo.bar.baz", "Hello From RabbitMQ!!!");
		receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
	}
	

}
