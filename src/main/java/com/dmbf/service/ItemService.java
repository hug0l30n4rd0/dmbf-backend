package com.dmbf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dmbf.model.Item;
import com.dmbf.persistence.ItemRepository;


//@Service
//public class ItemService extends BaseService<ItemRepository, Item> {
//	@Autowired
//	private ItemRepository dao;
//
//	/* (non-Javadoc)
//	 * @see br.gov.inss.services.AbstractService#getEntityType()
//	 */
//	@Override
//	public Class getEntityType() {
//		return Item.class;
//	}
//
//	/**
//	 * Método que faz a busca de {@link Cadastro} através do seu id, que é um identificador único
//	 * @param id identificador único de {@link Cadastro}
//	 * @return Page<Categoria> uma objeto de {@link Page} contendo a {@link Cadastro} encontrada
//	 */
//	@Transactional(readOnly=true)
//	public Page<Item> porId(Long id) {
//		return dao.findById(id, new PageRequest(0, 1));
//	}
//	
//	/**
//	 * 
//	 * @param id
//	 */
//	@Transactional
//	public void remover(Long id) {
//		dao.deleteById(id);
//	}
//	
//	/**
//	 * 
//	 * @param entidade
//	 * @return
//	 */
//	@Transactional
//	public Item salvar(Item entidade) {
//		return dao.saveAndFlush(entidade);
//	}
//	
//}
