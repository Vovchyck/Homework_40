package com.Homework_40.service;

import com.Homework_40.domain.City;
import com.Homework_40.dto.CityDto;
import com.Homework_40.repository.CityRepository;
import com.Homework_40.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;

    public List<CityDto> findAll(){
        return cityRepository.findAll().stream()
                .map(CityService::buildCityDto)
                .collect(Collectors.toList());
    }

    private static CityDto buildCityDto(City city) {
        var countryName = "COUNTRY IS NOT SPECIFIED";
        if (city.getCountry() != null) {
            countryName = city.getCountry().getName();
        }
        return CityDto.builder()
                .id(city.getId())
                .name(city.getName())
                .countryName(countryName)
                .build();
    }

    public Optional<City> findById(Long id){
        return cityRepository.findById(id);
    }

    public Optional<City> findByName(String name) {
        return cityRepository.findCityByName(name);
    }

    public void save(City student) {
        cityRepository.save(student);
    }

    public void addCountry(Long cityId, Long countryId) {
        var country = countryRepository.findById(countryId).get();
        var city = cityRepository.findById(cityId).get();
        city.setCountry(country);
        cityRepository.save(city);
    }
}
