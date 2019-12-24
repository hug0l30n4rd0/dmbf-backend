/**
 * 
 */
package com.dmbf.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author hugosilva
 *
 */
@NoArgsConstructor
@Data
@Entity(name = "tb_source")
public class Source extends BaseModel {
	
	@Column(name = "source_name", nullable = false)
	private String name;
	
	@Column(name = "source_shortname", nullable = false, length = 5)
	private String shortName;
	
	@Column(name = "source_official", nullable = false)
	private Boolean isOfficial;
	
	public Source(Long id) {
		this.setId(id);
	}
}
