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
public enum SpellSchool {
	ABJURATION		(1,"Abjuration"),
	CONJURATION		(2,"Conjuration"),
	DIVINATION		(3,"Divination"),
	ENCHANTMENT		(4,"Enchantment"),
	EVOCATION		(5,"Evocation"),
	ILLUSION		(6,"illusion"),
	NECROMANCY		(7,"Necromancy"),
	TRANSMUTATION	(8,"Transmutation");
	
	
	private SpellSchool(Integer id, String name) {
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
    public static SpellSchool forValues(@JsonProperty("id") Integer id, @JsonProperty("name") String name) {
        for (SpellSchool currEnum : SpellSchool.values()) {
            if (Double.compare(currEnum.id, id) == 0 && currEnum.name.equals(name)) {
                return currEnum;
            }
        }
 
        return null;
    }
}