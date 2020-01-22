package com.dmbf.model.enumeration.converter;

import javax.persistence.AttributeConverter;

import com.dmbf.model.enumeration.item.ItemRarity;

/**
 * 
 * @author hugosilva
 *
 */
public class ItemRarityConverter implements AttributeConverter<ItemRarity, Integer> {

	@Override
	public Integer convertToDatabaseColumn(ItemRarity theEnum) {
		return theEnum.getId();
	}

	@Override
	public ItemRarity convertToEntityAttribute(Integer id) {
		if (id != null) {
			for (ItemRarity enumTipo : ItemRarity.values()) {
				if (id.equals(enumTipo.getId())) {
					return enumTipo;
				}
			}
		}
		return null;
	}

}
