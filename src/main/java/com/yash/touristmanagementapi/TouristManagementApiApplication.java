package com.yash.touristmanagementapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info=@Info(
                title = "TouristManagementAPI",
                version = "v1.0",
                description = "This Application performs simple CRUD operations based upon the tourist data"
        ),
        servers=@Server(
                url="https://localhost:8080/TouristMangament",
                description = "This API is deployed in following URL"
        )
)
public class TouristManagementApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TouristManagementApiApplication.class, args);
    }

}
