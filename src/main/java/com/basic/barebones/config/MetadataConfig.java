//package com.basic.barebones.config;
//
//import com.basic.barebones.entity.Metadata;
//import com.basic.barebones.repository.MetadataRepository;
//import lombok.Data;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.LocalDate;
//import java.util.List;
//
//@Data
//@Configuration
//public class MetadataConfig {
//
//    @Bean
//    CommandLineRunner commandLineRunner(MetadataRepository metadataRepository) {
//        return args -> {
//            List<Metadata> metadata = metadataRepository.getMetadata();
//
//            if (metadata.isEmpty()) {
//
//                Metadata metadata1 = new Metadata(
//                        "test1",
//                        -5.999518554627731,
//                        39.294092875230476,
//                        "test descr",
//                        LocalDate.now()
//                        );
//
//                Metadata metadata2 = new Metadata(
//                        "test2",
//                        -6.076880092147241,
//                        39.38501361000966,
//                        "test descr2",
//                        LocalDate.now()
//                );
//
//                Metadata metadata3 = new Metadata(
//                        "test3",
//                        -6.070594880346951,
//                        39.24061009006625,
//                        "test descr3",
//                        LocalDate.now()
//                );
//
//                Metadata metadata4 = new Metadata(
//                        "test4",
//                        -6.181357913157675,
//                        39.22211205405036,
//                        "test descr4",
//                        LocalDate.now()
//                );
//
//                metadataRepository.saveAll(List.of(metadata1,metadata2,metadata3,metadata4));
//            }
//
//        };
//    }
//}
//
////-5.999518554627731, 39.294092875230476
////-6.076880092147241, 39.38501361000966
////-6.070594880346951, 39.24061009006625
////-6.181357913157675, 39.22211205405036