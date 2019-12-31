package kt.springboot.currency.exchange.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import kt.springboot.currency.exchange.service.bean.ExchangeValue;

public interface ExchangeValueRepo extends JpaRepository<ExchangeValue, Long> {
	ExchangeValue findByFromAndTo(String from,String to);

}
