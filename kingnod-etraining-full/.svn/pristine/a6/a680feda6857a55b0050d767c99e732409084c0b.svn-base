package com.kingnod.etraining.common.util;

import java.util.Date;

import org.apache.commons.lang.xwork.StringUtils;

import net.sf.ezmorph.MorphException;
import net.sf.ezmorph.Morpher;

public class TimeMorpher implements Morpher {

	public Class morphsTo() {
		return java.sql.Time.class;
	}

	public boolean supports(Class clazz) {
		return String.class.isAssignableFrom( clazz );
	}
	
	public Object morph( Object value )
	   {
	      if( value == null || StringUtils.isEmpty(value.toString())){
	         return null;
	      }

	      if( Date.class.isAssignableFrom( value.getClass() ) ){
	         return (Date) value;
	      }

	      if( !supports( value.getClass() ) ){
	         throw new MorphException( value.getClass() + " is not supported" );
	      }

	      return java.sql.Time.valueOf(value.toString());

	   }

}
