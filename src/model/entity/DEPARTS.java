package model.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DEPARTS")
public class DEPARTS {
	@Id
	@Column(name = "Id")
	private String id;
	@Column(name = "Name")
	private String name;
	@OneToMany(mappedBy = "depart", fetch = FetchType.EAGER)
	private Collection<STAFFS> staffs;
	public DEPARTS() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DEPARTS(String id, String name, Collection<STAFFS> staffs) {
		super();
		this.id = id;
		this.name = name;
		this.staffs = staffs;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Collection<STAFFS> getStaffs() {
		return staffs;
	}
	public void setStaffs(Collection<STAFFS> staffs) {
		this.staffs = staffs;
	}


}
