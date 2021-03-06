package kt.springboot.currency.exchange.service.controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.*;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import kt.springboot.currency.exchange.service.bean.ExchangeValue;
import kt.springboot.currency.exchange.service.repo.ExchangeValueRepo;

@RestController
public class CurrencyExchangeServiceController {
	private Logger logger =LoggerFactory.getLogger(this.getClass());
	@Autowired
	Environment environment;
	@Autowired
	ExchangeValueRepo exchangeValueRepo;
	@GetMapping("/currency-exchnage/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from,@PathVariable String to) {
		logger.info("{}-------------------> Inside CurrencyExchangeServiceController  retrieveExchangeValue");
		
		ExchangeValue exchangeValue =exchangeValueRepo.findByFromAndTo(from, to);
		environment.getProperty("local.server.port");
		exchangeValue.setPort(Integer.valueOf(environment.getProperty("local.server.port")));
	    return exchangeValue;
		
	}

}
