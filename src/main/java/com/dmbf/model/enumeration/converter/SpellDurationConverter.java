package com.dmbf.model.enumeration.converter;

import javax.persistence.AttributeConverter;

import com.dmbf.model.enumeration.SpellDuration;

/**
 * 
 * @author hugosilva
 *
 */
public class SpellDurationConverter implements AttributeConverter<SpellDuration, Integer> {

	@Override
	public Integer convertToDatabaseColumn(SpellDuration theEnum) {
		return theEnum == null ? null : theEnum.getId();
	}

	@Override
	public SpellDuration convertToEntityAttribute(Integer id) {
		if (id != null) {
			for (SpellDuration enumTipo : SpellDuration.values()) {
				if (id.equals(enumTipo.getId())) {
					return enumTipo;
				}
			}
		}
		return null;
	}

}
