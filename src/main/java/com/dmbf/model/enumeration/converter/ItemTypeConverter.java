package com.dmbf.model.enumeration.converter;

import javax.persistence.AttributeConverter;

import com.dmbf.model.enumeration.ItemType;

/**
 * 
 * @author hugosilva
 *
 */
public class ItemTypeConverter implements AttributeConverter<ItemType, Integer> {

	@Override
	public Integer convertToDatabaseColumn(ItemType theEnum) {
		return theEnum.getId();
	}

	@Override
	public ItemType convertToEntityAttribute(Integer id) {
		if (id != null) {
			for (ItemType enumTipo : ItemType.values()) {
				if (id.equals(enumTipo.getId())) {
					return enumTipo;
				}
			}
		}
		return null;
	}

}
