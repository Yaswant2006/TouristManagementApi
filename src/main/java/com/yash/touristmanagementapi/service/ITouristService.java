package com.yash.touristmanagementapi.service;

import com.yash.touristmanagementapi.model.Tourist;

import java.util.List;

public interface ITouristService {
    String registerTourist(Tourist toruist);
    Tourist fetchTouristById(Integer id);
    List<Tourist> fatchAllTouristInfo();
    String updateTouristInfo(Tourist tourist);
    String updateTouristBudget(Integer id,Double budget);
    String deleteTouristInfoById(Integer id);
}
