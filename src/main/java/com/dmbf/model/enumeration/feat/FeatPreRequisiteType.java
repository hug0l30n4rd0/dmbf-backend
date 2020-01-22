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
public enum FeatPreRequisiteType {
	OTHER		(1,"Other"),
	ABILITY		(2,"Ability"),
	LEVEL		(3,"Level"),
	PROFICIENCY	(4,"Proficiency"),
	RACE		(5,"Race"),
	SIZE		(6,"Size");
	
	
	private FeatPreRequisiteType(Integer id, String name) {
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
	public static FeatPreRequisiteType forValues(@JsonProperty("id") Integer id) {
		for (FeatPreRequisiteType currEnum : FeatPreRequisiteType.values()) {
			if (Double.compare(currEnum.id, id) == 0) {
				return currEnum;
			}
		}
		
		return null;
	}
	
	@JsonCreator
    public static FeatPreRequisiteType forValues(@JsonProperty("id") String id) {
        for (FeatPreRequisiteType currEnum : FeatPreRequisiteType.values()) {
            if (Double.compare(currEnum.id, Integer.valueOf(id)) == 0) {
                return currEnum;
            }
        }
 
        return null;
    }
	
	

}