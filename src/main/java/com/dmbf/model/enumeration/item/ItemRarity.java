/**
 * 
 */
package com.dmbf.model.enumeration.item;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author hugosilva
 *
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ItemRarity {
	MUNDANE		(1,"Mundane"),
	COMMON		(2,"Common"),
	UNCOMMON	(3,"Uncommon"),
	RARE		(4,"Rare"),
	VERY_RARE	(5,"Very Rare"),
	LEGENDARY	(6,"Legendary"),
	ARTIFACT	(7,"Artifact"),
	VARIES		(8,"Varies");
	
	
	private ItemRarity(Integer id, String name) {
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
    public static ItemRarity forValues(@JsonProperty("id") Integer id) {
        for (ItemRarity currEnum : ItemRarity.values()) {
            if (Double.compare(currEnum.id, id) == 0) {
                return currEnum;
            }
        }
 
        return null;
    }
	
	@JsonCreator
    public static ItemRarity forValues(@JsonProperty("id") String id) {
        for (ItemRarity currEnum : ItemRarity.values()) {
            if (Double.compare(currEnum.id, Integer.valueOf(id)) == 0) {
                return currEnum;
            }
        }
 
        return null;
    }

	
}