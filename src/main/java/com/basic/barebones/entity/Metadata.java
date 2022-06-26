package com.basic.barebones.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "metadata")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Metadata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long metadata_id;
    private String name;
    private Double latitude;
    private Double longitude;
    private String description;
    private LocalDate registerDate;
}
