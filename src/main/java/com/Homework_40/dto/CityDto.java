package com.Homework_40.dto;

import com.Homework_40.domain.Country;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
public class CityDto {

    private Long id;

    private String name;

    private String countryName;
}
