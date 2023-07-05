package com.caixa.demo.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;


@Entity
public class Physical extends Person {
	private static final long serialVersionUID = 1L;
	
	@Column(name="registro")
	private String cpf;
	private boolean pType;
	
	public Physical() {	}
	
	public Physical(Long id, String namePerson, String addressPerson, double incomePerson,
			boolean situationPerson, boolean pType, String cpf) {
		super();
		this.id = id;
		this.namePerson = namePerson;
		this.addressPerson = addressPerson;
		this.incomePerson = incomePerson;
		this.situationPerson = situationPerson;
		this.pType = pType;
		this.cpf = cpf;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}	

	public boolean ispType() {
		return pType;
	}


	public void setpType(boolean pType) {
		this.pType = pType;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Physical other = (Physical) obj;
		return Objects.equals(cpf, other.cpf);
	}
	
	

}
