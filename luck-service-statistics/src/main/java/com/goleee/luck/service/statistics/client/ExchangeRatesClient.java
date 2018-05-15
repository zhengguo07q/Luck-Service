package com.goleee.luck.service.statistics.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.goleee.luck.service.statistics.domain.Currency;
import com.goleee.luck.service.statistics.domain.ExchangeRatesContainer;

@FeignClient(url = "${rates.url}", name = "rates-client")
public interface ExchangeRatesClient
{

	@RequestMapping(method = RequestMethod.GET, value = "/latest")
	ExchangeRatesContainer getRates(@RequestParam("base") Currency base);

}
