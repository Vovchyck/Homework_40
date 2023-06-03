package com.Homework_40.service;

import com.Homework_40.domain.City;
import com.Homework_40.domain.Country;
import com.Homework_40.dto.CountryDto;
import com.Homework_40.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CountryService {
    private final CountryRepository countryRepository;

    public void save(Country country) {
        countryRepository.save(country);
    }

    public List<CountryDto> findAll() {
        return countryRepository.findAll()
                .stream()
                .map(CountryService::buildCountryDto)
                .collect(Collectors.toList());
    }
    public static CountryDto buildCountryDto(Country country) {
        return CountryDto.builder()
                .id(country.getId())
                .name(country.getName())
                .cities(country.getCities().stream()
                        .map(City::getName)
                        .collect(Collectors.toList()))
                .build();
    }
}
