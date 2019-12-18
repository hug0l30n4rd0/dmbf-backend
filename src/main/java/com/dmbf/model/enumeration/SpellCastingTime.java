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
	SPECIAL			(5,"Special"),
	NO_ACTION		(6,"No Action"),
	REACTION		(7,"Reaction");
	
	
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
    public static SpellCastingTime forValues(@JsonProperty("id") String id) {
		for (SpellCastingTime currEnum : SpellCastingTime.values()) {
            if (Integer.compare(currEnum.id, Integer.valueOf(id)) == 0) {
                return currEnum;
            }
        }
 
        return null;
    }
}