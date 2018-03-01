package model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LEVELSTAFF")
public class LEVELSTAFF {
	@Id
	@Column(name = "Id")
	private int id;
	@Column(name = "Name")
	private String name;

	public LEVELSTAFF(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public LEVELSTAFF() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
