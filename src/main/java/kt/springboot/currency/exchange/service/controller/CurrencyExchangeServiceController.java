package kt.springboot.currency.exchange.service.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.*;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import kt.springboot.currency.exchange.service.bean.ExchangeValue;

@RestController
public class CurrencyExchangeServiceController {
	@Autowired
	Environment environment;
	@GetMapping("/currency-exchnage/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from,@PathVariable String to) {
		ExchangeValue exchangeValue = new ExchangeValue(100L,from,to,BigDecimal.valueOf(65));
		environment.getProperty("local.server.port");
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return exchangeValue;
		
	}

}