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
    
    public static Find<Long,Procesador> find = new Find<Long,Procesador>(){};

    public static Map<String,String> options() {
        LinkedHashMap<String,String> options = new LinkedHashMap<String,String>();
        for(Procesador c: Procesador.find.orderBy("marca").findList()) {
            options.put(c.id.toString(), c.marca);
        }
        return options;
    }
    

}
