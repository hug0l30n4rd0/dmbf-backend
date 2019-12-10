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
@Entity(name = "tb_source")
public class Source extends BaseModel {
	
	@Column(name = "source_name", nullable = true)
	private String name;
}
