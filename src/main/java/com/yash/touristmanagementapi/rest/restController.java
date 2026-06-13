package com.yash.touristmanagementapi.rest;

import com.yash.touristmanagementapi.model.Tourist;
import com.yash.touristmanagementapi.service.ITouristService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(
        name="Rest Controller",
        description = "This is responsible for all the interaction betwwen the client and the application"
)
@CrossOrigin
public class restController {

    private ITouristService service;

    @Autowired                                          //Setter Injection
    public void setService(ITouristService service) {
        this.service = service;
    }

    @PostMapping("/register")
    @Operation(
            summary = "saving the tourist",
            description = "This operation is responsible for the registering or saving all the tourist json data into the DB"
    )
    public ResponseEntity<String> register(@RequestBody Tourist tourist) {
        String response=service.registerTourist(tourist);
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    @GetMapping("/getTourist/{id}")
    @Operation(
            summary = "fetching the tourist info by id",
            description = "This operation is responsible for the fetching all the tourist json data based upon the provided id"
    )
    public ResponseEntity<Tourist> getTourist(@PathVariable Integer id) {
        Tourist tourist=service.fetchTouristById(id);
        return new ResponseEntity<Tourist>(tourist,HttpStatus.OK);
    }

    @GetMapping("/getAllTourist")
    @Operation(
            summary = "fetching all the tourist info",
            description = "This operation is responsible for the fetching all the tourist json data"
    )
    public ResponseEntity<List> getAllTourist() {
        List<Tourist> list=service.fatchAllTouristInfo();
        return new ResponseEntity<List>(list,HttpStatus.OK);
    }

    @PutMapping("/updateTourist")
    @Operation(
            summary = "updating the tourist info based upon tourist info",
            description = "This operation is responsible for the updating all the tourist json data based upon the provided tourist info"
    )
    public ResponseEntity<String> updateTourist(@RequestBody Tourist tourist) {
        String response=service.updateTouristInfo(tourist);
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    @PatchMapping("/updateTourist/{id}/{budget}")
    @Operation(
            summary = "updating the tourist budget based upon id",
            description = "This operation is responsible for the updating the tourist budget based upon the provided id"
    )
    public ResponseEntity<String> updateTourist(@PathVariable Integer id,
                                                @PathVariable Double budget) {
        String response=service.updateTouristBudget(id,budget);
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    @DeleteMapping("/deleteTourist/{id}")
    @Operation(
            summary = "deleting the tourist info based upon id",
            description = "This operation is responsible for the deleting the tourist json data based upon the provided id"
    )
    public ResponseEntity<String> updateTourist(@PathVariable Integer id) {
        String response=service.deleteTouristInfoById(id);
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }
}
