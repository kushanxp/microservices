package com.example.demo;

import java.util.stream.Stream;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
class Item {
	
	private String name;
	
	public Item() {
		
	}
	public Item(String name) {
		this.name = name;
	}
	
	@Id
	@GeneratedValue
	private Long id;
}

@RepositoryRestResource
interface ItemRepository extends JpaRepository<Item, Long> {}

@Component
class ItemInitializer implements CommandLineRunner {

	private final ItemRepository itemRepository;
	
	ItemInitializer (ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		Stream.of("Lining","PUMA", "Bad Boy", "Air Jordan", "Nike", "Adidas", "Reebok").forEach(item -> itemRepository.save(new Item(item)));		
		itemRepository.findAll().forEach(System.out::println);
	}
	
}


@SpringBootApplication
public class ItemCatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemCatalogApplication.class, args);
	}
}