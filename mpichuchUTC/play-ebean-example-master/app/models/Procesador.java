package models;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.avaje.ebean.Model.Find;

@Entity 
public class Procesador extends com.avaje.ebean.Model {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    public Long id;
    

    public String marca;
    
    public int  capacidad ;
    public int  peso ; 
    
    
    public long calculartotal(){
    	
    	if(capacidad>peso)
    		return ((capacidad-peso)*peso);
    	else 
    	return ((peso-capacidad)*capacidad);
    	
    }

}
