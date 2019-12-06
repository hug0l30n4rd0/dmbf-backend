package com.dmbf.model.enumeration.converter;

import javax.persistence.AttributeConverter;

import com.dmbf.model.enumeration.SpellDurationType;

/**
 * 
 * @author hugosilva
 *
 */
public class SpellDurationTypeConverter implements AttributeConverter<SpellDurationType, Integer> {

	@Override
	public Integer convertToDatabaseColumn(SpellDurationType theEnum) {
		return theEnum.getId();
	}

	@Override
	public SpellDurationType convertToEntityAttribute(Integer id) {
		for(SpellDurationType enumTipo : SpellDurationType.values()) {
			if (id.equals(enumTipo.getId())) {
				return enumTipo;
			}
		}
		return null;
	}

}
