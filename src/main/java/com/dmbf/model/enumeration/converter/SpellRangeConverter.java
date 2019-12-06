package com.dmbf.model.enumeration.converter;

import javax.persistence.AttributeConverter;

import com.dmbf.model.enumeration.ItemType;
import com.dmbf.model.enumeration.SpellRange;

/**
 * 
 * @author hugosilva
 *
 */
public class SpellRangeConverter implements AttributeConverter<SpellRange, Integer> {

	@Override
	public Integer convertToDatabaseColumn(SpellRange theEnum) {
		return theEnum.getId();
	}

	@Override
	public SpellRange convertToEntityAttribute(Integer id) {
		for(SpellRange enumTipo : SpellRange.values()) {
			if (id.equals(enumTipo.getId())) {
				return enumTipo;
			}
		}
		return null;
	}

}
