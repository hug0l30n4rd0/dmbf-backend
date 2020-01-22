package com.dmbf.model.enumeration.converter;

import javax.persistence.AttributeConverter;

import com.dmbf.model.enumeration.item.ItemType;
import com.dmbf.model.enumeration.spell.SpellRange;

/**
 * 
 * @author hugosilva
 *
 */
public class SpellRangeConverter implements AttributeConverter<SpellRange, Integer> {

	@Override
	public Integer convertToDatabaseColumn(SpellRange theEnum) {
		return theEnum == null ? null : theEnum.getId();
	}

	@Override
	public SpellRange convertToEntityAttribute(Integer id) {
		if (id != null) {
			for (SpellRange enumTipo : SpellRange.values()) {
				if (id.equals(enumTipo.getId())) {
					return enumTipo;
				}
			}
		}
		return null;
	}

}
