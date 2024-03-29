package com.synectiks.asset.repository;

import com.synectiks.asset.domain.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Spring Data SQL repository for the Organization entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    String ORG_BY_ORGNAME_QUERY ="select o.* from organization o where upper(o.name) = upper(:name)";
    @Query(value = ORG_BY_ORGNAME_QUERY, nativeQuery = true)
    Organization findByName(@Param("name") String name);
}


