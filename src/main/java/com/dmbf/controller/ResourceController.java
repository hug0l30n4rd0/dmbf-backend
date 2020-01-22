/**
 * 
 */
package com.dmbf.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dmbf.model.enumeration.item.ItemRarity;
import com.dmbf.model.enumeration.item.ItemType;
import com.dmbf.model.enumeration.spell.SpellCastingTime;
import com.dmbf.model.enumeration.spell.SpellDuration;
import com.dmbf.model.enumeration.spell.SpellDurationType;
import com.dmbf.model.enumeration.spell.SpellRange;
import com.dmbf.model.enumeration.spell.SpellSchool;

import io.swagger.annotations.Api;


/**
 * @author hugosilva
 *
 */
//@PreAuthorize("hasIpAddress('192.168.1.0/24')")
@Api(value = "resource")
@RestController
@RequestMapping(value="/resource")
public class ResourceController {
//	@Autowired
//	private ItemService service;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(
			value="/item-rarity",
			method=RequestMethod.GET,
			produces="application/json"
			)	
	public ItemRarity[] getItemRarities() {
		return ItemRarity.values();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(
			value="/item-type",
			method=RequestMethod.GET,
			produces="application/json"
			)	
	public ItemType[] getItemTypes() {
		return ItemType.values();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(
			value="/spell-casting-time",
			method=RequestMethod.GET,
			produces="application/json"
			)	
	public SpellCastingTime[] getSpellCastingTime() {
		return SpellCastingTime.values();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(
			value="/spell-duration",
			method=RequestMethod.GET,
			produces="application/json"
			)	
	public SpellDuration[] getSpellDuration() {
		return SpellDuration.values();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(
			value="/spell-duration-type",
			method=RequestMethod.GET,
			produces="application/json"
			)	
	public SpellDurationType[] getSpellDurationType() {
		return SpellDurationType.values();
	}
	
//	@CrossOrigin(origins = "http://localhost:3000")
//	@RequestMapping(
//			value="/spell-casting-time",
//			method=RequestMethod.GET,
//			produces="application/json"
//			)	
//	public SpellLevel[] getSpellLevel() {
//		return SpellCastingTime.values();
//	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(
			value="/spell-range",
			method=RequestMethod.GET,
			produces="application/json"
			)	
	public SpellRange[] getSpellRange() {
		return SpellRange.values();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(
			value="/spell-school",
			method=RequestMethod.GET,
			produces="application/json"
			)	
	public SpellSchool[] getSpellSchool() {
		return SpellSchool.values();
	}
	
}
