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
@Getter
@Setter
@Data
@Entity(name = "tb_feat")
public class Feat extends BaseModel {
	@Column(name = "feat_name", nullable = false)
	private String name;
	
	@Column(name = "feat_prerequisite", nullable = false)
	private String prerequisite;
	
	@Column(name = "feat_source", nullable = true)
	private String source;
}
