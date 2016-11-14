package models;
import play.*;
import play.data.format.Formats;
import play.data.validation.Constraints;

import javax.persistence.*;

import com.avaje.ebean.Model;
import com.avaje.ebean.PagedList;
import com.avaje.ebean.Model.Find;

import java.util.*;

@Entity
public class discoduro extends com.avaje.ebean.Model {
	
	private static final long serial = 1L;

	@Id
	public Long id;

	
	public int serie;

	
	public int peso;


	@ManyToOne
	public Computer computer;

	public static Find<Long, discoduro> find = new Find<Long, discoduro>() {
	};

	public static PagedList<discoduro> page(int page, int pageSize,
			String sortBy, String order, String filter) {
		System.out.println("filter:" + filter);
		return find.where().ilike("name", "%" + filter + "%")
				.orderBy(sortBy + " " + order).fetch("computer")
				.findPagedList(page, pageSize);

	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


}


