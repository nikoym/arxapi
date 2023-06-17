package com.example.arx.controller;

import com.example.arx.model.AnonymizedDataRequest;
import com.example.arx.services.AnonymizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/api/anonymize")
public class ArxController {

    private final AnonymizeService anonymizeService;

    @Autowired
    public ArxController(AnonymizeService anonymizeService) {
        this.anonymizeService = anonymizeService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<String[]>>  anonymizeData( @RequestBody AnonymizedDataRequest request) throws IOException {
        try {
            List<String[]> anonymizedData = anonymizeService.anonymize(request);
            return ResponseEntity.ok(anonymizedData);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity("An unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

