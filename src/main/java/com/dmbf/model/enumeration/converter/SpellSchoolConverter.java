package com.dmbf.model.enumeration.converter;

import javax.persistence.AttributeConverter;

import com.dmbf.model.enumeration.SpellSchool;

/**
 * 
 * @author hugosilva
 *
 */
public class SpellSchoolConverter implements AttributeConverter<SpellSchool, Integer> {

	@Override
	public Integer convertToDatabaseColumn(SpellSchool theEnum) {
		return theEnum.getId();
	}

	@Override
	public SpellSchool convertToEntityAttribute(Integer id) {
		for(SpellSchool enumTipo : SpellSchool.values()) {
			if (id.equals(enumTipo.getId())) {
				return enumTipo;
			}
		}
		return null;
	}

}
