/**
 * 
 */
package com.dmbf.model.enumeration.item;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author hugosilva
 *
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ItemType {
	ARMOR		(1,"Armor"),
	WEAPON		(2,"Weapon"),
	SHIELD		(3,"Shield"),
	RING		(4,"Ring"),
	COLLAR		(5,"Collar/Necklace"),
	CAPE		(6,"Cape/Cloak"),
	BOOTS		(7,"Boots"),
	GLOVES		(8,"Gloves/Bracers"),
	AMMUNITION	(9,"Ammunition"),
	OTHER		(10,"Other");
	
	
	private ItemType(Integer id, String name) {
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
	public static ItemType forValues(@JsonProperty("id") Integer id) {
		for (ItemType currEnum : ItemType.values()) {
			if (Double.compare(currEnum.id, id) == 0) {
				return currEnum;
			}
		}
		
		return null;
	}
	
	@JsonCreator
    public static ItemType forValues(@JsonProperty("id") String id) {
        for (ItemType currEnum : ItemType.values()) {
            if (Double.compare(currEnum.id, Integer.valueOf(id)) == 0) {
                return currEnum;
            }
        }
 
        return null;
    }
	
	

}