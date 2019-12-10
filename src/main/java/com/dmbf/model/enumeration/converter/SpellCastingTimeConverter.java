package com.dmbf.model.enumeration.converter;

import javax.persistence.AttributeConverter;

import com.dmbf.model.enumeration.SpellCastingTime;

/**
 * 
 * @author hugosilva
 *
 */
public class SpellCastingTimeConverter implements AttributeConverter<SpellCastingTime, Integer> {

	@Override
	public Integer convertToDatabaseColumn(SpellCastingTime theEnum) {
		return theEnum.getId();
	}

	@Override
	public SpellCastingTime convertToEntityAttribute(Integer id) {
		if (id != null) {
			for (SpellCastingTime enumTipo : SpellCastingTime.values()) {
				if (id.equals(enumTipo.getId())) {
					return enumTipo;
				}
			}
		}
		return null;
	}

}
