package com.basic.barebones.controller;

import com.basic.barebones.dto.MetadataDto;
import com.basic.barebones.entity.Metadata;
import com.basic.barebones.repository.MetadataRepository;
import com.basic.barebones.service.MetadataService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@RestController("http://localhost:4200")
@CrossOrigin()
public class MetadataController {

    @Autowired
    private final MetadataRepository metadataRepository;

    @Autowired
    private final MetadataService metadataService;

    private ModelMapper mapper;

    @PostMapping("/addMetadata")
    public Metadata addMetadata(@RequestBody MetadataDto metadataDto){
        Metadata metadata = mapper.map(metadataDto,Metadata.class);
        metadata.setRegisterDate(LocalDate.now());
        return metadataRepository.save(metadata);
    }

    @GetMapping("/getMetadata")
    public List<Metadata> getAllMetadata(){
        return metadataRepository.findAll();
    }
}
