package com.dmbf.model;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.codehaus.jackson.annotate.JsonProperty;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Abstract Class inherited by all system entities
 * 
 * Implements an attribute 'Id' used as primary key 
 * 
 * @author hugosilva
 *
 */
@MappedSuperclass
public abstract class BaseModel  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
//	@Version
//	private Integer version;
	
	/*
	 * Método abstrato que define quais atributos da classe podem ser usados como filtro numa pesquisa
	 * Retorna uma mapa com <NomeDoAtributo, Valor> que é automaticamente utilizado em CoreRepositoryImpl 
	 * para criar uma clausula Where com os valores 
	 */
	//public abstract Map<String, Object> getFilterParams();
	
	/*
	 * Getters & Setters
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getCod() {
		return this.getId();
	} 
	
	
	@Override
	public boolean equals(Object obj) {
		if (obj != null && this.getClass().equals(obj.getClass())) {
			if (this.getId()!=null && this.getId() == ((BaseModel) obj).getId()) {
				return true;
			}
		}
		return false;
	}
	
	public void reset() {
		this.setId(0L);
		
//		Class theClass = this.getClass();
//		Field[] fields = theClass.getDeclaredFields();
//		for(Field field : fields) {
//			if (!field.getName().equals("serialVersionUID")) {
//				field.setAccessible(Boolean.TRUE);
//				try {
//					field.set(this, null);
//				} catch (IllegalArgumentException | IllegalAccessException e) {
//					e.printStackTrace();
//				}
//			}
//		}
		
		for (Field field : getFilterParams()) {
			try {
				field.set(this, null);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
	
	@JsonIgnore
	public Field[] getFilterParams() {
		ArrayList<Field> fieldsList = new ArrayList<Field>();
		Class theClass = this.getClass();
		Field[] fields = theClass.getDeclaredFields();
		for(Field field : fields) {
			if (!field.getName().equals("serialVersionUID")) {
				field.setAccessible(Boolean.TRUE);
				fieldsList.add(field);
			}
		}
		return fieldsList.toArray(new Field[fieldsList.size()]);
	} 
	
	@Override
	public String toString() {
		return getClass().getName()+ " (" + getId()+")";
	}
	
	
}
