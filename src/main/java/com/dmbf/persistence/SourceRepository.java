package com.dmbf.persistence;

import java.awt.print.Book;

import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import com.dmbf.model.Source;
/**
 * 
 * @author hugosilva
 *
 */
@RepositoryRestResource(collectionResourceRel = "source", path = "source")
public interface SourceRepository extends PagingAndSortingRepository<Source, Long> {
	
}