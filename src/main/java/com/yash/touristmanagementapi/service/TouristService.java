package com.yash.touristmanagementapi.service;

import com.yash.touristmanagementapi.exception.TouristNotFoundException;
import com.yash.touristmanagementapi.model.Tourist;
import com.yash.touristmanagementapi.repo.ITouristRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TouristService implements ITouristService{

    private ITouristRepo repo;

    @Autowired
    public void setRepo(ITouristRepo repo) {
        this.repo = repo;
    }

    @Override
    public String registerTourist(Tourist tourist) {
        if(tourist != null) {
           repo.save(tourist);
           return "Tourist with id "+tourist.getId()+" saved Succesfully";
        }
        throw new TouristNotFoundException("Tourist is not found!!");
    }

    @Override
    public Tourist fetchTouristById(Integer id) {
        Optional<Tourist> optional = repo.findById(id);
        if (optional.isPresent()) return optional.get();
        throw new TouristNotFoundException("Tourist with id "+id+" not found!!");
    }

    @Override
    public List<Tourist> fatchAllTouristInfo() {
        return (List<Tourist>) repo.findAll();
    }

    @Override
    public String updateTouristInfo(Tourist tourist) {
        Optional<Tourist> optional=repo.findById(tourist.getId());
        if (optional.isPresent()) {
            repo.save(tourist);
            return "Updated Tourist successfully with id "+tourist.getId();
        }
        throw new TouristNotFoundException("Tourist with given info not found for the updation!!!");
    }

    @Override
    public String updateTouristBudget(Integer id, Double budget) {
        Optional<Tourist> optional=repo.findById(id);
        if (optional.isPresent()) {
            Tourist t=optional.get();
            t.setBudget(budget);
            repo.save(t);
            return "Updated Tourist budget successfully with id "+t.getId();
        }
        throw new TouristNotFoundException("Tourist with given info not found for the updation!!!");
    }

    @Override
    public String deleteTouristInfoById(Integer id) {
        Optional<Tourist> optional=repo.findById(id);
        if (optional.isPresent()) {
            repo.deleteById(id);
            return "Deleted Tourist info successfully with id "+id;
        }
        throw new TouristNotFoundException("Tourist with given info not found for the deletion!!!");
    }
}
