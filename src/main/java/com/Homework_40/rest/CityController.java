package com.Homework_40.rest;

import com.Homework_40.domain.City;
import com.Homework_40.dto.CityDto;
import com.Homework_40.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;

    @GetMapping("/students")
    public ResponseEntity<List<CityDto>> findAll(){
        return ResponseEntity.ok(cityService.findAll());
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<City> findById(@PathVariable Long id) {
        return cityService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/students/name/{name}")
    public ResponseEntity<City> findByName(@PathVariable String name) {
        return cityService.findByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/students/find")
    public ResponseEntity<City> findByParam(@RequestParam String name, @RequestParam int age) {
        return cityService.findByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping("/students")
    public ResponseEntity<Void> save(@RequestBody City student) {
        cityService.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/city")
    public ResponseEntity<Void> update(@RequestBody City city) {
        cityService.save(city);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PostMapping("/city/{id}/country/{countryId}")
    public ResponseEntity<Void> update(@PathVariable Long id, @PathVariable Long countryId) {
        cityService.addCountry(id, countryId);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
