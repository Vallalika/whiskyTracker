package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/whiskies")
    public ResponseEntity<List<Whisky>> getAllWhiskies(){
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies/year")
    public ResponseEntity<List<Whisky>> getWhiskiesByYear(
            @RequestParam (name="named") int year)
    {
        return new ResponseEntity<>(whiskyRepository.findByYear(year),HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies/distillery/{id}/age")
    public ResponseEntity<List<Whisky>> getWhiskiesBySpecificDistilleryBySpecificYear(
            @PathVariable Long id,
            @RequestParam (name="named") int age)
    {
        return new ResponseEntity<>(whiskyRepository.findByDistillery_IdAndAge(id,age),HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies/region")
    public ResponseEntity<List<Whisky>> getWhiskiesByRegion(
            @RequestParam (name="named") String region)
    {
        return new ResponseEntity<>(whiskyRepository.findByDistillery_Region(region), HttpStatus.OK);
    }
}
