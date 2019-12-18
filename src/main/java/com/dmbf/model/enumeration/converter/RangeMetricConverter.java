package com.dmbf.model.enumeration.converter;

import javax.persistence.AttributeConverter;

import com.dmbf.model.enumeration.RangeMetric;

/**
 * 
 * @author hugosilva
 *
 */
public class RangeMetricConverter implements AttributeConverter<RangeMetric, Integer> {

	@Override
	public Integer convertToDatabaseColumn(RangeMetric theEnum) {
		return theEnum == null ? null : theEnum.getId();
	}

	@Override
	public RangeMetric convertToEntityAttribute(Integer id) {
		if (id != null) {
			for (RangeMetric enumTipo : RangeMetric.values()) {
				if (id.equals(enumTipo.getId())) {
					return enumTipo;
				}
			}
		}
		return null;
	}

}
