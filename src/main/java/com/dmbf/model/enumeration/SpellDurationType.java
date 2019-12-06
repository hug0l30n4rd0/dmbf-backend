/**
 * 
 */
package com.dmbf.model.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author hugosilva
 *
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum SpellDurationType {
	ROUND	(1,"Round"),
	MINUTE	(2,"Minute"),
	HOUR	(3,"Hour"),
	DAY		(4,"Day");
	
	private SpellDurationType(Integer id, String name) {
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
    public static SpellDurationType forValues(@JsonProperty("id") Integer id, @JsonProperty("name") String name) {
        for (SpellDurationType currEnum : SpellDurationType.values()) {
            if (Double.compare(currEnum.id, id) == 0 && currEnum.name.equals(name)) {
                return currEnum;
            }
        }
 
        return null;
    }
}