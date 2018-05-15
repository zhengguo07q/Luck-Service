package com.goleee.luck.service.statistics.repository.converter;

import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.goleee.luck.service.statistics.domain.timeseries.DataPointId;
import com.mongodb.DBObject;

@Component
public class DataPointIdReaderConverter implements Converter<DBObject, DataPointId>
{

	public DataPointId convert(DBObject object)
	{

		Date date = (Date) object.get("date");
		String account = (String) object.get("account");

		return new DataPointId(account, date);
	}
}
