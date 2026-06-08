package com.yash.touristmanagementapi.repo;

import com.yash.touristmanagementapi.model.Tourist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITouristRepo extends CrudRepository<Tourist,Integer> {
}
