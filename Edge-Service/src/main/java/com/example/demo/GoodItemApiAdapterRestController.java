package com.example.demo;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodItemApiAdapterRestController {
	
	private final ItemClient itemClient;

	public GoodItemApiAdapterRestController(ItemClient itemClient) {
		this.itemClient = itemClient;
	}
	
	private boolean isGreat(Item item) {
		return !item.getName().equals("Nike") &&
                !item.getName().equals("Adidas") &&
                !item.getName().equals("Reebok");
	}
	
	@GetMapping("/top-brands")
	public Collection<Item> goodItems() {
		System.out.println("Called the method");
		return itemClient.readItems().getContent().stream().filter(this::isGreat).collect(Collectors.toList());
		
	}
	
	
	

}
