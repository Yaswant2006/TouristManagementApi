package com.yash.touristmanagementapi.rest;

import com.yash.touristmanagementapi.model.Tourist;
import com.yash.touristmanagementapi.service.ITouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class restController {

    private ITouristService service;

    @Autowired                                          //Setter Injection
    public void setService(ITouristService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Tourist tourist) {
        String response=service.registerTourist(tourist);
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    @GetMapping("/getTourist/{id}")
    public ResponseEntity<Tourist> getTourist(@PathVariable Integer id) {
        Tourist tourist=service.fetchTouristById(id);
        return new ResponseEntity<Tourist>(tourist,HttpStatus.OK);
    }

    @GetMapping("/getAllTourist")
    public ResponseEntity<List> getAllTourist() {
        List<Tourist> list=service.fatchAllTouristInfo();
        return new ResponseEntity<List>(list,HttpStatus.OK);
    }

    @PutMapping("/updateTourist")
    public ResponseEntity<String> updateTourist(@RequestBody Tourist tourist) {
        String response=service.updateTouristInfo(tourist);
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    @PatchMapping("/updateTourist/{id}/{budget}")
    public ResponseEntity<String> updateTourist(@PathVariable Integer id,
                                                @PathVariable Double budget) {
        String response=service.updateTouristBudget(id,budget);
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    @DeleteMapping("/deleteTourist/{id}")
    public ResponseEntity<String> updateTourist(@RequestBody Integer id) {
        String response=service.deleteTouristInfoById(id);
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }
}
