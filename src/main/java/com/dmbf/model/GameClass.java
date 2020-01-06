package com.dmbf.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;


@Data
@Entity(name = "tb_gameclass")
public class GameClass extends BaseModel {

	@Column(name = "class_name", nullable = false)
	private String name;

	@ManyToMany
	@JoinTable(name = "gameclass_has_spell", joinColumns = {
			@JoinColumn(name = "gameclass_id") }, inverseJoinColumns = { @JoinColumn(name = "spell_id") })
	private List<Spell> allSpells;

}
