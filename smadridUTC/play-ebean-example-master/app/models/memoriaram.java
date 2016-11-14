package models;

import play.*;

import javax.persistence.*;

import com.avaje.ebean.Model;

import java.util.*;

@Entity
public class memoriaram extends com.avaje.ebean.Model {
	
	private static final long serialVersionUID = 1L;

	@Id
	public Long id;
 
	 public Integer capacidad;
	 public Integer tamaño;
	  
}
