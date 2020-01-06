/**
 * 
 */
package com.dmbf.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.data.rest.core.annotation.RestResource;

import com.dmbf.model.enumeration.RangeMetric;
import com.dmbf.model.enumeration.SpellCastingTime;
import com.dmbf.model.enumeration.SpellDuration;
import com.dmbf.model.enumeration.SpellDurationType;
import com.dmbf.model.enumeration.SpellRange;
import com.dmbf.model.enumeration.SpellSchool;
import com.dmbf.model.enumeration.converter.RangeMetricConverter;
import com.dmbf.model.enumeration.converter.SpellCastingTimeConverter;
import com.dmbf.model.enumeration.converter.SpellDurationConverter;
import com.dmbf.model.enumeration.converter.SpellDurationTypeConverter;
import com.dmbf.model.enumeration.converter.SpellRangeConverter;
import com.dmbf.model.enumeration.converter.SpellSchoolConverter;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hugosilva
 *
 */
@NoArgsConstructor
@Data
@Entity(name = "tb_spell")
public class Spell extends BaseModel {
	@Column(name = "spell_name", nullable = false)
	private String name;
	
	@Column(name = "spell_description", columnDefinition = "TEXT", nullable = false)
	private String description;
	
	@Column(name = "spell_level", nullable = false)
	private Integer level;
	
	@Column(name = "spell_school", nullable = false)
	@Convert(converter = SpellSchoolConverter.class)
	private SpellSchool school;
	
	@Column(name = "spell_casting_time", nullable = false)
	@Convert(converter = SpellCastingTimeConverter.class)
	private SpellCastingTime castingTime;
	
	@Column(name = "spell_casting_value", nullable = true)
	private String castingValue;
	
	@Column(name = "spell_range", nullable = false)
	@Convert(converter = SpellRangeConverter.class)
	private SpellRange range;
	
	@Column(name = "spell_range_distance", nullable = true)
	private Integer rangeDistance;
	
	@Column(name = "spell_range_metric", nullable = true)
	@Convert(converter = RangeMetricConverter.class)
	private RangeMetric rangeMetric;
	
	@Column(name = "spell_area", nullable = true)
	private String area;
	
	@Column(name = "spell_duration", nullable = false)
	@Convert(converter = SpellDurationConverter.class)
	private SpellDuration duration;
	
	@Column(name = "spell_duration_value", nullable = true)
	private Integer durationValue;
	
	@Column(name = "spell_duration_type", nullable = true)
	@Convert(converter = SpellDurationTypeConverter.class)
	private SpellDurationType durationType;
	
	@Column(name = "spell_is_verbal", nullable = false)
	private Boolean isVerbal;
	
	@Column(name = "spell_is_somatic", nullable = false)
	private Boolean isSomatic;
	
	@Column(name = "spell_is_material", nullable = false)
	private Boolean isMaterial;

	@Column(name = "spell_components", nullable = true)
	private String components;
	
	@Column(name = "spell_is_ritual", nullable = false)
	private Boolean isRitual;
	
	@Column(name = "spell_is_concentration", nullable = false)
	private Boolean isConcentration;
	
	@Column(name = "spell_source_page", nullable = true)
	private Integer sourcePage;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="source_id", nullable=false)
	@RestResource(exported = false)
	private Source source;
	
	@ManyToMany(mappedBy="allSpells")
	private List<GameClass> gameClasses;
	

	
}
