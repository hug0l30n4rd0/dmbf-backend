/**
 * 
 */
package com.dmbf.model.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author hugosilva
 *
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum SpellLevel {
	CANTRIP	(1,"Cantrip"),
	FIRST	(2,"1st"),
	SECOND	(3,"2nd"),
	THIRD	(4,"3rd"),
	FOURTH	(5,"4th"),
	FIFTH	(6,"5th"),
	SIXTH	(7,"6th"),
	SEVENTH	(8,"7th"),
	EIGHTH	(9,"8th"),
	NINETH	(10,"9th");
	
	
	private SpellLevel(Integer id, String name) {
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
    public static SpellLevel forValues(@JsonProperty("id") Integer id, @JsonProperty("name") String name) {
        for (SpellLevel currEnum : SpellLevel.values()) {
            if (Double.compare(currEnum.id, id) == 0 && currEnum.name.equals(name)) {
                return currEnum;
            }
        }
 
        return null;
    }
}