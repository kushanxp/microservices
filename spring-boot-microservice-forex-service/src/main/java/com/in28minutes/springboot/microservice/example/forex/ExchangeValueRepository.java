/**
 * 
 */
package com.in28minutes.springboot.microservice.example.forex;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author KJAYATHILAKE
 *
 */
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
	public ExchangeValue findByFromAndTo(String from, String to);
}
