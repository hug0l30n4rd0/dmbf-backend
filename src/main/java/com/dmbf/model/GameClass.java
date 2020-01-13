package com.dmbf.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Data;


@Data
@Entity(name = "tb_gameclass")
public class GameClass extends BaseModel {

	@Column(name = "class_name", nullable = false)
	private String name;
	
	@Column(name = "class_shortname", nullable = false)
	private String shortName;
	

//	@ManyToMany
//	@JoinTable(name = "gameclass_has_spell", joinColumns = {
//			@JoinColumn(name = "gameclass_id") }, inverseJoinColumns = { @JoinColumn(name = "spell_id") })
//	private List<Spell> allSpells;

}
