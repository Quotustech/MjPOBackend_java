package com.quotus.mjunction.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class MjunctionController {
    
    @GetMapping("/tracking/{track_id}")
    public String getTrackingStatus(@PathVariable("track_id") String trackId) {
        // URL of your Node.js endpoint with the trackId parameter
        String nodeJsUrl = "http://localhost:7010/api/v1/track/{track_id}";

        RestTemplate restTemplate = new RestTemplate();

 
        String finalUrl = nodeJsUrl.replace("{track_id}", trackId);

        // Make a GET request to Node.js server
        String response = restTemplate.getForObject(finalUrl, String.class);
      System.out.println(response);
       
        return response;
    }
}
