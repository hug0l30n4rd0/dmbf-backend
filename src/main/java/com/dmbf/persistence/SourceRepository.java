package com.dmbf.persistence;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.dmbf.model.Source;
/**
 * 
 * @author hugosilva
 *
 */
@RepositoryRestResource(collectionResourceRel = "source", path = "source")
public interface SourceRepository extends PagingAndSortingRepository<Source, Long> {
	
}