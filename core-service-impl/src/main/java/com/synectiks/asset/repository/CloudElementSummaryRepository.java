package com.synectiks.asset.repository;

import com.synectiks.asset.domain.CloudElementSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data SQL repository for the CloudElementSummary entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CloudElementSummaryRepository extends JpaRepository<CloudElementSummary, Long> {

    String CLOUD_ELEMENT_SUMMARY_QUERY ="select * from cloud_element_summary ces where ces.landingzone_id in ( " +
            "select l.id from landingzone l\n" +
            "where l.landing_zone = :landingZone and upper(l.cloud) = upper(:cloud)\n" +
            "and l.department_id = (select d.id from department d where upper(d.\"name\") = upper(:department)\n" +
            " and d.organization_id = (select o.id from organization o where upper(o.\"name\") = upper(:organization) )))\n";
    @Query(value = CLOUD_ELEMENT_SUMMARY_QUERY, nativeQuery = true)
    List<CloudElementSummary> getCloudElementSummary(@Param("organization") String organization,
                                     @Param("department") String department,
                                     @Param("cloud") String cloud,
                                     @Param("landingZone") String landingZone);

}
