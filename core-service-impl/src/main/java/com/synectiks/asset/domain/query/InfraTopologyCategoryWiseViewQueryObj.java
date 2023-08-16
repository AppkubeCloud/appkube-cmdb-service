package com.synectiks.asset.domain.query;

import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;

public interface InfraTopologyCategoryWiseViewQueryObj extends Serializable{

    @Value("#{target.element_type}")
    String getElementType();

    @Value("#{target.category}")
    String getCategory();

    @Value("#{target.db_category_id}")
    Long getDbCategoryId();

    @Value("#{target.total_record}")
    Long getTotalRecord();


}
