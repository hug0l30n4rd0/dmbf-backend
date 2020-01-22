/**
 * 
 */
package com.dmbf.model.enumeration.spell;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author hugosilva
 *
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum SpellRange {
	SELF		(1,"Self"),
	TOUCH		(2,"Touch"),
	RANGED		(3,"Ranged"),
	SIGHT		(4,"Sight"),
	UNLIMITED	(5,"Unlimited"),
	SPECIAL		(6,"Special");
	
	
	private SpellRange(Integer id, String name) {
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
    public static SpellRange forValues(@JsonProperty("id") String id) {
		for (SpellRange currEnum : SpellRange.values()) {
            if (Integer.compare(currEnum.id, Integer.valueOf(id)) == 0) {
                return currEnum;
            }
        }
 
        return null;
    }
}