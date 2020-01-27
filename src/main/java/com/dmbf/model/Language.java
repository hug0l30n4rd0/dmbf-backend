/**
 * 
 */
package com.dmbf.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hugosilva
 *
 */
@NoArgsConstructor
@Data
@Entity(name = "tb_language")
public class Language extends BaseModel {
	
	@Column(name = "lang_name", nullable = false)
	private String name;
	
}
