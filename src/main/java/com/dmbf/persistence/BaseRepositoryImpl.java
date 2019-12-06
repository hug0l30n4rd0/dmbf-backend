package com.dmbf.persistence;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.dmbf.model.BaseModel;

/**
 * Implementação da interface CoreRepository.
 *
 * Repositório genérico do qual todos os repositórios de entidades devem herdar.
 * Nele estão todos os métodos comuns aos diversos repositórios do sistema
 *
 * @author hugosilva
 *
 * @param <T> Tipo da Entidade genenciada
 * @param <ID> Tipo da chave-primária da Entidade gerenciada
 */
public class BaseRepositoryImpl<T extends BaseModel, ID extends Long> extends SimpleJpaRepository<T, ID>
		implements BaseRepository<T, ID> {

	private final EntityManager entityManager;

	/*
	 * Construtor esperado pelo SimpleJPARepository
	 */
	public BaseRepositoryImpl(JpaEntityInformation entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityManager = entityManager;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.datcrit.dmbf.persistence.BaseRepository#filter(com.datcrit.dmbf.model.
	 * BaseModel)
	 */
	public List<T> filter(T entidade) {
		CriteriaBuilder cBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> cQuery = cBuilder.createQuery(this.getDomainClass());

		Root<T> domainClass = cQuery.from(this.getDomainClass());
		cQuery.select(domainClass);

		Predicate[] predicados = getPredicates(entidade, domainClass);

		if (predicados.length > 0) {
			cQuery.where(predicados);
		}

		TypedQuery<T> query = entityManager.createQuery(cQuery);

		return query.getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.gov.inss.corewsb.persist.CoreRepository#filterSize(br.gov.inss.corewsb.
	 * persist.CoreEntity)
	 */
	public Long countFilter(T entidade) {
		CriteriaBuilder cBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> cQuery = cBuilder.createQuery(Long.class);
		Root<T> domainClass = cQuery.from(this.getDomainClass());
		cQuery.select(cBuilder.count(domainClass));
		cQuery.where(getPredicates(entidade, domainClass));
		return entityManager.createQuery(cQuery).getSingleResult();
	}

	/*
	 * Método que verifica quais campos da entidade possuem valor e cria uma lista
	 * de predicados que serão utilizados na clausula Where da consulta.
	 * 
	 * Para tal, utiliza um mapa Set<String,Object> com o nome e o valor,
	 * respectivamente, que eh retornado pela entidade que esta sendo consultada
	 * atraves do metodo getFilterParams() de CoreEntity
	 */
	private Predicate[] getPredicates(T entidade, Root<T> domainClass) {
		CriteriaBuilder cBuilder = entityManager.getCriteriaBuilder();
		List<Predicate> condicoes = new ArrayList<Predicate>();

		try {
			for (Field field : entidade.getFilterParams()) {
				Object value = field.get(entidade);
				if (value != null) {
					if (value instanceof String) {
						condicoes.add(cBuilder.like(cBuilder.lower(domainClass.get(field.getName())),
								"%" + ((String) value).toLowerCase() + "%"));
					} else if (value instanceof Collection) {
						for (Object o : (Collection) value) {
							condicoes.add(cBuilder.isMember(o, domainClass.get(field.getName())));
						}
					} else {
						condicoes.add(cBuilder.equal(domainClass.get(field.getName()), value));
					}
				}
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return condicoes.toArray(new Predicate[] {});
	}

	/*
	 * (non-Javadoc)
	 * @see com.datcrit.dmbf.persistence.BaseRepository#getEntityManager()
	 */
	public EntityManager getEntityManager() {
		return this.entityManager;
	}
}