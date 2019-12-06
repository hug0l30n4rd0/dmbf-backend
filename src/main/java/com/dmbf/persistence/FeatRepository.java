package com.dmbf.persistence;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.dmbf.model.Feat;

/**
 * 
 * @author hugosilva
 *
 */
@RepositoryRestResource(collectionResourceRel = "feat", path = "feat")
public interface FeatRepository extends PagingAndSortingRepository<Feat, Long> {

}