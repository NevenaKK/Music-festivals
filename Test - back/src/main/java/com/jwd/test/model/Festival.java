package com.jwd.test.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Festival {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(unique = true, nullable = false)
    private String naziv;
	
	@OneToMany(mappedBy = "festival" , cascade = CascadeType.ALL)
	private List<Nastup> nastupi;

	public Festival(Long id, String naziv, List<Nastup> nastupi) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.nastupi = nastupi;
	}

	public Festival(String naziv, List<Nastup> nastupi) {
		super();
		this.naziv = naziv;
		this.nastupi = nastupi;
	}

	public Festival() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Festival other = (Festival) obj;
		return Objects.equals(id, other.id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Nastup> getNastupi() {
		return nastupi;
	}

	public void setNastupi(List<Nastup> nastupi) {
		this.nastupi = nastupi;
	}

	@Override
	public String toString() {
		return "Festival [id=" + id + ", naziv=" + naziv  + "]";
	}

	
	
}
