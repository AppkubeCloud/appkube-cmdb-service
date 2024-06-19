package com.synectiks.asset.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import software.amazon.awssdk.regions.Region;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AwsHelperController {

	private final Logger logger = LoggerFactory.getLogger(AwsHelperController.class);

    @RequestMapping(value = "/aws-regions", method = RequestMethod.GET)
    public List<String> getAwsRegions(){
        logger.info("Request to get aws regions");
        List<String> regions = new ArrayList<>();
        for (Region region : Region.regions()) {
            regions.add(region.id());
        }
        return regions;
    }

    
}
