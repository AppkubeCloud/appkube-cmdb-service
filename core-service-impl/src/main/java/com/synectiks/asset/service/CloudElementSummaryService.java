package com.synectiks.asset.service;

import com.synectiks.asset.domain.CloudElementSummary;
import com.synectiks.asset.repository.CloudElementSummaryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link CloudElementSummary}.
 */
@Service
public class CloudElementSummaryService {
	
	private static final Logger logger = LoggerFactory.getLogger(CloudElementSummaryService.class);
		
	@Autowired
	private CloudElementSummaryRepository cloudElementSummaryRepository;

	public Optional<CloudElementSummary> findOne(Long id) {
		logger.info("Get cloud element summary by id: {}", id);
		return cloudElementSummaryRepository.findById(id);
	}
	
	public List<CloudElementSummary> findAll() {
		logger.info("Get all cloud element summary");
		return cloudElementSummaryRepository.findAll(Sort.by(Direction.DESC, "id"));
	}
	
	public Optional<CloudElementSummary> delete(Long id) {
		logger.info("Delete cloud element summary by id: {}", id);
		Optional<CloudElementSummary> oObj = findOne(id);
		if(!oObj.isPresent()) {
			logger.warn("Id {} not found. cloud element cannot be deleted", id);
			return oObj;
		}
		cloudElementSummaryRepository.deleteById(id);
		return oObj;
	}
	
	public CloudElementSummary save(CloudElementSummary cloudElementSummary){
		logger.info("Create new cloud element summary");
		return cloudElementSummaryRepository.save(cloudElementSummary);
	}

	public List<CloudElementSummary> search(CloudElementSummary cloudElementSummary) {
		logger.info("Search cloud element summary");
		return cloudElementSummaryRepository.findAll(Example.of(cloudElementSummary), Sort.by(Direction.DESC, "id"));
	}


	@Transactional(readOnly = true)
	public List<CloudElementSummary> getCloudElementSummary(Long landingZoneId) {
		logger.debug("Get all cloud-element-summaries of a landing-zone-id {}", landingZoneId);
		return cloudElementSummaryRepository.getCloudElementSummary(landingZoneId);
	}

	@Transactional(readOnly = true)
	public CloudElementSummary findByLandingzoneId(Long landingZoneId) {
		logger.debug("Get cloud-element-summary of a landing-zone-id {}", landingZoneId);
		return cloudElementSummaryRepository.findByLandingzoneId(landingZoneId);
	}

	@Transactional(readOnly = true)
	public Integer getTotalAssetsByLandingZoneId(Long landingZoneId){
		logger.debug("Get total assets of a landing-zone from cloud-element-summary. landing-zone-id {}", landingZoneId);
		return cloudElementSummaryRepository.getTotalAssetsByLandingZoneId(landingZoneId);
	}
}
