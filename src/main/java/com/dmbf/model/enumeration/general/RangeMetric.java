/**
 * 
 */
package com.dmbf.model.enumeration.general;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author hugosilva
 *
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum RangeMetric {
	FEET		(1,"Feet"),
	MILE		(2,"Mile");
	
	
	private RangeMetric(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	private Integer id;
	private String name;
	
//	@JsonValue
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
	@JsonCreator
    public static RangeMetric forValues(@JsonProperty("id") String id) {
		for (RangeMetric currEnum : RangeMetric.values()) {
            if (Integer.compare(currEnum.id, Integer.valueOf(id)) == 0) {
                return currEnum;
            }
        }
 
        return null;
    }
}