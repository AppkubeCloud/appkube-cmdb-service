package com.synectiks.asset.repository;

import com.synectiks.asset.domain.CloudElement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data SQL repository for the CloudElement entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CloudElementRepository extends JpaRepository<CloudElement, Long> {
    CloudElement findByInstanceId(String instanceId);

    String CLOUD_ELEMENT_QUERY ="select ce.* from cloud_element ce where ce.landingzone_id in ( " +
            " select l.id from landingzone l\n" +
            " where l.landing_zone = :landingZone and upper(l.cloud) = upper(:cloud)\n" +
            " and l.department_id = (select d.id from department d where upper(d.\"name\") = upper(:department)\n" +
            " and d.organization_id = (select o.id from organization o where upper(o.\"name\") = upper(:organization) )))\n" +
            " and upper(ce.element_type) = upper('lambda')  " +
            " and ce.arn = :arn " +
            " order by ce.id asc ";
    @Query(value = CLOUD_ELEMENT_QUERY, nativeQuery = true)
    List<CloudElement> getCloudElement(@Param("organization") String organization,
                                                     @Param("department") String department,
                                                     @Param("cloud") String cloud,
                                                     @Param("landingZone") String landingZone,
                                                     @Param("arn") String arn);


}
