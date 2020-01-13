package com.dmbf.persistence;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.dmbf.model.GameClass;
/**
 * 
 * @author hugosilva
 *
 */
@RepositoryRestResource(collectionResourceRel = "gameClass", path = "gameClass")
public interface GameClassRepository extends PagingAndSortingRepository<GameClass, Long> {
	
}