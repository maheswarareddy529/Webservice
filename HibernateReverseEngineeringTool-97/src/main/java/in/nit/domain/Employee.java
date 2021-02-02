package in.nit.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee implements java.io.Serializable {
    @Id
	private Integer id;
	private String name;
	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}



}
