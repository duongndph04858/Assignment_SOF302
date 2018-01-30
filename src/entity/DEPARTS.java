package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DEPARTS")
public class DEPARTS {
	@Id
	@Column(name = "Id")
	private String Id;
	@Column(name = "Name")
	private String Name;

	public DEPARTS() {
		// TODO Auto-generated constructor stub
	}

	public DEPARTS(String id, String name) {
		super();
		Id = id;
		Name = name;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

}
