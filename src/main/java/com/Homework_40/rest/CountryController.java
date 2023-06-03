package com.Homework_40.rest;

import com.Homework_40.domain.Country;
import com.Homework_40.dto.CountryDto;
import com.Homework_40.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CountryController {
    private final CountryService countryService;

    @PostMapping("/country")
    public void save(@RequestBody Country country) {
        countryService.save(country);
    }

    @GetMapping("/country")
    public List<CountryDto> findAll() {
        return countryService.findAll();
    }
}
