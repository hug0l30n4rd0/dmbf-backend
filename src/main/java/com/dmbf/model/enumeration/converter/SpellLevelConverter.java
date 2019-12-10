package com.dmbf.model.enumeration.converter;

import javax.persistence.AttributeConverter;

import com.dmbf.model.enumeration.SpellLevel;

/**
 * 
 * @author hugosilva
 *
 */
public class SpellLevelConverter implements AttributeConverter<SpellLevel, Integer> {

	@Override
	public Integer convertToDatabaseColumn(SpellLevel theEnum) {
		return theEnum.getId();
	}

	@Override
	public SpellLevel convertToEntityAttribute(Integer id) {
		if (id != null) {
			for (SpellLevel enumTipo : SpellLevel.values()) {
				if (id.equals(enumTipo.getId())) {
					return enumTipo;
				}
			}
		}
		return null;
	}

}
