/**
 * 
 */
package com.dmbf.model.enumeration.feat;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author hugosilva
 *
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum FeatModifierType {
	ADVANTAGE		(1,"Other"),
	BONUS		(2,"Ability"),
	CARRYING_CAPACITY		(3,"Level"),
	DAMAGE	(4,"Proficiency"),
	DISADVANTAGE		(5,"Race"),
	EXPERTISE		(5,"Race"),
	SPELL		(6,"Size");
	
	
	private FeatModifierType(Integer id, String name) {
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
	public static FeatModifierType forValues(@JsonProperty("id") Integer id) {
		for (FeatModifierType currEnum : FeatModifierType.values()) {
			if (Double.compare(currEnum.id, id) == 0) {
				return currEnum;
			}
		}
		
		return null;
	}
	
	@JsonCreator
    public static FeatModifierType forValues(@JsonProperty("id") String id) {
        for (FeatModifierType currEnum : FeatModifierType.values()) {
            if (Double.compare(currEnum.id, Integer.valueOf(id)) == 0) {
                return currEnum;
            }
        }
 
        return null;
    }
	
	

}