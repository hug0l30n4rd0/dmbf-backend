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
public enum Ability {
	STRENGTH		(1,"Strength","STR"),
	DEXTERITY		(2,"Dexterity","DEX"),
	CONSTITUTION	(3,"Constitution","CON"),
	INTELLIGENCE	(4,"Intelligence","INT"),
	WISDOM			(5,"Wisdom","WIS"),
	CHARISMA		(6,"Charisma","CHA");
	
	
	private Ability(Integer id, String name, String shortName) {
		this.id = id;
		this.name = name;
		this.shortName = shortName;
	}
	
	private Integer id;
	private String name;
	private String shortName;
	
//	@JsonValue
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	public String getShortName() {
		return shortName;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
	@JsonCreator
    public static Ability forValues(@JsonProperty("id") String id) {
		for (Ability currEnum : Ability.values()) {
            if (Integer.compare(currEnum.id, Integer.valueOf(id)) == 0) {
                return currEnum;
            }
        }
 
        return null;
    }
}