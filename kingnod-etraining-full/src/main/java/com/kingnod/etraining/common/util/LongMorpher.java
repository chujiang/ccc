package com.kingnod.etraining.common.util;


import org.apache.commons.lang.xwork.StringUtils;

import net.sf.ezmorph.MorphException;
import net.sf.ezmorph.Morpher;

public class LongMorpher implements Morpher {

	public Class morphsTo() {
		return Long.class;
	}

	public boolean supports(Class clazz) {
		return String.class.isAssignableFrom( clazz ) || Integer.class.isAssignableFrom(clazz);
	}
	
	public Object morph( Object value )
	   {
	      if( value == null || StringUtils.isEmpty(value.toString())){
	         return null;
	      }

	      if( Long.class.isAssignableFrom( value.getClass() ) ){
	         return (Long) value;
	      }

	      if( !supports( value.getClass() ) ){
	         throw new MorphException( value.getClass() + " is not supported" );
	      }

	      return Long.valueOf(value.toString());

	   }

}
