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
public enum SpellDuration {
	CONCENTRATION		(1,"Concentration"),
	INSTANTANEOUS		(2,"Instantaneous"),
	SPECIAL				(3,"Special"),
	TIME				(4,"Time"),
	UNTIL_DISPELLED		(5,"Until Dispelled"),
	DISPELL_OR_TRIGGER	(6,"Until Dispelled or Triggered");
	
	private SpellDuration(Integer id, String name) {
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
    public static SpellDuration forValues(@JsonProperty("id") String id) {
		for (SpellDuration currEnum : SpellDuration.values()) {
            if (Integer.compare(currEnum.id, Integer.valueOf(id)) == 0) {
                return currEnum;
            }
        }
 
        return null;
    }
}