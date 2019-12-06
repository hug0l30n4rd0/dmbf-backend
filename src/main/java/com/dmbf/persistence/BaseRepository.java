package com.dmbf.persistence;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.dmbf.model.BaseModel;

/**
 * Interface da qual todos os Repositórios de entidade devem herdar
 * 
 * É implementada por CoreRepositoryImpl seguindo as convenções de nomenclatura exigidas pelo JPARepository 
 * 
 * @author hugosilva
 *
 * @param <T> Tipo da Entidade genenciada
 * @param <ID> Tipo da chave-primária da Entidade gerenciada
 */

@NoRepositoryBean	
public interface BaseRepository<T extends BaseModel, ID extends Long> extends JpaRepository<T, ID>{
	
	/*
	 * Método responsável por receber uma entidade que será utilizada como filtro e retornar os valores
	 * que se enquadram na situação. Recebe um inicio e quantidade de modo a suportar o uso de paginação. 
	 */
	public List<T> filter(T filtro);
	
	/*
	 * Método que retorna a quantidade de tuplas que se adequam a uma consulta que utiliza uma entidade como filtro 
	 */
	public Long countFilter(T filtro);
	
	/*
	 * Método que retorna a instância do entity manager
	 */
	public EntityManager getEntityManager();

}
