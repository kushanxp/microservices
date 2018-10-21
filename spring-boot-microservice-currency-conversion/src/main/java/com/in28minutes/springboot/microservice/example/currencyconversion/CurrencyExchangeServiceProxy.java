/**
 * 
 */
package com.in28minutes.springboot.microservice.example.currencyconversion;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author KJAYATHILAKE
 *
 */

@FeignClient(name="forex-service", url="localhost:8000")
@RibbonClient(name="forex-service")
public interface CurrencyExchangeServiceProxy {
	@GetMapping("currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable String from,
			@PathVariable String to);

}
