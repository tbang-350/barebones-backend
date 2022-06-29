package com.basic.barebones.repository;

import com.basic.barebones.entity.Metadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MetadataRepository extends JpaRepository<Metadata, Long> {

    @Query(value = "select count(metadata_id) from metadata",nativeQuery = true)
    public int countMetadata();
}
