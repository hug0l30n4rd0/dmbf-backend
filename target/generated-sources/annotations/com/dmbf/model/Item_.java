package com.dmbf.model;

import com.dmbf.model.enumeration.ItemRarity;
import com.dmbf.model.enumeration.ItemType;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Item.class)
public abstract class Item_ extends com.dmbf.model.BaseModel_ {

	public static volatile SingularAttribute<Item, String> image;
	public static volatile SingularAttribute<Item, Boolean> cursed;
	public static volatile SingularAttribute<Item, Boolean> attunement;
	public static volatile SingularAttribute<Item, String> name;
	public static volatile SingularAttribute<Item, String> description;
	public static volatile SingularAttribute<Item, ItemType> type;
	public static volatile SingularAttribute<Item, ItemRarity> rarity;

}

