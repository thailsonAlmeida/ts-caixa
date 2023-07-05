package com.caixa.demo.dto;

import java.io.Serializable;

import com.caixa.demo.entities.Physical;

public class PhysicalDTO implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	private Long id;	
	private String namePerson;
	private String addressPerson;
	private double incomePerson;
	private boolean situationPerson;
	private String cpf;
	private boolean pType;
	
	public PhysicalDTO() {}	
	
	public PhysicalDTO(Long id, String namePerson, String addressPerson, double incomePerson, boolean situationPerson,
			String cpf, boolean pType) {
		super();
		this.id = id;
		this.namePerson = namePerson;
		this.addressPerson = addressPerson;
		this.incomePerson = incomePerson;
		this.situationPerson = situationPerson;		
		this.cpf = cpf;
		this.pType = pType;
	}
	
	public PhysicalDTO(Physical entity) {
		this.id = entity.getId();
		this.namePerson = entity.getNamePerson();
		this.addressPerson = entity.getAddressPerson();
		this.incomePerson = entity.getIcomePerson();
		this.situationPerson = entity.isSituationPerson();
		this.cpf = entity.getCpf();
		this.pType = entity.ispType();		
	}

	public boolean ispType() {
		return pType;
	}

	public void setpType(boolean pType) {
		this.pType = pType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNamePerson() {
		return namePerson;
	}

	public void setNamePerson(String namePerson) {
		this.namePerson = namePerson;
	}

	public String getAddressPerson() {
		return addressPerson;
	}

	public void setAddressPerson(String addressPerson) {
		this.addressPerson = addressPerson;
	}

	public double getIncomePerson() {
		return incomePerson;
	}

	public void setIncomePerson(double incomePerson) {
		this.incomePerson = incomePerson;
	}

	public boolean isSituationPerson() {
		return situationPerson;
	}

	public void setSituationPerson(boolean situationPerson) {
		this.situationPerson = situationPerson;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
	

}
