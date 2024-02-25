package com.synectiks.asset.repository;

import com.synectiks.asset.domain.Cloud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data SQL repository for the Cloud entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CloudRepository extends JpaRepository<Cloud, Long> {
    List<Cloud> findByElementType(String elementType);
    List<Cloud> findByName(String name);
    List<Cloud> findByStatus(String status);
    List<Cloud> findByElementTypeAndName(String elementType, String name);
    List<Cloud> findByElementTypeAndNameAndStatus(String elementType, String name, String status);
}
