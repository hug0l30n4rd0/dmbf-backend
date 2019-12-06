package com.dmbf.persistence;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.dmbf.model.Item;

/**
 * 
 * @author hugosilva
 *
 */
@RepositoryRestResource(collectionResourceRel = "item", path = "item")
public interface ItemRepository extends PagingAndSortingRepository<Item, Long> {

   //List<Item> findByLastName(@Param("name") String name);

}