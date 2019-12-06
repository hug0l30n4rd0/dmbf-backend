/**
 * 
 */
package com.dmbf.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dmbf.model.Feat;
import com.dmbf.model.Item;
import com.dmbf.model.Spell;
import com.dmbf.persistence.FeatRepository;
import com.dmbf.persistence.ItemRepository;
import com.dmbf.persistence.SpellRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.Api;


/**
 * @author hugosilva
 *
 */
//@PreAuthorize("hasIpAddress('192.168.1.0/24')")
@Api(value = "import")
@RestController
@RequestMapping(value="/import")
public class ImportController {
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private FeatRepository featRepository;
	
	@Autowired
	private SpellRepository spellRepository;

	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/item", method =  RequestMethod.POST)
    public List<Item> item(@Valid @RequestBody String json)
    {
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {

            List<Item> list = Arrays.asList(mapper.readValue(json, Item[].class));

            for (Item i : list) {
            	itemRepository.save(i);
            }
            
            return  list;
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return null;
    }
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/feat", method =  RequestMethod.POST)
    public List<Feat> feat(@Valid @RequestBody String json)
    {
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
		
		try {
            
            List<Feat> list = Arrays.asList(mapper.readValue(json, Feat[].class));
            
            for (Feat i : list) {
            	featRepository.save(i);
            }
            
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return null;
    }
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/spell", method =  RequestMethod.POST)
    public List<Spell> spell(@Valid @RequestBody String json)
    {
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
		
		try {
            
            List<Spell> list = Arrays.asList(mapper.readValue(json, Spell[].class));
            
            for (Spell i : list) {
            	spellRepository.save(i);
            }
            
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return null;
    }
	
	
	
}
