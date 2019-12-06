package com.dmbf.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.transaction.annotation.Transactional;

import com.dmbf.exception.AtributoNaoEncontradoException;
import com.dmbf.exception.ErroInternoException;
import com.dmbf.exception.OrdenadorInvalidoException;
import com.dmbf.exception.ParametroInvalidoException;
import com.dmbf.model.BaseModel;

public abstract class BaseService<R extends JpaRepository, M extends BaseModel> {

	private final Logger log = (Logger) LoggerFactory.getLogger(this.getClass());
	
	/**
	 * Bean para acesso à base de dados usando Object-Relational Mapping ({@link JpaRepository})
	 */
	@Autowired
	protected R dao;
	
	/**
	 * 
	 */
	protected Class entityServiceType;
	
	/**
	 * Método abstrato que obriga uma implementação que retorne a classe de M
	 * @return classe de M
	 */
	public abstract Class getEntityType();
	
	
	@Transactional(readOnly = true)
	public Page<M> todos(int paginaAtual, int tamanhoPagina, String[] ordenador) throws OrdenadorInvalidoException, ParametroInvalidoException, AtributoNaoEncontradoException, ErroInternoException {
		return  this.todos(0, tamanhoPagina, ordenador);
	}
	
	/**
	 * Método que retorna todos os objetos de uma entidade contidos em um objeto Page 
	 * @param paginaAtual determina qual página deve ser retornada. A paginação vai de 0 (zero) até o tamanho máximo menos 1 a depender do tamanho da página e da quantidade de objetos na base de dados.
	 * @param tamanhoPagina determina o tamanho da página que será retornada.
	 * @param ordenador vetor de Strings contendo o nome dos atributos de Municipio que são utilizados para ordenação. O nome do atributo deve vir concatenado com o sinal de '+' para ordenação ascendente e '-' para ordenação descendente. A ordem dos atributos no array será mantida na busca. 
	 * @return todos os objetos contidos em um objeto Page
	 * @throws OrdernadorInvalidoException 
	 * @throws ParametroInvalidoException 
	 * @throws AtributoNaoEncontradoException 
	 * @throws ErroInternoException 
	 * @see Page
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public Page<M> todos(int paginaInicial, int paginaAtual, int tamanhoPagina, String[] ordenador) throws OrdenadorInvalidoException, ParametroInvalidoException, AtributoNaoEncontradoException, ErroInternoException {
		paginaAtual = paginaAtual - paginaInicial; //se a pagina inicial for 1 ao inves de 0 ele ajusta para trabalhar iniciando do 0. Se ja for 0 n tem efeito.
		if(paginaAtual < 0){
			throw new ParametroInvalidoException("paginaAtual não pode ser menor que zero!", paginaAtual);
		}
		if(tamanhoPagina < 0){
			throw new ParametroInvalidoException("tamanhoPagina não pode ser menor que zero!", tamanhoPagina);
		} else if(tamanhoPagina == 0){
			tamanhoPagina = (int) dao.count();
		}
		
		/**
		 * @TODO implementar o suporte a ordenacao
		 */
//		List<Order> ordenadores = new ArrayList<Order>();
//
//		if (ordenador == null || ordenador.length == 0) {
//			ordenador = new String[1];
//			ordenador[0] = ConstantesGlobal.PAGINACAO_ORDENADOR_PADRAO;
//			ordenadores = Util.prepararOrdenador(ordenador);
//		} else {
//			ordenadores = Util.prepararOrdenador(ordenador);
//		}
//		for(Order ordenadorAux : ordenadores){
//			if(!Util.verificarAtributo(ordenadorAux.getProperty(), getEntityType())){
//				throw new AtributoNaoEncontradoException("atributo não encontrado", ordenadorAux.getProperty());
//			}
//		}
		try{
			Pageable pageable =  PageRequest.of(paginaAtual, tamanhoPagina);//, Sort.by("price").descending().and(Sort.by("name")));
			
			return dao.findAll(pageable);
		} catch (PropertyReferenceException e) {
			throw new AtributoNaoEncontradoException("atributo não encontrado", e.getPropertyName());
		} catch (TransactionSystemException e) {
			log.error("erro não tratado pela aplicação. Detalhes:");
			log.error("AbstractService.todos");
			log.error(e.getMessage());
			throw new ErroInternoException();
		} catch (IllegalArgumentException e) {
			throw new AtributoNaoEncontradoException("atributo não encontrado", "");
		} catch (Exception e) {
			log.error("erro não tratado pela aplicação. Detalhes:");
			log.error("AbstractService.todos");
			log.error(e.getMessage());
			throw new ErroInternoException();
		}
		
	}
	
	@Transactional(readOnly = true)
	public Long total() {
		return  dao.count();
	}
	
}