package com.dmbf.persistence;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.dmbf.model.Spell;

/**
 * 
 * @author hugosilva
 *
 */
@RepositoryRestResource(collectionResourceRel = "spell", path = "spell")
public interface SpellRepository extends PagingAndSortingRepository<Spell, Long> {

}