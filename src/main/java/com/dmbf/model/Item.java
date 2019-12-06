/**
 * 
 */
package com.dmbf.model;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;

import com.dmbf.model.enumeration.ItemRarity;
import com.dmbf.model.enumeration.ItemType;
import com.dmbf.model.enumeration.converter.ItemRarityConverter;
import com.dmbf.model.enumeration.converter.ItemTypeConverter;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author hugosilva
 *
 */
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity(name = "tb_item")
public class Item extends BaseModel {
	
	@Column(name = "item_name", nullable = false)
	private String name;
	
	@Column(name = "item_type")
	@Convert(converter = ItemTypeConverter.class)
	private ItemType type;
	
	@Column(name = "item_rarity")
	@Convert(converter = ItemRarityConverter.class)
	private ItemRarity rarity;
	
	@Column(name = "item_attunement", nullable = false)
	private Boolean attunement;
	
	@Column(name = "item_cursed", nullable = false)
	private Boolean cursed;
	
	@Column(name = "item_image", nullable = true)
	private String image;
	
	@Column(name = "item_description", nullable = false)
	private String description;
	
	@Column(name = "item_source", nullable = true)
	private String source;

}
