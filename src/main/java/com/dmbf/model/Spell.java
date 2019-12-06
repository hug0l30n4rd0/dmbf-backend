/**
 * 
 */
package com.dmbf.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.dmbf.model.enumeration.SpellCastingTime;
import com.dmbf.model.enumeration.SpellDuration;
import com.dmbf.model.enumeration.SpellDurationType;
import com.dmbf.model.enumeration.SpellLevel;
import com.dmbf.model.enumeration.SpellRange;
import com.dmbf.model.enumeration.SpellSchool;

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
@Entity(name = "tb_spell")
public class Spell extends BaseModel {
	@Column(name = "spell_source", nullable = true)
	private String source;
	
	@Column(name = "spell_level", nullable = false)
	private Integer level;
	
//	@Column(name = "spell_level", nullable = false)
//	private SpellSchool school;
//	
//	private SpellCastingTime castingTime;
//	
//	private String castingValue;
//	
//	private SpellRange range;
//	
//	private Integer rangeDistance;
//	
//	private SpellDuration duration;
//	
//	private Integer durationValue;
//	
//	private SpellDurationType durationType;
//	
//	private Boolean isVerbal;
//	
//	private Boolean isSomatic;
//	
//	private Boolean isMaterial;
//	
//	private String material;
//	
	
	
}
