/**
 * 
 */
package com.dmbf.config;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.stereotype.Component;

import com.dmbf.model.GameClass;
import com.dmbf.model.Source;
import com.dmbf.model.Spell;

/**
 * @author hugosilva
 *
 */
@Component
public class ExposeIdsConfiguration extends RepositoryRestConfigurerAdapter {

  @Override
  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
    config.exposeIdsFor(
    		Spell.class, 
    		Source.class, 
    		GameClass.class);
  }
}
