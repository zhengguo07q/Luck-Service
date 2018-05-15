package com.goleee.luck.service.statistics.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.goleee.luck.service.statistics.domain.timeseries.DataPoint;
import com.goleee.luck.service.statistics.domain.timeseries.DataPointId;

@Repository
public interface DataPointRepository extends CrudRepository<DataPoint, DataPointId>
{

	List<DataPoint> findByIdAccount(String account);

}
