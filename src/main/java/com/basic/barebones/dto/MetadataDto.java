package com.basic.barebones.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MetadataDto {

    private String name;
    private Double longitude;
    private Double latitude;
    private String description;


}
