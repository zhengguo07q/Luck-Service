package com.goleee.luck.service.notification.repository.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.goleee.luck.service.notification.domain.Frequency;

@Component
public class FrequencyReaderConverter implements Converter<Integer, Frequency>
{

	@Override
	public Frequency convert(Integer days)
	{
		return Frequency.withDays(days);
	}
}
