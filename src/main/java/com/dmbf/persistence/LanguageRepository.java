package com.dmbf.persistence;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.dmbf.model.Language;

/**
 * 
 * @author hugosilva
 *
 */
@RepositoryRestResource(collectionResourceRel = "language", path = "language")
public interface LanguageRepository extends PagingAndSortingRepository<Language, Long> {
	
}