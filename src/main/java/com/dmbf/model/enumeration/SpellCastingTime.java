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
public enum SpellCastingTime {
	ACTION			(1,"Action"),
	BONUS_ACTION	(2,"Bonus Action"),
	HOUR			(3,"Hour"),
	MINUTE			(4,"Minute"),
	NO_ACTION		(5,"No Action"),
	REACTION		(6,"Reaction"),
	SPECIAL			(7,"Special");
	
	
	private SpellCastingTime(Integer id, String name) {
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
    public static SpellCastingTime forValues(@JsonProperty("id") Integer id, @JsonProperty("name") String name) {
        for (SpellCastingTime currEnum : SpellCastingTime.values()) {
            if (Double.compare(currEnum.id, id) == 0 && currEnum.name.equals(name)) {
                return currEnum;
            }
        }
 
        return null;
    }
}