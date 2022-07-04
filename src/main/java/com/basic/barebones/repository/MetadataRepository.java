package com.basic.barebones.repository;

import com.basic.barebones.entity.Metadata;
import com.basic.barebones.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MetadataRepository extends JpaRepository<Metadata, Long> {

    @Query(value = "select count(metadata_id) from metadata",nativeQuery = true)
    public int countMetadata();

    @Query(value = "select * from metadata",nativeQuery = true)
    List<Metadata> getMetadata();
}
